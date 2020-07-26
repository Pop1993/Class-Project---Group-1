package Util;

import Entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;


public class UserService {

    public static boolean doesUserExists (String username, String password){
        String usernameFromConsole = username;
        String passwordFromConsole = password;

        Session session = HibernateUtil.getSession();

        Query<User> query = session.createQuery("select u from User u where username = :username " + "AND password = :password");
        query.setParameter("username", usernameFromConsole);
        query.setParameter("password", passwordFromConsole);

        return query.getResultList().size() > 0;
    }

    public static User returnUserFromDatabase (User user){
        Session session = HibernateUtil.getSession();

        Query<User> query = session.createQuery("select u from User u where username = :username " +
                "AND password = :password");
        query.setParameter("username", user.getUsername());
        query.setParameter("password", user.getPassword());

        if (query.getResultList().size() == 1) {
            return  query.getSingleResult();
        } else {
            return null;
        }
    }


}
