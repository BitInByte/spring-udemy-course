package com.bitinbyte.hibernate.demo;

import com.bitinbyte.hibernate.demo.entity.Course;
import com.bitinbyte.hibernate.demo.entity.Instructor;
import com.bitinbyte.hibernate.demo.entity.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * GetInstructorCoursesDemo
 */
public class GetInstructorCoursesDemo {

    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {
            // Start a transaction
            session.beginTransaction();
            // Get the instructor from db
            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class, theId);
            System.out.println("Instructor: " + tempInstructor);

            // Get courses for the instructor
            System.out.println("Course: " + tempInstructor.getCourses());

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
