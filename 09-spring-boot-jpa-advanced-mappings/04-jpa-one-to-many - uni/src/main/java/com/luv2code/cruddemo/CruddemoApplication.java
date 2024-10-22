package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO ){

		return runner -> {

			// createCourseAndReviews(appDAO);

			// retrieveCourseAndReviews(appDAO);

			deleteCourseAndReviews(appDAO);

		};
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {

		int theId = 10;
		System.out.println("Deleting course id : " + theId);

		appDAO.deleteCourseById(theId);

		System.out.println("Done!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {

		// get the course and reviews
		int theId = 10;
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);

		// print the course
		System.out.println(tempCourse);

		// print the reviews
		System.out.println(tempCourse.getReviews());

		System.out.println("Done!");


	}

	private void createCourseAndReviews(AppDAO appDAO) {

		// create a course

		Course tempCourse = new Course("pacman - how to score one million points");

		// add some reviews
		tempCourse.addReview(new Review("Great course.. Love it!"));
		tempCourse.addReview(new Review("Cool course"));
		tempCourse.addReview(new Review("What a dumb course!"));

		// save the course ... and leverage the cascade all

		System.out.println("Saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());

		appDAO.save(tempCourse);

		System.out.println("Done!");




	}

	private void deleteCourse(AppDAO appDAO) {

		int theId = 10;

		// delete the course
		System.out.println("Deleting course id: " + theId);

		appDAO.deleteCourseById(theId);

		System.out.println("Done!");

	}

	private void updateCourse(AppDAO appDAO) {

		int theId = 10;

		// Find the course

		System.out.println("Finding course id: " + theId);
		Course	tempCourse = appDAO.findCourseById(theId);

		// update the instructor
		System.out.println("Updating course id: " + theId);
		tempCourse.setTitle("enjoy düde");

		appDAO.update(tempCourse);

		System.out.println("Done!");

	}

	private void updateInstructor(AppDAO appDAO) {

		int theId = 1;

		// find the instructor
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		// update the instructor
		System.out.println("Updating instructor id: " + theId);
		tempInstructor.setLastName("Tester");

		appDAO.update(tempInstructor);

		System.out.println("Done!");

	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int theId = 1;

		// find the instructor
		System.out.println("Finding instructor id : " + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor : " + tempInstructor);
		System.out.println("the associated courses : " + tempInstructor.getCourses());

		System.out.println("Done!");

	}

	private void findCoursesForInstructor(AppDAO appDAO) {

		int theId = 1;

		System.out.println("finding instructor id : " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor : " + tempInstructor);

		// find courses for instructor

		System.out.println("Finding courses for instructor id : " + theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		// associate the objects
		tempInstructor.setCourses(courses);

		System.out.println("the associated courses : " + tempInstructor.getCourses());

		System.out.println("Done!");

	}

	private void findInstructorWithCourses(AppDAO appDAO) {

		int theId = 1;
		System.out.println("finding instructor id : " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor : " + tempInstructor);
		System.out.println("the associated courses : " + tempInstructor.getCourses());

		System.out.println("Done!");

	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		Instructor tempInstructor = new Instructor("busra@gmail.com", "busra", "ustun");

		//create the instructor detail

		InstructorDetail tempInstructorDetail =
				new InstructorDetail("Video Games","http://www.youtube.com");


		// associate the objects

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// create some courses

		Course tempCourse1  = new Course("air guitar - the ultimate");
		Course tempCourse2  = new Course("the pinball masterclass");

		// add courses to instructor

		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		// save the instructor
		//
		//Note: this will also save the courses
		//because of CascadeType.PERSIST
		//

		System.out.println("saving instructor : " + tempInstructor);
		System.out.println("The courses : " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("DONE!");
	}







	private void deleteInstructorDetail(AppDAO appDAO) {

		int theId = 3;
		System.out.println("Deleting instructor detail id : " + theId);

		appDAO.deleteInstructorDetailById(theId);

		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {

			// get the instructor detail object

			int theId = 2;
			InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

			// print the instructor detail
			System.out.println("tempInstructorDetail : " + tempInstructorDetail);

			// print the associated instructor
			System.out.println("the associated instructor : " + tempInstructorDetail.getInstructor());

			System.out.println("Done!");


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









