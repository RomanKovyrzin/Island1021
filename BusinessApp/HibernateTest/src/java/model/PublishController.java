package model;

import org.hibernate.Transaction;
import org.hibernate.Session;

public class PublishController {

    public PublishController() {}

    public void insert(Publish publish) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.save(publish);
            tx1.commit();
        }
        catch (Throwable err) {
            throw  err;
        }
    }

    public void update(Publish publish) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.update(publish);
            tx1.commit();
        }
        catch (Throwable err) {
            throw  err;
        }
    }

    public void delete(Publish publish) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.delete(publish);
            tx1.commit();
        }
        catch (Throwable err) {
            throw  err;
        }
    }

}
