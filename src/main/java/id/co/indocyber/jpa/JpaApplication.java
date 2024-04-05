package id.co.indocyber.jpa;

import id.co.indocyber.jpa.repositories.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(JpaApplication.class, args);

        var employeeRepository = (EmployeeRepository) context.getBean("employeeRepository");

        var data = employeeRepository.findAll();
        data.forEach(employee -> System.out.println(employee.getFullName()));

        testJpaQueries(employeeRepository);
    }

    private static void testJpaQueries(EmployeeRepository employeeRepository) {
        nativeQueryExample(employeeRepository);
        jpqlExample(employeeRepository);
        queryCreationExample(employeeRepository);
    }

    private static void nativeQueryExample(EmployeeRepository employeeRepository) {
        System.out.println("=".repeat(100) + "NATIVE QUERY" + "=".repeat(100));

        System.out.println("-".repeat(100) + "Select Where First Name =" + "-".repeat(100));
        employeeRepository.nativeQueryExample("Andi")
                .forEach(employee -> System.out.println(employee.getFullName()));
    }

    private static void jpqlExample(EmployeeRepository employeeRepository) {
        System.out.println("=".repeat(100) + "JAVA PERSISTENCE QUERY LANGUAGE" + "=".repeat(100));

        System.out.println("-".repeat(100) + "Select Where First Name =" + "-".repeat(100));
        employeeRepository.jpqlQueryExample("Jean")
                .forEach(employee -> System.out.println(employee.getFullName()));

        System.out.println("-".repeat(100) + "Select Where First Name LIKE" + "-".repeat(100));
        employeeRepository.jpqlQueryLikeExample("Candra")
                .forEach(employee -> System.out.println(employee.getFullName()));
    }

    private static void queryCreationExample(EmployeeRepository employeeRepository) {
        System.out.println("=".repeat(100) + "QUERY CREATION" + "=".repeat(100));

        System.out.println("-".repeat(100) + "findByFirstName" + "-".repeat(100));
        employeeRepository.findByFirstName("Jean")
                .forEach(employee -> System.out.println(employee.getFullName()));

        System.out.println("-".repeat(100) + "findByIsActive" + "-".repeat(100));
        employeeRepository.findByIsActive(false)
                .forEach(employee -> System.out.println(employee.getFullName()));

        System.out.println("-".repeat(100) + "findByIsActiveTrue" + "-".repeat(100));
        employeeRepository.findByIsActiveTrue()
                .forEach(employee -> System.out.println(employee.getFullName()));
    }

}
