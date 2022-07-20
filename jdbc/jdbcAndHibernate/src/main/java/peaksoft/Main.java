package peaksoft;

import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;
import peaksoft.util.Util;

public class Main {
    public static void main(String[] args) {
//        Util.connection();
        UserService userService = new UserServiceImpl();
//        userDaoJdbc.createUsersTable();
        userService.saveUser("Abdimalik","Abdurakhmanov",  (byte)23);
//        userDaoJdbc.dropUsersTable();
//        userDaoJdbc.removeUserById(2);
        System.out.println(userService.getAllUsers().size());
//        userDaoJdbc.cleanUsersTable();
        // реализуйте алгоритм здесь

    }
}
