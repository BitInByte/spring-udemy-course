package com.bitinbyte.hibernate.demo;

import com.bitinbyte.hibernate.demo.entity.Course;
import com.bitinbyte.hibernate.demo.entity.Instructor;
import com.bitinbyte.hibernate.demo.entity.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * CreateInstructorDemo
 */
public class CreateInstructorDemo {

    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {
            // Create the objects
            Instructor tempInstructor = new Instructor("Susan", "Public", "susan.public@luv2code.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Video Games");
            // Associate the objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);
            // Start a transaction
            session.beginTransaction();
            // Save the instructor
            // Note: This will also save the details object
            // because of CascadeType.ALL
            System.out.println("Saving instructor: " + tempInstructor);
            session.save(tempInstructor);
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
