package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static Scanner scanner = new Scanner(System.in);

	public static void display(ResultSet resultSet) throws SQLException
	{
		List<Student> list = new ArrayList<Student>();

		while (resultSet.next())
		{

			list.add(new Student(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
		}

		if (list.isEmpty()) System.out.println("No Data found !!!\n");

		else
		{
			System.out.println("Displaying Student Data:");

			Iterator<Student> it = list.iterator();
			while (it.hasNext())
			{
				Student student = it.next();
				System.out.println(student);
			}
		}
	}

	public static void main(String[] args)
	{
		Connection connection = null;
		PreparedStatement pStatement = null;

		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");

			int choice = -1;

			do
			{
				System.out.println("1.Insert 2.Dispaly 3.Find 0.Exit");
				System.out.print("Enter choice: ");
				choice = scanner.nextInt();

				switch (choice)
				{
				case 1:

					System.out.print("Enter ID: ");
					int id = scanner.nextInt();
					System.out.print("Enter Name: ");
					String name = scanner.next();
					System.out.print("Enter Address: ");
					String address = scanner.next();

					pStatement = connection.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?)");

					pStatement.setInt(1, id);
					pStatement.setString(2, name);
					pStatement.setString(3, address);

					int ret = pStatement.executeUpdate();

					System.out.println(ret + " rows inserted\n");

					break;

				case 2:

					pStatement = connection.prepareStatement("SELECT * FROM STUDENT");
					ResultSet resultSet = pStatement.executeQuery();
					display(resultSet);
					break;

				case 3:

					System.out.print("Enter ID: ");
					id = scanner.nextInt();

					pStatement = connection.prepareStatement("SELECT * FROM STUDENT WHERE id = ?");
					pStatement.setInt(1, id);
					resultSet = pStatement.executeQuery();

					display(resultSet);

				case 0:
					System.out.println("Good bye");
					break;

				default:
					System.out.println("Invalid choice");
					break;
				}
			} while (choice != 0);
		} catch (Exception e)
		{
			System.out.println(e);
		} finally
		{
			try
			{
				connection.close();
			} catch (SQLException e)
			{
				System.out.println(e);
			}
		}

	}

}
