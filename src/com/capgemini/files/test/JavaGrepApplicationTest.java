package com.capgemini.files.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.junit.Test;

import com.capgemini.files.exception.FileIsEmptyException;
import com.capgemini.files.exception.StringNotFoundException;
import com.capgemini.files.model.JavaGrepApplication;

public class JavaGrepApplicationTest {

	private JavaGrepApplication javaGrepApplication;
	
	@Test
	public void testWhenStringIsFound() throws IOException, StringNotFoundException, FileIsEmptyException {
		javaGrepApplication = new JavaGrepApplication("C:\\Ruchir Padwankar\\java assignment\\assignments_io.txt");
		HashMap<Integer, String> expectedMap = new HashMap<>();
		expectedMap.put(20, "HINT:- Use Serialization and Deserialization");
		expectedMap.put(28, "HINT:- Use Serialization and Desrialization with Collection");
		assertEquals(expectedMap, javaGrepApplication.findString("Serialization"));
		
	}
	
	@Test(expected = StringNotFoundException.class)
	public void testWhenStringIsNotFound() throws IOException, StringNotFoundException, FileIsEmptyException {
		javaGrepApplication = new JavaGrepApplication("C:\\Ruchir Padwankar\\java assignment\\assignments_io.txt");
		javaGrepApplication.findString("wassup");
		
	}
	
	
	@Test
	public void testWhenFileIsPresent() throws IOException {
		javaGrepApplication = new JavaGrepApplication("C:\\Ruchir Padwankar\\java assignment\\assignments_io.txt");
		assertTrue(javaGrepApplication.doesExist());
	}
	
	@Test(expected = FileNotFoundException.class)
	public void testWhenFileIsNotPresent() throws IOException, StringNotFoundException, FileIsEmptyException {
		javaGrepApplication = new JavaGrepApplication("test1.txt");
		javaGrepApplication.findString(" ");
	}
	
	@Test(expected = FileIsEmptyException.class)
	public void testWhenFileIsEmpty() throws IOException, StringNotFoundException, FileIsEmptyException
	{
		javaGrepApplication = new JavaGrepApplication("test2.txt");
		javaGrepApplication.findString(" ");
	}
	
	

}
