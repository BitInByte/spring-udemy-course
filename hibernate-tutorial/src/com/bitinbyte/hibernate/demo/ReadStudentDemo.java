package com.bitinbyte.hibernate.demo;

import com.bitinbyte.hibernate.demo.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * ReadStudentDemo
 */
public class ReadStudentDemo {

    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {
            // Use the session object to save Java object
            // Create a student object
            System.out.println("Creating new student object...");
            Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");
            // Start a transaction
            session.beginTransaction();
            // Save the student object
            System.out.println("Saving the student...");
            System.out.println(tempStudent);
            session.save(tempStudent);
            // Commit transaction
            session.getTransaction().commit();

            // MY NEW CODE
            // Find out the student's id: primary key
            System.out.println("Saved student. Generated id: " + tempStudent.getId());

            // Now get a new session and start transaction
            // We also start a new transaction for update
            // and for read
            session = factory.getCurrentSession();
            session.beginTransaction();
            // Retrieve a student based on the id: primary key
            System.out.println("\nGetting student with id: " + tempStudent.getId());
            Student myStudent = session.get(Student.class, tempStudent.getId());
            System.out.println("Get complete: " + myStudent);
            // Commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
