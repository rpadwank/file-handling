package com.capgemini.files.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LineCount {
	private String filePath;
	private int lineCount;
	private File file;
	private BufferedReader bReader;
	public LineCount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LineCount(String filePath) throws IOException {
		super();
		this.filePath = filePath; 
		file = new File(filePath);
		
	}
	public String getPath() {
		return filePath;
	}
	public void setPath(String path) {
		this.filePath = path;
	}
	
	public int findLineCount() throws IOException 
	{
		if(doesExist())
			bReader = new BufferedReader(new FileReader(filePath));
		else
			throw new FileNotFoundException();
		while(bReader.readLine() !=null)
		{
			lineCount++;
		}
		return lineCount;
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
