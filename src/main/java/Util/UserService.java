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

        Query<User> query = session.createQuery("select username from user where username = :username;" +
                "AND password = :passwordFromConsole");
        query.setParameter("username", usernameFromConsole);
        query.setParameter("password", passwordFromConsole);

        User resultedUser = query.getSingleResult();

        if (resultedUser == null) {
            return false;
        }
        return true;
    }
}
