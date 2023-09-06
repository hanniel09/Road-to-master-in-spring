package com.hanniel.cruddemo;

import com.hanniel.cruddemo.dao.StudentDAO;
import com.hanniel.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);

			createMultipleStudents(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 new Student object ...");
		Student tempStudent1 = new Student("John", "Doe", "John@Doe.com");
		Student tempStudent2 = new Student("Mary", "Public", "Mary@Public.com");
		Student tempStudent3 = new Student("Barry", "Allen", "Barry@Allen.com");

		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);


	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new Student object ...");
		Student tempStudent = new Student("Hanniel", "Vieira", "hanniel@hanniel.com");

		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated id: " + tempStudent.getId());

	}

}
