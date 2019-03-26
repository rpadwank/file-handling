package com.capgemini.files.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import com.capgemini.files.model.LineCount;

public class LineCountTest {

	private LineCount lineCount;
	
	@Test
	public void testWhenFileIsPresent() throws IOException {
		lineCount = new LineCount("C:\\Ruchir Padwankar\\Practice\\BankAccount.java");
		assertTrue(lineCount.doesExist());
	}
	
	@Test(expected = FileNotFoundException.class)
	public void testWhenFileIsNotPresent() throws IOException {
		lineCount = new LineCount("test1.txt");
		assertEquals(0, lineCount.findLineCount());
	}
	
	@Test
	public void testWhenFileIsNotEmpty() throws IOException {
		lineCount = new LineCount("test.txt");
		assertFalse(lineCount.isEmpty());
	}
	
	@Test
	public void testWhenFileIsEmpty() throws IOException {
		lineCount = new LineCount("test2.txt");
		assertTrue(lineCount.isEmpty());
	}
	
	@Test
	public void testWhenCountIsCorrect() throws IOException {
		lineCount = new LineCount("C:\\Ruchir Padwankar\\Practice\\BankAccount.java");
		assertEquals(73, lineCount.findLineCount());
	}

}
