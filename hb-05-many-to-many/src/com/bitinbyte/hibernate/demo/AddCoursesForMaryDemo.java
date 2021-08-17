package com.bitinbyte.hibernate.demo;

import com.bitinbyte.hibernate.demo.entity.Review;
import com.bitinbyte.hibernate.demo.entity.Student;
import com.bitinbyte.hibernate.demo.entity.Course;
import com.bitinbyte.hibernate.demo.entity.Instructor;
import com.bitinbyte.hibernate.demo.entity.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * AddCoursesForMaryDemo
 */
public class AddCoursesForMaryDemo {

    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {
            // Start a transaction
            session.beginTransaction();
            // Get the student mary from database
            int studentId = 2;
            Student tempStudent = session.get(Student.class, studentId);
            System.out.println("\nLoaded student: " + tempStudent);
            System.out.println("Courses: " + tempStudent.getCourses());
            // Create more courses
            Course tempCourse1 = new Course("Rubik's Cube = How to Speed Cube");
            Course tempCourse2 = new Course("Atari 2600 - Game Development");
            // Add student to courses
            tempCourse1.addStudent(tempStudent);
            tempCourse2.addStudent(tempStudent);
            // tempCourse2.addStudent(tempStudent);
            // Save the courses
            System.out.println("\nSaving the courses ...");
            session.save(tempCourse1);
            session.save(tempCourse2);
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
