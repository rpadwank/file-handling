package com.capgemini.files.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import com.capgemini.files.exception.FileIsEmptyException;
import com.capgemini.files.exception.StringNotFoundException;

public class JavaGrepApplication {

	private String filePath;
	private BufferedReader bReader;
	private HashMap<Integer, String> actualHashMap = new HashMap<>();
	private String content;
	private File file;
	private int lineCount;
	public JavaGrepApplication() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JavaGrepApplication(String filePath) throws FileNotFoundException {
		super();
		this.filePath = filePath;
		file = new File(filePath);
		
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public HashMap<Integer,String> findString(String string) throws IOException, StringNotFoundException, FileIsEmptyException
	{
		
		if(doesExist()) 
			bReader = new BufferedReader(new FileReader(filePath)); 
		else
			throw new FileNotFoundException();
		
		if(isEmpty())
			throw new FileIsEmptyException("File is empty.");
		
		while((content=bReader.readLine()) !=null)
		{
			lineCount++;
			if(content.contains(string))
			{
				actualHashMap.put(lineCount, content);
			}
			
		}
		if(actualHashMap.isEmpty())
			throw new StringNotFoundException("The string was not found");
		return actualHashMap;
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
