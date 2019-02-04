package com.Employee.Service;

import java.util.List;

import com.Employee.Entity.Employee;

public interface EmployeeService {
   
	public void addEmployee(Employee employee);
	
    public List<Employee> listEmployee();	
    
    
    public void editEmployee(Employee employee);
    
    public void deleteEmplyee(Employee employee);
	

}
