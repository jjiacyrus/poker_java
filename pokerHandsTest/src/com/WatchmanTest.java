package com;

import static org.junit.Assert.*;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runners.Suite.SuiteClasses;

public class WatchmanTest {

	@Test
	public void testAllTestsAreInSuites() throws Exception {
		File testRoot = new File("./src");
		File[] children = testRoot.listFiles();
		checkTestFilesAreInSuite(children);
	}

	@Test
	public void testAllTestSuitesAreInAllTests() throws Exception {
		File testRoot = new File("./src");
		File[] children = testRoot.listFiles();
		checkSuitesAreInAllTests(children);
	}

	private void checkSuitesAreInAllTests(File[] children) throws Exception {
		for (File file : children) {
			if (file.isDirectory()) {
				try {
					Class<?> suiteClass = getTestSuiteForFolder(file);
					SuiteClasses allTestSuiteAnnotation = AllTests.class
							.getAnnotation(SuiteClasses.class);
					assertTrue("The suite: " + suiteClass.getCanonicalName()
							+ " was not in all tests",
							Arrays.asList(allTestSuiteAnnotation.value())
									.contains(suiteClass));
				} catch (ClassNotFoundException e) {
					fail("There was not test suite in the " + file.getParent());
				}
				checkSuitesAreInAllTests(file.listFiles());
			}
		}
	}

	private void checkTestFilesAreInSuite(File[] children) throws Exception {
		for (File file : children) {
			if (file.isDirectory()) {
				checkTestFilesAreInSuite(file.listFiles());
			} else {
				String classPath = getClassPath(file);
				Class<?> fileClass = ClassLoader.getSystemClassLoader()
						.loadClass(classPath);
				if (isTestClass(fileClass)) {
					SuiteClasses annotation = getTestSuiteForFolder(
							file.getParentFile()).getAnnotation(
							SuiteClasses.class);
					List<Class<?>> suiteContents = Arrays.asList(annotation
							.value());
					assertTrue(fileClass.getName()
							+ " was not in a test suite, please add it",
							suiteContents.contains(fileClass));
				}
			}
		}
	}

	private boolean isTestClass(Class<?> fileClass) {
		Method[] methods = fileClass.getMethods();
		for (Method method : methods) {

			List<Annotation> methodAnnotations = Arrays.asList(method
					.getAnnotations());
			if (methodAnnotations.size() > 0) {
				if (methodAnnotations.get(0).annotationType()
						.equals(Test.class)) {
					return true;
				}
			}
		}
		return false;
	}

	private Class<?> getTestSuiteForFolder(File parentFile) throws Exception {
		String removedSrc = parentFile.getPath().replace("./src/", "");

		String suitePath = removedSrc.replace("/", ".") + ".TestSuite";
		return ClassLoader.getSystemClassLoader().loadClass(suitePath);
	}

	private String getClassPath(File file) throws Exception {
		String fileAndPackage = file.getPath().replace(".java", "");
		String removedSrc = fileAndPackage.replace("./src/", "");
		return removedSrc.replace("/", ".");
	}
}
