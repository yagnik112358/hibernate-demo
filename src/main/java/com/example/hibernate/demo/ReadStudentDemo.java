package com.example.hibernate.demo;

import com.example.hibernate.demo.entity.Student;
import com.example.hibernate.demo.utils.SessionUtil;
import org.hibernate.Session;

import java.util.List;

public class ReadStudentDemo {

    public static void main(String[] args) {

        try (Session session = SessionUtil.getSession()) {
            // create student object to save
//            Student theStudent = new Student("lalo", "mojilo", "mojilo.lalo@gmail.com");
            System.out.println("starting transaction");
//            session.beginTransaction();
//            session.save(theStudent);
//            session.getTransaction().commit();
            //code to read that object
//            session.close();

            session.beginTransaction();
//            Student newStudent = session.get(Student.class,theStudent.getId());
//            System.out.println("new student data "+ newStudent.getFirstName());
            List<Student> students = session.createQuery("from Student").list();
            displayStudents(students);

            List<Student> students1 = session.createQuery("from Student s where s.lastName='bharadwa'").list();
            System.out.println("students are:");
            displayStudents(students1);
            session.getTransaction().commit();

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
