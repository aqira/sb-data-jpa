package id.co.indocyber.jpa;

import id.co.indocyber.jpa.repositories.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(JpaApplication.class, args);

        var employeeRepository = (EmployeeRepository) context.getBean("employeeRepository");

        var data = employeeRepository.findAll();
        data.forEach(employee -> System.out.println(employee.getFullName()));
    }

}
