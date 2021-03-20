package com.example.hibernate.demo;

import com.example.hibernate.demo.entity.Student;
import com.example.hibernate.demo.utils.SessionUtil;
import org.hibernate.Session;

import java.util.List;

public class DeleteStudentDemo {

    public static void main(String[] args) {

        try (Session session = SessionUtil.getSession()) {
            int studentId= 3;
            System.out.println("starting transaction");
            session.beginTransaction();

            Student theStudent = session.get(Student.class,studentId);
            System.out.println("Deleting student row...");
            session.delete(theStudent);
            session.getTransaction().commit();

            session.beginTransaction();
            System.out.println("deleting student ..");
            session.createQuery("delete from Student where firstName='Hardik'").executeUpdate();

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
