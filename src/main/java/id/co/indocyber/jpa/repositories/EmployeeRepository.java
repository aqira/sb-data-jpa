package id.co.indocyber.jpa.repositories;

import id.co.indocyber.jpa.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
    @Query(value = """
            SELECT *
            FROM Employees AS e
            WHERE e.FirstName = :firstName
            """,
            nativeQuery = true)
    List<Employee> nativeQueryExample(@Param("firstName") String firstName);

    @Query(value = """
            SELECT e
            FROM Employee e
            WHERE e.firstName = :firstName
            """)
    List<Employee> jpqlQueryExample(@Param("firstName") String firstName);

    @Query(value = """
            SELECT e
            FROM Employee e
            WHERE e.firstName LIKE %:firstName%
            """)
    List<Employee> jpqlQueryLikeExample(@Param("firstName") String firstName);

    List<Employee> findByFirstName(String firstName);
    List<Employee> findByIsActive(boolean isActive);
    List<Employee> findByIsActiveTrue();

}
