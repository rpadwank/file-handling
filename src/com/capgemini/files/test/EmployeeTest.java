package com.capgemini.files.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import com.capgemini.files.model.Employee;
import com.capgemini.files.model.EmployeeDeserialization;
import com.capgemini.files.model.EmployeeSerialization;

public class EmployeeTest {

	private Employee employee;
	private EmployeeSerialization employeeSerialization;
	private EmployeeDeserialization employeeDeserialization;
	@Test
	public void testEmployeeSerialization() throws IOException {
		employee = new Employee(101, "John Doe", 45000);
		employeeSerialization = new EmployeeSerialization();
		assertTrue(employeeSerialization.writeObjectInFile("employee1.ser", employee));
		
	}
	
	@Test
	public void testEmployeeDeserialization() throws IOException, ClassNotFoundException {
		employee = new Employee(101, "John Doe", 45000);
		employeeSerialization = new EmployeeSerialization();
		employeeSerialization.writeObjectInFile("employee1.ser", employee);
		employeeDeserialization = new EmployeeDeserialization();
		assertEquals(employee,employeeDeserialization.deSerialize("employee1.ser"));
		
	}
	
	@Test(expected = FileNotFoundException.class)
	public void testEmployeeDeserializationWhenFileNotPresent() throws IOException, ClassNotFoundException {
		employeeDeserialization = new EmployeeDeserialization();
		employeeDeserialization.deSerialize("employee2.ser");
		
	}

}
