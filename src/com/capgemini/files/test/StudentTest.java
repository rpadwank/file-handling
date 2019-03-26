package com.capgemini.files.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.files.model.Student;


public class StudentTest {

	private ArrayList<Student> student;
	private Student student1;
	private Student student2;
	private Student student3;
	private Student student4;
	private Student student5;


	@Before
	public void setUp()
	{
		student1 = new Student(1, "Ram");
		student2 = new Student(2, "Akshay");
		student3 = new Student(3, "Ruchir");
		student4 = new Student(4, "John");
		student5 = new Student(5, "Ram");
		student = new ArrayList<>();
		student.add(student1);
		student.add(student2);
		student.add(student3);
		student.add(student4);
		student.add(student5);
	}
	
	@Test
	public void testArrayListSerialization() throws IOException {
		
		assertTrue(new Student().serialization("student.ser", student));
	}
	
	@Test
	public void testArrayListDeserialization() throws IOException, ClassNotFoundException {
		
		Student student = new Student();
		ArrayList<Student> expected = (ArrayList<Student>) student.deserialization("student.ser");
		Iterator<Student> iterator = expected.iterator();
		assertEquals(student1, iterator.next());
		assertEquals(student2, iterator.next());
		assertEquals(student3, iterator.next());
		assertEquals(student4, iterator.next());
		assertEquals(student5, iterator.next());
	}

}
