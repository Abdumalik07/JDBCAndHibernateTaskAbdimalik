package peaksoft.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import peaksoft.model.User;
import peaksoft.util.HibernateUtil;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {
    }
    @Override
    public void createUsersTable() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
//            session.createSQLQuery("CREATE TABLE users(id serial PRIMARY KEY,name" +
//                            " VARCHAR,last_name VARCHAR,age INT)")
//                    .addEntity(User.class).executeUpdate();
            session.getTransaction().commit();
            System.out.println("Table created successful!");
            session.close();
        } catch (HibernateException e) {
            System.err.println("Table don't created successful");
        }
    }
    @Override
    public void dropUsersTable() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.createSQLQuery("DROP TABLE users").executeUpdate();
            session.getTransaction().commit();
            System.out.println("Table dropped successful!");
            session.close();
        } catch (HibernateException e) {
            System.err.println("Table don't dropped!");
        }
    }
    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {
            User user = new User(name, lastName, age);
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.update(user);
            session.getTransaction().commit();
            System.out.println("User saves in the table successful!");
            session.close();
        } catch (HibernateException e) {
            System.out.println("User don't save in the table!");
        }
    }
    @Override
    public void removeUserById(long id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
            System.out.println("User with id remove successful!");
            session.close();
        } catch (HibernateException e) {
            System.out.println("User with id don't remove!");
        }
    }
    @Override
    public List<User> getAllUsers() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List<User> users = session.createQuery("FROM User ").getResultList();
            session.getTransaction().commit();
            session.close();
            return users;
        } catch (HibernateException e) {
            System.out.println("Get all users don't work!");
            return null;
        }
    }
    @Override
    public void cleanUsersTable() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.createSQLQuery("DELETE FROM users").executeUpdate();
            session.getTransaction().commit();
            System.out.println("Table cleaned successful!");
            session.close();
        } catch (HibernateException e) {
            System.err.println("Table don't cleaned!");
        }
    }
}
