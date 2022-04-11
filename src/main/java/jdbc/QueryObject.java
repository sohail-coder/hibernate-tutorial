package jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryObject {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            List<Student> studentList = session.createQuery("from Student").getResultList();
            for(Student student: studentList){
                System.out.println(student);
            }
            session.beginTransaction().commit();
            session.close();
        }
        catch (Exception exception){
            factory.close();
        }
    }
}
