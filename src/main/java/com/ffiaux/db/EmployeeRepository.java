package com.ffiaux.db;

import java.util.List;

import com.ffiaux.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by ffiaux on 24/05/2016.
 */
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    public Employee findByFirstName(String firstName);
    public List<Employee> findByLastName(String lastName);

}
