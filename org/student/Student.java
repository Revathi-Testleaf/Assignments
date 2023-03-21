package org.student;

import org.department.Department;

public class Student extends Department{
	//studentName(),studentDept(),studentId()
	public void studentName() {
		// TODO Auto-generated method stub
		System.out.println("Student name : Pranav");
	}
	public void studentDept() {
		// TODO Auto-generated method stub
		System.out.println("Student department : Chemistry");
	}
	public void studentId() {
		// TODO Auto-generated method stub
		System.out.println("Department Id: Chem007");
	}
	public static void main(String[] args) {
		Student student1=new Student();
		student1.collegeCode();
		student1.collegeName();
		student1.collegeRank();
		student1.deptName();
		student1.studentName();
		student1.studentId();
		student1.studentDept();

	}

}
