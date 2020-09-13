package com.capgemini.service;

import com.capgemini.beans.Address;
import com.capgemini.beans.Employee;

public class EmployeeScheduler {
	private    Employee[] employees = new Employee[10];
    private int counterEmployee;
    
    public boolean checkDuplicateEmpId(int id) {
    		for(int i=0;i<counterEmployee;i++)
            {
    			if(employees[i].getEmpId()==id) {
    				return false;
    			}
            }
    	return true;
    }
    
    public String addEmployee(int empId, String name,String designation, double salary, Address address)
    {
    	if(checkDuplicateEmpId(empId)) {
        employees[counterEmployee] = new Employee();
        employees[counterEmployee].setEmpId(empId);
        employees[counterEmployee].setName(name);
        employees[counterEmployee].setDesignation(designation);
        employees[counterEmployee].setSalary(salary);
        employees[counterEmployee].setAddress(address);
        counterEmployee++;
        return "Employee details added successfully";
        }
    	else 
    		return "Duplicate Employee Id";
        
    }
    
    
    public void displayAllEmployeeDetails()
    {
        for(int i=0;i<counterEmployee;i++)
        {
            System.out.println("Employee details are: ");
            System.out.println(employees[i].getEmpId());
            System.out.println(employees[i].getName());
            System.out.println(employees[i].getDesignation());
            System.out.println(employees[i].getSalary());
            System.out.println(employees[i].getAddress());
        }
        
    }
    
    public void displayEmployeeById(int  id) {
    	for(int i=0;i<counterEmployee;i++) {
    		if(employees[i].getEmpId()==id) {
    			System.out.println("Employee details are: ");
                System.out.println(employees[i].getEmpId());
                System.out.println(employees[i].getName());
                System.out.println(employees[i].getDesignation());
                System.out.println(employees[i].getSalary());
                System.out.println(employees[i].getAddress());
                return;
    		}
       	}
    	System.out.println("Employee with id:" +id +" does not exist\"");
    	
    }
    
    public void displayEmployeeByName(String name) {
    	for(int i=0;i<counterEmployee;i++) {
    		if(employees[i].getName().equalsIgnoreCase(name)) {
    			System.out.println("Employee details are: ");
                System.out.println(employees[i].getEmpId());
                System.out.println(employees[i].getName());
                System.out.println(employees[i].getDesignation());
                System.out.println(employees[i].getSalary());
                System.out.println(employees[i].getAddress());
                return;
    		}
       	}
    	System.out.println("Employee with name:" +name +" does not exist");
    	
    	
    }
    

}
