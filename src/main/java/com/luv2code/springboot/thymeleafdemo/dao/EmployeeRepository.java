package com.luv2code.springboot.thymeleafdemo.dao;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!


    //jpa will automatically create the method body by processing the pattern
    //it sees the pattern findAllBy OrderByLastName
    List<Employee> findAllByOrderByLastName();
}
