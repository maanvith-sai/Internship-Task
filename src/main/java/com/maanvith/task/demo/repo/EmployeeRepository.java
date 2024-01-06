package com.maanvith.task.demo.repo;

import com.maanvith.task.demo.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository <Employee, Integer>{

}
