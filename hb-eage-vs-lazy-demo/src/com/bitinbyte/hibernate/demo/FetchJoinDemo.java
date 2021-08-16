package com.bitinbyte.hibernate.demo;

import com.bitinbyte.hibernate.demo.entity.Course;
import com.bitinbyte.hibernate.demo.entity.Instructor;
import com.bitinbyte.hibernate.demo.entity.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * FetchJoinDemo
 */
public class FetchJoinDemo {

    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {
            // Start a transaction
            session.beginTransaction();
            // Option 2: Hibernate query with HQL

            // Get the instructor from db
            int theId = 1;
            Query<Instructor> query = session.createQuery(
                    "select i from Instructor i JOIN FETCH i.courses where i.id=:theInstructorId", Instructor.class);

            // Set parameter on query
            query.setParameter("theInstructorId", theId);
            // Execute query and get instructor
            Instructor tempInstructor = query.getSingleResult();
            System.out.println("Instructor: " + tempInstructor);

            // Commit transaction
            session.getTransaction().commit();
            // Close the session
            session.close();
            System.out.println("\nThe session is now closed!\n");
            // Get courses for the instructor
            System.out.println("Course: " + tempInstructor.getCourses());

            System.out.println("Done!");

        } finally {
            // Add clean up code
            session.close();
            factory.close();
        }
    }
}
