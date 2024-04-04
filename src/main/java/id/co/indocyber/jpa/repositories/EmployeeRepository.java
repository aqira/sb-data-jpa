package id.co.indocyber.jpa.repositories;

import id.co.indocyber.jpa.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
