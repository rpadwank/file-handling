package com.capgemini.files.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class EmployeeDeserialization {

	public Object deSerialize(String fileName) throws IOException, ClassNotFoundException
	{
		File file = new File(fileName);
		
		if(!file.exists())
			throw new FileNotFoundException();
		
		FileInputStream fileInputStream =new FileInputStream(fileName);
		ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
		
		Employee employee = (Employee)inputStream.readObject(); 
		inputStream.close();
		return employee;
	}
	
	
}
