package jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadObject {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();
        Session session3 = factory.getCurrentSession();
        try{
            System.out.println("Creating student object");
            Student theStudent = new Student("hell", "heaven", "duckduckgo@gmail.com");
            System.out.println("Creating a session");
            session3.beginTransaction();
            System.out.println("Saving the student");
            session3.save(theStudent);
            session3.getTransaction().commit();
            System.out.println("Done");
            System.out.println("\n Student created with id: "+theStudent.getId());
            System.out.println(theStudent);


            session3 = factory.getCurrentSession();
            session3.beginTransaction();
            Student tempStudent = session3.get(Student.class,theStudent.getId());
            System.out.println("\n tempStudent: "+tempStudent);
            session3.getTransaction().commit();
            session3.close();
        }
        catch (Exception exc){
            factory.close();
            System.out.println(exc.getMessage());
        }
    }
}
