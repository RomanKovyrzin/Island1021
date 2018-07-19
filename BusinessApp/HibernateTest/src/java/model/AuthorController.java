package model;

import org.hibernate.Transaction;
import org.hibernate.Session;
import java.util.List;

public class AuthorController {

    public AuthorController() {}

	public void insert(Author author) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.save(author);
            tx1.commit();
        }
        catch (Throwable err) {
            throw  err;
        }
	}

	public void update(Author author) {
		try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
			Transaction tx1 = session.beginTransaction();
			session.update(author);
			tx1.commit();
		}
		catch (Throwable err) {
			throw  err;
		}
	}

	public void delete(Author author) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.delete(author);
            tx1.commit();
        }
        catch (Throwable err) {
            throw  err;
        }
	}

	public Author selectByID(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(Author.class, id);
        }
        catch (Throwable err) {
            throw  err;
        }
	}

	public List<Author> selectByName(String name) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            List<Author> authors = session.createQuery(
                    "From model.Author where name = :n"
            ).setString("n", name).list();
            return authors;
        }
        catch (Throwable err) {
            throw  err;
        }
	}

	public List<Author> select() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            List<Author> authors = session.createQuery(
                    "From model.Author"
            ).list();
            return authors;
        }
        catch (Throwable err) {
            throw  err;
        }
	}
}
