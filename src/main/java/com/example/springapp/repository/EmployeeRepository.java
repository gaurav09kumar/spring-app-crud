package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springapp.model.Employee;

//by extending JPARepository, Employee Repository can use CRUD methods
/*spring data JPA internally provides @Repository Annotation so we no need to add @Repository 
annotation to EmployeeRepository interface */

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
