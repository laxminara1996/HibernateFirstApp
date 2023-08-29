package com.laxmi.client;

import com.laxmi.dao.StudentDAO;
import com.laxmi.dao.impl.StudentDaoImpl;
import com.laxmi.entity.Student;

public class Tester {
public static void main(String[] args) {
	
	// creating student object
	StudentDAO dao= new StudentDaoImpl();
	/*Student student = new Student();
	student.setSid(1111);
	student.setSname("rani");
	student.setGender("female");
	student.setMarks(700);
	dao.saveStudent(student);*/
	
	//Student stu = dao.loadStudent(1111);
	
	//Student s=dao.updateStudent(1111, 800); 
	
	//dao.deleteStudent(1111);
	dao.level1CatchTest();
}
}
