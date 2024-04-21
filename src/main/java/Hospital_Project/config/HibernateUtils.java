package Hospital_Project.config;

import Hospital_Project.domain.Doctor;
import Hospital_Project.domain.Hospital;
import Hospital_Project.domain.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Doctor.class)
                    .addAnnotatedClass(Hospital.class)
                    .addAnnotatedClass(Patient.class);

            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e){
            System.err.println("Initialization of session factory is FAILED!!!");
        }
    }

    //getter SF
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    //SF kapatalım
    public  static void shutDown(){
        getSessionFactory().close();
    }

    //session kapatalım
    public static void closeSession(Session session){
        if(session != null && session.isOpen()){
            session.close();
        }
    }
}
