package jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{
//            session.beginTransaction();
//            session.close();
            Session session1 = factory.getCurrentSession();
            session.beginTransaction();
//            Student student = session.get(Student.class,1);
//            session.delete(student);

            session1.createQuery("delete from Student where id=2").executeUpdate();
            session1.getTransaction().commit();
            session1.close();
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
            factory.close();
        }
    }
}
