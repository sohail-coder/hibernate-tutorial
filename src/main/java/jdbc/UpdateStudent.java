package jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudent {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            int studentId=1;
            Student student = session.get(Student.class,studentId);
            student.setLastName("heaven");
            session.getTransaction().commit();
            session.close();
            Session session1 = factory.getCurrentSession();
//            session= factory.getCurrentSession();
            session1.beginTransaction();
            session1.createQuery("update Student set email= 'hell@gmail.com'").executeUpdate();
            session1.getTransaction().commit();
            session1.close();
        }
        catch (Exception exception){
            factory.close();
        }
    }
}
