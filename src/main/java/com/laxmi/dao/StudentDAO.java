package com.laxmi.dao;

import com.laxmi.entity.Student;

public interface StudentDAO {
	void saveStudent(Student student);
    Student loadStudent(int i);
    Student updateStudent(int sid,int marks);
    void deleteStudent(int sid);
    void level1CatchTest();
}
