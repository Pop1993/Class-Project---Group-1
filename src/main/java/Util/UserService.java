package Util;

import Entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;


public class UserService {

    public static boolean doesUserExists (User user){
        String usernameFromConsole = user.getUsername();
        String passwordFromConsole = user.getPassword();

        Session session = HibernateUtil.getSession();

        Query<User> query = session.createQuery("select u from User u where username = :username " +
                "AND password = :password");
        query.setParameter("username", usernameFromConsole);
        query.setParameter("password", passwordFromConsole);

        User resultedUser = query.getSingleResult();

        return resultedUser != null;

    }
}
