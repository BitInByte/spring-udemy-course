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
public class CreateDemo {

    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {
            // Create the objects
            // Instructor tempInstructor = new Instructor("Chad", "Darby",
            // "darby@luv2code.com");
            // InstructorDetail tempInstructorDetail = new
            // InstructorDetail("http://www.luv2code.com/youtube",
            // "Luv 2 code");
            Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Guitar");
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
            factory.close();
        }
    }
}
