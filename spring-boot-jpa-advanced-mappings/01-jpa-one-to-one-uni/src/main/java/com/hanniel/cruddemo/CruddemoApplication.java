package com.hanniel.cruddemo;

import com.hanniel.cruddemo.dao.AppDAO;
import com.hanniel.cruddemo.entity.Instructor;
import com.hanniel.cruddemo.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
//			createInstructor(appDAO);

//			findInstrutor(appDAO);

//			deleteInstructor(appDAO);

//			findInstrutorDetail(appDAO);

//			deleteInstructorDetail(appDAO);

			createInstructorWithCourses(appDAO);
		};
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor =
				new Instructor("Susan", "Public", "Susan@Public.com");

		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.youtube.com/codes",
						"Read books"
				);

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 8;
		System.out.println("Deleting instructor detail id: " + theId);

		appDAO.deleteInstructorDetailById(theId);

		System.out.println("Done!");
	}

	private void findInstrutorDetail(AppDAO appDAO) {
		int theId = 5;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		System.out.println("tempInstructorDetail: " + tempInstructorDetail);

		System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());

		System.out.println("Done!!!");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Deleting instructor id: " + theId);

		appDAO.deleteInsctructorByID(theId);

		System.out.println("Done!");
	}

	private void findInstrutor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associate instructorDetail only: " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor tempInstructor =
				new Instructor("Tony", "Stark", "Tony@Stark.com");

		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.google.com/avengers",
						"create a new AI"
				);

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}
}
