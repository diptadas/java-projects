package com.example;

import java.io.Serializable;

public class ContractEmployee extends Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	int payPerHour;

	public ContractEmployee(int id, String name, int payPerHour)
	{
		super(id, name);
		this.payPerHour = payPerHour;
	}

	public int getPayPerHour()
	{
		return payPerHour;
	}

	public void setPayPerHour(int payPerHour)
	{
		this.payPerHour = payPerHour;
	}

	@Override
	public String toString()
	{
		return "ContractEmployee [payPerHour=" + payPerHour + ", id=" + id + ", name=" + name + "]";
	}

}
