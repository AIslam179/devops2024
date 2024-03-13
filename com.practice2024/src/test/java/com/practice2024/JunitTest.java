package com.practice2024;

import org.junit.BeforeClass;
import org.junit.Ignore;

//import org.testng.annotations.Test;

import org.junit.Test;
import org.testng.annotations.BeforeMethod;

public class JunitTest {
	//Junit annotations: @BeforeClass @AfterClass @ Before @ After and @Test @Ignore
	@Ignore
	@Test
	public void junitExample() {
		System.out.println("We r learning junit Test");
	}
	
	@Ignore
	@Test
	public void junitExample2() {
		System.out.println("We r learning junit Test");
	}
	
	@Test
	public void junitExample3() {
		System.out.println("We r learning junit Test");
	}
	
	@BeforeMethod
	public void junitExample4() {
		System.out.println("We r learning junit Test");
	}
	
	@BeforeClass
	public void junitExample5() {
		System.out.println("We r learning junit Test");
	}
	

}
