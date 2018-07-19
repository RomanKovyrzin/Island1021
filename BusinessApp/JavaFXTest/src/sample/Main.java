package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.HibernateSessionFactoryUtil;
import org.hibernate.SessionFactory;

public class Main extends Application {

    static {
        SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("TEST!");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    @Override
    public void stop() {
        HibernateSessionFactoryUtil.getSessionFactory().close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
