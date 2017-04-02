package com.example;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class Main {

	/*
	 * database: lict_mysql
	 * table: student(student_id, name, marks)
	 */

	public static void insert()
	{
		Scanner sc = new Scanner(System.in);

		try
		{
			Student student = new Student();

			System.out.print("ID: ");
			student.setStudentId(sc.nextInt());
			System.out.print("Name: ");
			student.setName(sc.next());
			System.out.print("Marks: ");
			student.setMarks(sc.nextInt());

			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();

			Transaction tr = session.beginTransaction();
			session.persist(student);
			tr.commit();

			System.out.println("Data inserted");

			session.close();
			sc.close();

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void update()
	{
		Scanner sc = new Scanner(System.in);

		try
		{
			Student student = new Student();

			System.out.print("ID: ");
			student.setStudentId(sc.nextInt());
			System.out.print("Name: ");
			student.setName(sc.next());
			System.out.print("Marks: ");
			student.setMarks(sc.nextInt());

			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();

			Transaction tr = session.beginTransaction();
			session.update(student);
			tr.commit();

			System.out.println("Data updated");

			session.close();
			sc.close();

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static void viewAll()
	{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String str = "from Student";
		Query query = session.createQuery(str);
		Iterator<Student> i = query.iterate();

		while (i.hasNext())
		{
			Student student = (Student) i.next();
			System.out.println(student);
		}

		session.close();
	}

	@SuppressWarnings("unchecked")
	public static void viewAllNew() // using Criteria Api
	{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Student.class);

		// pagination
		criteria.setFirstResult(2); //first row in the result
		criteria.setMaxResults(3); //number of rows

		List<Student> results = criteria.list();

		for (Student student : results)
		{
			System.out.println(student);
		}

		session.close();
	}

	@SuppressWarnings("unchecked")
	public static void conditionalView() //restriction
	{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Student.class).add(Restrictions.gt("marks", 15)).addOrder(Order.desc("name")).setMaxResults(3);

		List<Student> results = criteria.list();

		// List<Student> results = session.createCriteria(Student.class).add(Restrictions.gt("marks", 15)).addOrder(Order.desc("name")).setMaxResults(3).list();

		for (Student student : results)
		{
			System.out.println(student);
		}

		session.close();
	}

	public static void search()
	{
		Scanner sc = new Scanner(System.in);

		try
		{
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();

			System.out.print("Enter ID to search: ");
			int id = sc.nextInt();

			Student student = (Student) session.get(Student.class, id);

			if (student != null) System.out.println(student);
			else
				System.out.println("No record");

			session.close();
			sc.close();

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void delete()
	{
		Scanner sc = new Scanner(System.in);

		try
		{
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();

			System.out.print("Enter ID to delete: ");
			int id = sc.nextInt();

			Student student = (Student) session.get(Student.class, id);

			if (student != null)
			{
				Transaction tr = session.beginTransaction();
				session.delete(student);
				tr.commit();
				System.out.println("Data deleted");
			} else
				System.out.println("No record");

			session.close();
			sc.close();

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	public static void main(String[] args)
	{

		System.out.println("1. insert 2. view all 3. search 4. delete 5. update 6. conditional_search");
		System.out.print("Enter choice: ");
		int choice = new Scanner(System.in).nextInt();

		if (choice == 1) insert();
		else if (choice == 2) viewAll();
		else if (choice == 3) search();
		else if (choice == 4) delete();
		else if (choice == 5) update();
		else if (choice == 6) conditionalView();

	}

}
