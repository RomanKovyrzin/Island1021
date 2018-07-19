package model;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

public class HibernateSessionFactoryUtil {

	private static SessionFactory sessionFactory;

	private HibernateSessionFactoryUtil() {}

	static {
		try {
			Configuration configuration = new Configuration().configure();
			configuration.addAnnotatedClass(Publish.class);
			configuration.addAnnotatedClass(Author.class);
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(
					configuration.getProperties()
			);
			sessionFactory = configuration.buildSessionFactory(builder.build());
		}
		catch (Exception err) {
			err.printStackTrace();
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
