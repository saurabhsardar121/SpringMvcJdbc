package com.Employee.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Employee.Entity.Employee;
import com.Employee.Service.EmployeeService;

@Controller
public class MainClass {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/allemployee")
	public ModelAndView listEmployee() {
		
		System.out.println("welcome to employee");
		List<Employee> list = employeeService.listEmployee();
		System.out.println(list);
		return new ModelAndView("list","employees",list);
		
	}
	
	@RequestMapping("/add")
	public ModelAndView rediectaddEmployee() {
		return new ModelAndView("add");
	}
	
	@RequestMapping("/addredirect")
	public String addEmployee(@ModelAttribute() Employee employee) {
		employeeService.addEmployee(employee);
		return "redirect:allemployee.html";
	}
	
	@RequestMapping("/edit")
	public ModelAndView vieweditEmployee(Long id,String name, String address, Long salary) {
		System.out.println("edit employers");
		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setAddress(address);
		employee.setSalary(salary);
		//id, name, address, salary
		return new ModelAndView("edit","employee",employee);
	}
	
	@RequestMapping("/editrediect")
	public String editEmployee(@ModelAttribute Employee employee) {
		
		employeeService.editEmployee(employee);
		return "redirect:allemployee.html";
	}
	
	@RequestMapping("/delete")
	public String deleteEmployee(@ModelAttribute Employee employee) {
		employeeService.deleteEmplyee(employee);
		return "redirect:allemployee.html";
	}
}
