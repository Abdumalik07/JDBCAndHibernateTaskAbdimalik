package peaksoft;

import org.hibernate.SessionFactory;
import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;
import peaksoft.util.HibernateUtil;


public class Main {
    public static SessionFactory factory;
    public static void main(String[] args) {
//        Util.connection();
        UserService userService = new UserServiceImpl();

//        userDaoJdbc.createUsersTable();
//        userService.saveUser("Abdimalik","Abdurakhmanov",  (byte)23);
//        userDaoJdbc.dropUsersTable();
//        userDaoJdbc.removeUserById(2);
//        System.out.println(userService.getAllUsers().size());
//        userDaoJdbc.cleanUsersTable();
        // реализуйте алгоритм здесь
        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        userDaoHibernate.createUsersTable();
       // HibernateUtil.getSessionFactory();
//        userDaoHibernate.saveUser("Arlen","Abdurakhmanov",(byte)31);
    }
}
