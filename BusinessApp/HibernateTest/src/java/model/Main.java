package model;

import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.sql.Date;

import java.util.*;

public class Main {

	public static void main(String[] args) throws SQLException {

        try (SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory()) {

            final String author_name[] = new String[]{"Kolya", "Petya", "Vasya", "Vasya"};
            final String publish_name[] = new String[]{"123", "abc", "xyz"};
            final int author_id[] = new int[]{3, 4, 4};

            AuthorController authorController = new AuthorController();
            PublishController publishController = new PublishController();

            //Создаем и добавляем новых авторов в БД:
            for (int i = 0; i < author_name.length; ++ i) {
                Date born = new Date(1234567890);
                Author author = new Author(author_name[i], born);
                authorController.insert(author);
            }

            //Создаем публикации и связываем их с автором:
            int n = Math.min(publish_name.length, author_id.length);
            for (int i = 0; i < n; ++ i) {
                Publish publish = new Publish(publish_name[i]);
                Author author = authorController.selectByID(author_id[i]);
                publish.addAuthor(author);
                publishController.insert(publish);
                author.addPublishes(publish);
                authorController.update(author);
            }

            //Выборка авторов по имени:
            List<Author> list = authorController.selectByName("Vasya");
            Iterator<Author> iter = (list.iterator());
            while (iter.hasNext()) {
                System.out.println("///////////////////");
                Author author = iter.next();
                System.out.println(author.getId() + ": " +
                        author.getName() + ": " +
                        author.getBorn()
                );
                //Выводим все публикации автора:
                System.out.println("-------------------");
                Set<Publish> publist = author.getPublishes();
                if ((publist == null) || (publist.size() == 0))
                    continue;
                Iterator<Publish> it = publist.iterator();
                System.out.println("publishes:");
                while (it.hasNext()) {
                    Publish pub = it.next();
                    System.out.println("[" +
                            pub.getId() + ": " +
                            pub.getTitle() +
                            "]"
                    );
                }
            }
        }
    }
}
