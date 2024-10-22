package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO ){

		return runner -> {
			// createInstructor(appDAO);

			// findInstructor(appDAO);

			deleteInstructor(appDAO);

		};
	}

	private void deleteInstructor(AppDAO appDAO){


		int theId =1;
		System.out.println("Deleting instructor id :" + theId);
		appDAO.deleteInstructorById(theId);

		System.out.println("Done!");


	}

	private void findInstructor(AppDAO appDAO) {

		int theId = 2;
		System.out.println("finding instructor id :" + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor : " + tempInstructor);
		System.out.println("the associated instructorDetail only: " + tempInstructor.getInstructorDetail());



	}

	private void createInstructor(AppDAO appDAO) {

		// create the instructor

		/*
		Instructor tempInstructor = new Instructor("melih@gmail.com", "üstün", "melih");

		//create the instructor detail

		InstructorDetail tempInstructorDetail =
				new InstructorDetail("luv 2 code","http://www.melih.com/youtube"); */

		Instructor tempInstructor = new Instructor("ahmet@gmail.com", "üstün", "Ahmet");

		//create the instructor detail

		InstructorDetail tempInstructorDetail =
				new InstructorDetail("guitar","http://www.melih.com/youtube");


		// associate the objects

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		//
		// Note : this will Also save the details object because of CascadeType.ALL
		//

		System.out.println("saving instructor : " + tempInstructor);
		appDAO.save(tempInstructor);


	}



}









