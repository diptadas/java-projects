package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	/*
	 * database: lict_mysql
	 * table: employee(id, name, type, salary, pay_per_hour)
	 */

	public static void main(String[] args)
	{
		try
		{
			Employee employee = null;

			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			employee = new Employee(1, "abc");
			session.persist(employee);

			employee = new RegularEmployee(2, "def", 5000);
			session.persist(employee);

			employee = new ContractEmployee(3, "pqr", 100);
			session.persist(employee);

			transaction.commit();
			System.out.println("Data Inserted");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
