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

			findInstrutor(appDAO);
		};
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
				new Instructor("Chad", "Darby", "Chad@Darby.com");

		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.google.com/youtube",
						"Code and developer"
				);

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}
}
