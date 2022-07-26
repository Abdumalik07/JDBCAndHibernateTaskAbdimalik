package peaksoft.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import peaksoft.model.User;

import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateUtil {
    public static SessionFactory factory;
//    public  static SessionFactory  getSessionFactory(){
//        factory = new Configuration()
//            .configure("hibernate.cfg.xml")
//            .addAnnotatedClass(User.class)
//            .buildSessionFactory();
//         return factory;
//}
    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration();
        Properties prop = new Properties();
        prop.setProperty("connection.driver_class","org.postgresql.Driver");
        prop.setProperty("hibernate.connection.url","jdbc:postgresql://localhost:5432/sql_practice");
        prop.setProperty("hibernate.connection.username","postgres");
        prop.setProperty("hibernate.connection.password","postgres");
        prop.setProperty("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
        prop.setProperty("hibernate.show_sql","true");
        prop.setProperty("hibernate.hbm2ddl.auto","update");
        prop.setProperty("hibernate.current_session_context_class","thread");
        configuration.setProperties(prop);
        configuration.addAnnotatedClass(User.class);
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

}
