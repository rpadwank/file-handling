package com.capgemini.files.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import com.capgemini.files.model.WordCount;

public class WordCountTest {

	private WordCount wordCount;
	
	@Test
	public void testWhenFileIsPresent() throws IOException {
		wordCount = new WordCount("test.txt");
		assertTrue(wordCount.doesExist());
	}
	
	@Test(expected = FileNotFoundException.class)
	public void testWhenFileIsNotPresent() throws IOException {
		wordCount = new WordCount("test1.txt");
		assertEquals(0, wordCount.findWordCount());
	}
	
	@Test
	public void testWhenFileIsNotEmpty() throws IOException {
		wordCount = new WordCount("test.txt");
		assertFalse(wordCount.isEmpty());
	}
	
	@Test
	public void testWhenFileIsEmpty() throws IOException {
		wordCount = new WordCount("test2.txt");
		assertTrue(wordCount.isEmpty());
	}
	
	@Test
	public void testWhenWordCountIsCorrect() throws IOException {
		wordCount = new WordCount("test.txt");
		assertEquals(9, wordCount.findWordCount());
	}

}
