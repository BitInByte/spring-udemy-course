package com.bitinbyte.hibernate.demo;

import com.bitinbyte.hibernate.demo.entity.Review;

import com.bitinbyte.hibernate.demo.entity.Course;
import com.bitinbyte.hibernate.demo.entity.Instructor;
import com.bitinbyte.hibernate.demo.entity.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * CreateInstructorDemo
 */
public class DeleteCourseAndReviewsDemo {

    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class).buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {
            // Start a transaction
            session.beginTransaction();

            // Get the course
            int theId = 1;
            Course tempCourse = session.get(Course.class, theId);

            // Print the course
            System.out.println("Deleting the course ...");
            System.out.println(tempCourse);

            // Print the course reviews
            System.out.println(tempCourse.getReviews());

            // Delete the course
            // Cascade delete the associated entities
            session.delete(tempCourse);

            // Commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            // Add clean up code
            session.close();
            factory.close();
        }
    }
}
