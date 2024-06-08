package com.briz.springbootserviceexample;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController
{
@Autowired
EmployeeService eserv;
@RequestMapping("/test")
public String test() 
{
return "This is service test";	
}
@RequestMapping("/save")
public String save(@RequestBody Employee employee)
{
	 eserv.addEmployee(employee);
	return "data saved into database";// this is modified return type 
}
@RequestMapping("/all")
public List<Employee> alldata()
{
	return eserv.allEmployees();// this return type can also be modified 
}
@RequestMapping("/{id}")
public Optional<Employee> byid(@PathVariable int id)
{
	return eserv.getById(id);  // this return type also can be modified 
}
@RequestMapping("/by/{name}")
public List<Employee> byname(@PathVariable String name)
{
	return eserv.getByName(name);
}
@RequestMapping("/del/{id}")
public Employee delbyid(@PathVariable int id)
{
	Employee e=eserv.getById(id).get();
	eserv.removeById(id);
	return e;
}
@RequestMapping("/update/{id}")
public Employee upd(@PathVariable int id,@RequestBody Employee employee)
{
eserv.update(id, employee);// just pass this data to service level
return employee;
}
}