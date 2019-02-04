package com.Employee.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.Dao.EmployeeDao;
import com.Employee.Entity.Employee;

@Service
public class EmployerServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDao  employeeDao;

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.addEmployee(employee);
	}

	@Override
	public List<Employee> listEmployee() {
		
		return employeeDao.listEmployee();
	}


	@Override
	public void editEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.editEmployee(employee);
	}

	@Override
	public void deleteEmplyee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.deleteEmplyee(employee);
	}

}
