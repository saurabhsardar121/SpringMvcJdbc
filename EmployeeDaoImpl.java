package com.Employee.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.Employee.Entity.Employee;
import com.connectionprovider.MysqlConnection;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Override
	public List<Employee> listEmployee() {
		
		List<Employee> list = new ArrayList<>();
		try {
			Connection con = MysqlConnection.getMysqlConnection();
			PreparedStatement preparedStatement = con.prepareStatement("select * from employee");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setId(resultSet.getLong("id"));
				employee.setName(resultSet.getString("name"));
				employee.setAddress(resultSet.getString("address"));
				employee.setSalary(resultSet.getLong("salary"));
				
				list.add(employee);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void addEmployee(Employee employee) {
		
		try {
			Connection con = MysqlConnection.getMysqlConnection();
			PreparedStatement preparedStatement = con.prepareStatement("insert into employee (name,address,salary) values(?,?,? )");
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getAddress());
			preparedStatement.setLong(3,employee.getSalary());
			int i = preparedStatement.executeUpdate();
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}


	@Override
	public void editEmployee(Employee employee1) {
		Connection con;
		try {
			con = MysqlConnection.getMysqlConnection();
			PreparedStatement preparedStatement = con.prepareStatement("update employee set name =? ,address =? , salary=? where id =?");
			preparedStatement.setString(1,employee1.getName());
			preparedStatement.setString(2,employee1.getAddress());
			preparedStatement.setLong(3,employee1.getSalary());
			preparedStatement.setLong(4, employee1.getId());
			
			int i = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteEmplyee(Employee employee) {
	     
		Connection con;
		try {
			con = MysqlConnection.getMysqlConnection();
			PreparedStatement preparedStatement = con.prepareStatement("delete from employee where id =?");
			preparedStatement.setLong(1, employee.getId());
			int i =  preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
