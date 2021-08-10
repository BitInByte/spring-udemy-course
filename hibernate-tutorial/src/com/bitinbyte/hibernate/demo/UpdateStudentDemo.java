package com.bitinbyte.hibernate.demo;

import com.bitinbyte.hibernate.demo.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * UpdateStudentDemo
 */
public class UpdateStudentDemo {

    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {
            int studentId = 1;

            // Now get a new session and start transaction
            // We also start a new transaction for update
            // and for read
            session = factory.getCurrentSession();
            session.beginTransaction();
            // Retrieve a student based on the id: primary key
            System.out.println("\nGetting student with id: " + studentId);
            Student myStudent = session.get(Student.class, studentId);
            System.out.println("Updating student...");
            myStudent.setFirstName("Scooby");
            // Commit the transaction => Will update in the database
            session.getTransaction().commit();

            // NEW CODE
            session = factory.getCurrentSession();
            session.beginTransaction();
            // Update email for all students
            System.out.println("Update email for all students");
            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
            // Commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
