package Hospital_Project.repository;

import Hospital_Project.config.HibernateUtils;
import Hospital_Project.domain.Doctor;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DoctorRepository {
    private Session session;
    public void save(Doctor doctor) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(doctor);
            tx.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }
    }

    public Doctor find(long id) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            return session.get(Doctor.class, id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }

    public Doctor delete(Long id) {

    }
}
