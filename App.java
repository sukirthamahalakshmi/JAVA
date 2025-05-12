package com.example;

import com.example.model.Employee;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setFirstName("John");
        emp.setLastName("Doe");
        emp.setEmail("john.doe@example.com");

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
          
            transaction = session.beginTransaction();
            
           
            session.save(emp);
            
           
            transaction.commit();
            
            System.out.println("Employee saved successfully!");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        
        HibernateUtil.shutdown();
    }
}
