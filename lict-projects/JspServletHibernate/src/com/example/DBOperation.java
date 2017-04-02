package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBOperation {

	public Student search(int id)
	{
		Student student = null;
		try
		{
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			student = (Student) session.get(Student.class, id);
			session.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return student;
	}

}
