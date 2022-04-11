package jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo{
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            System.out.println("Creating student object");
            Student theStudent = new Student("sohail","shaik","sohail@gmail.com");
            System.out.println("Creating a session");
            session.beginTransaction();
            System.out.println("Saving the student");
            session.save(theStudent);
            session.getTransaction().commit();
            System.out.println("Done");
            session.close();
            System.out.println(theStudent.toString());
        }
        catch (Exception exc){
//            System.out.println(exc.getMessage());
            factory.close();
            System.out.println("hi");
        }
    }
}
