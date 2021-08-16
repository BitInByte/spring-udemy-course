package com.bitinbyte.hibernate.demo;

import com.bitinbyte.hibernate.demo.entity.Instructor;
import com.bitinbyte.hibernate.demo.entity.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * CreateStudentDemo
 */
public class DeleteInstructorDetailDemo {

    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {
            // Start a transaction
            session.beginTransaction();

            // Get the instructor detail object
            int theId = 3;
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

            // Print the instructor detail
            System.out.println("tempInstructorDetail: " + tempInstructorDetail);

            // Print the associated instructor
            System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());

            // Now let's delete the Instructor detail
            System.out.println("Deleting tempInstructorDetail: " + tempInstructorDetail);

            // Remove the associated object reference
            // Break bi-directional link
            tempInstructorDetail.getInstructor().setInstructorDetail(null);

            session.delete(tempInstructorDetail);

            // Commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            // Handle connection leak issue via record not found
            session.close();
            factory.close();
        }
    }
}
