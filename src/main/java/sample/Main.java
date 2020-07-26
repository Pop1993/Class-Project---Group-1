package sample;

import Entity.Order;
import Entity.OrderProduct;
import Util.HibernateUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/LogInPage2.fxml"));
        primaryStage.setTitle("D.O.C. Online Shop");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

//        Order order = new Order();
//        OrderProduct orderProduct = new OrderProduct();
//
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        session.save(order);
//        session.save(orderProduct);
//
//        session.getTransaction().commit();
//        session.close();

    }
}
