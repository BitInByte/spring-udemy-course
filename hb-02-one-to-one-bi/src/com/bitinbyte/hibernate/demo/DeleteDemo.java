package com.bitinbyte.hibernate.demo;

import com.bitinbyte.hibernate.demo.entity.Instructor;
import com.bitinbyte.hibernate.demo.entity.InstructorDetail;
import com.bitinbyte.hibernate.demo.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * CreateStudentDemo
 */
public class DeleteDemo {

    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {
            // Start a transaction
            session.beginTransaction();

            // Get instructor by primary key / id
            int theId = 1;
            // Return null if is not found
            Instructor tempInstructor = session.get(Instructor.class, theId);
            System.out.println("Found instructor: " + tempInstructor);

            // Delete the instructors
            if (tempInstructor != null) {
                System.out.println("Deleting: " + tempInstructor);
                // Note: will ALSO delete associated "details" object
                // because of CascadeType.ALL
                session.delete(tempInstructor);
            }

            // Commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
