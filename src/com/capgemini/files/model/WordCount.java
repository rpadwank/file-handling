package com.capgemini.files.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WordCount {
	private String filePath;
	private File file;
	private int wordCount;
	private BufferedReader bReader;
	private String content;
	public WordCount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WordCount(String filePath) throws FileNotFoundException {
		super();
		this.filePath = filePath;
		file = new File(filePath);
	}
	
	public int findWordCount() throws IOException {
		if(doesExist())
			bReader = new BufferedReader(new FileReader(filePath));
		else 
			throw new FileNotFoundException();
		if(isEmpty())
			return 0;
		while((content=bReader.readLine()) !=null)
		{
			String line[] = content.trim().split(" +[^.]");
			wordCount = wordCount + line.length;
		}
		return wordCount;
	}
	public boolean doesExist() {
		// TODO Auto-generated method stub
		return file.exists();
	}
	public boolean isEmpty() {
		if(file.length() == 0)
			return true;
		else
			return false;
	}
	
	
}
