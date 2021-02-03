package com.example.hibernate.demo;

import com.example.hibernate.demo.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            Student theStudent = new Student("yagnik", "bharadwa", "yagnik.bharadwa@iiitb.org");
            System.out.println("starting transaction");
            session.beginTransaction();
            System.out.println("saving student object");
            session.save(theStudent);
            System.out.println("commit transaction");
            session.getTransaction().commit();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            sessionFactory.close();
        }

        /*try (Session session = SessionUtil.getSession()) {
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
        }*/


    }

}
