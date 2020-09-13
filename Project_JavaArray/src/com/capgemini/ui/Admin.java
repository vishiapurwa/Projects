package com.capgemini.ui;

import java.util.Scanner;

import com.capgemini.beans.Address;
import com.capgemini.service.EmployeeScheduler;


public class Admin {
	static Scanner scan=new Scanner(System.in);
	public static String scan(String msg) {
		System.out.println(msg);
		String value=scan.next();
		return value;
	}
	
	public static void main(String[] args) {
		EmployeeScheduler scheduler=new EmployeeScheduler();
		Address address=null;
		while(true) {
		System.out.println("***Menu****");
		System.out.println("To add employee : Enter 1");
		System.out.println("To display all employees : Enter 2");
		System.out.println("To display employee by id : Enter 3");
		System.out.println("To display employee by name : Enter 4");
		System.out.println("To exit : Enter other number");
		int choice=Integer.parseInt(scan("Enter Your Choice"));
		switch(choice) {
			case 1:
				int id=Integer.parseInt(scan("Enter employee Id:"));
				String name=scan("Enter employee Name:");
				String designation=scan("Enter employee Designation:");
				double salary=Double.parseDouble(scan("Enter employee Salary:"));
				String city=scan("Enter employee city:");
				address=new Address(city);
				System.out.println(scheduler.addEmployee(id,name,designation,salary,address));
				break;
			case 2:
				scheduler.displayAllEmployeeDetails();
				break;
			case 3:
				int empid=Integer.parseInt(scan("Enter employee id "));
				scheduler.displayEmployeeById(empid);
				break;
			case 4:
				String empName=scan("Enter employee name");
				scheduler.displayEmployeeByName(empName);
				break;
			default:
				System.exit(0);
				break;
		}
		}
		

	}

}
