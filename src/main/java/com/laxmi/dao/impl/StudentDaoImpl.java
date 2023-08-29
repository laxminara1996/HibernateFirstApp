package com.laxmi.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import com.laxmi.dao.StudentDAO;
import com.laxmi.entity.Student;

public class StudentDaoImpl implements StudentDAO{

	SessionFactory factory;
	public StudentDaoImpl() {
		ServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
		factory = metadata.getSessionFactoryBuilder().build();
	}
	public void saveStudent(Student student) {
    	Session session = factory.openSession();
    	Transaction t = session.beginTransaction();
    	try {
    		session.save(student);
    		System.out.println("student object is persisted in db");
    		t.commit();
    	}catch(Exception e) {
    		t.rollback();
    		System.out.println("issue in persisting the student object");
    		e.printStackTrace();
    	}
    	finally {
    		session.close();
    	}
    }
	
	public Student loadStudent(int sid) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		Student stu= session.load(Student.class, sid);
		try{
			Thread.sleep(30000);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("name is"+stu.getSname());
		session.close();
		return stu;
	}
	@Override
	public Student updateStudent(int sid, int marks) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		Student st= session.get(Student.class, sid);
		Transaction trans= session.beginTransaction();
		try {
			st.setMarks(marks);
			session.update(st);
			trans.commit();
			System.out.println("updation completed");
		}catch(Exception ex) {
			trans.rollback();
			System.out.println("sorry updation failed");
		}
		finally {
			session.close();
		}
		return st;
	}
	@Override
	public void deleteStudent(int sid) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Student s = session.get(Student.class, sid);
		Transaction t = session.beginTransaction();
		try {
			session.delete(s);
			t.commit();
			System.out.println("record deleted");
		}catch(Exception e) {
			t.rollback();
			System.out.println("record not deleted");
		}
		finally {
			session.close();
		}
	}
	public void level1CatchTest(){
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Session other_session = factory.openSession();
		Student s1=session.get(Student.class, 1111);
		//Student s2=session.get(Student.class, 2222);
		Student s3=session.get(Student.class, 1111);
		//Student s4=other_session.get(Student.class, 1111);
		session.close();
		other_session.close();
	}
}
