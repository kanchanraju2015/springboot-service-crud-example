package com.briz.springbootserviceexample;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
@Autowired 
EmployeeRepository erepo;

@Override
public Employee addEmployee(Employee employee)
{
return erepo.save(employee);	
	
}
@Override
public List<Employee> allEmployees()
{ 
 
return erepo.findAll();
}

@Override
public Optional<Employee> getById(int id) 
{
	return erepo.findById(id);
}
@Override
public List<Employee> getByName(String name)
{
return erepo.findByName(name);
}
@Override
public void removeById(int id) 
{
erepo.deleteById(id);
}
@Override
public Employee update(int id,Employee employee) // this is example of all update
{
employee.setId(id);// this must be set otherwise not work 	
return erepo.save(employee);
}
}
