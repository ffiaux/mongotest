package com.ffiaux.db;

import com.ffiaux.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by ffiaux on 26/05/2016.
 */
public interface DepartmentRepository extends MongoRepository<Department, String> {
}
