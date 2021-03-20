package com.example.hibernate.demo;

import com.example.hibernate.demo.entity.Student;
import com.example.hibernate.demo.utils.SessionUtil;
import org.hibernate.Session;

import java.util.List;

public class UpdateStudentDemo {

    public static void main(String[] args) {

        try (Session session = SessionUtil.getSession()) {
            int studentId= 2;
            System.out.println("starting transaction");
            session.beginTransaction();

            Student theStudent = session.get(Student.class,studentId);
            System.out.println("Updating student name and email...");
            theStudent.setFirstName("Hardik");
            theStudent.setEmail("hardik.bharadwa@gmail.com");
            session.getTransaction().commit();

            session.beginTransaction();
            /*USed for updating bulk data in one go */
            System.out.println("changing email of every student..");
            session.createQuery("update Student set email='yagnik@gmail.com'").executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done!");



        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void displayStudents(List<Student> students){
        for (Student theStudent:students){
            System.out.println(theStudent);
        }
    }

}
