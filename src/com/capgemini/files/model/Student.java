package com.capgemini.files.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Student implements Serializable {

	private int rollNumber;
	private String studentName;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(int rollNumber, String studentName) {
		super();
		this.rollNumber = rollNumber;
		this.studentName = studentName;
	}
	
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public boolean serialization(String fileName, Object obj) throws IOException
	{
		FileOutputStream fileOutputStream = new FileOutputStream(fileName);
		ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
		
		outputStream.writeObject(obj);
		outputStream.close();
		
		File file = new File(fileName);
		return file.exists();
	}
	
	public Object deserialization(String fileName) throws IOException, ClassNotFoundException
	{
		FileInputStream fileInputStream =new FileInputStream(fileName);
		ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
		
		ArrayList<Student> student = (ArrayList<Student>)inputStream.readObject(); 
		
		return student;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj==null)
			return false;
		if(!(obj instanceof Student))
			return false;
		if(this==obj)
			return true;
		Student student = (Student) obj;
		if(this.rollNumber == student.rollNumber)
			return true;
		else
			return false;
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(rollNumber);
	}
	
}
