package com.example;

import java.io.Serializable;

public class RegularEmployee extends Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	int salary;

	public RegularEmployee(int id, String name, int salary)
	{
		super(id, name);
		this.salary = salary;
	}

	public int getSalary()
	{
		return salary;
	}

	public void setSalary(int salary)
	{
		this.salary = salary;
	}

	@Override
	public String toString()
	{
		return "RegularEmployee [salary=" + salary + ", id=" + id + ", name=" + name + "]";
	}

}
