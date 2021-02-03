package com.example.hibernate.demo;

import com.example.hibernate.demo.entity.Student;
import com.example.hibernate.demo.utils.SessionUtil;
import org.hibernate.Session;

public class StudentCreateDemo {

    public static void main(String[] args) {

        try (Session session = SessionUtil.getSession()) {
            // create student object to save
            Student theStudent = new Student("yagnik", "bharadwa", "yagnik.bharadwa@iiitb.org");
            System.out.println("starting transaction");
            session.beginTransaction();
            System.out.println("saving student object");
            session.save(theStudent);
            System.out.println("commit transaction");
            session.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
