package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    public UserDaoJdbcImpl() {

    }

    public void createUsersTable() {
        String createTable = "create table if not exists users(id serial primary key," +
                "name varchar(250)," +
                "last_name varchar(250)," +
                "age int not null);";
        try(Connection connection = Util.connection();
            Statement statement = connection.createStatement()){
            System.out.println(statement.executeUpdate(createTable));
            System.out.println("table created");
        }catch (SQLException e){
            e.getMessage();
            System.out.println("Error");
        }
    }

    public void dropUsersTable() {
        String dropTable = "drop table if exists users";
        try(Connection connection = Util.connection();
            Statement statement = connection.createStatement()){
            System.out.println(statement.executeUpdate(dropTable));
            System.out.println("table deleted");
        }catch (SQLException e){
            e.getMessage();
            System.out.println("Error");
        }


    }

    public void saveUser(String name, String lastName, byte age) {
        String saveUser = "insert into users (name, last_name, age)" +
                "values(?,?,?);";
        try(Connection connection = Util.connection();
            PreparedStatement preparedStatement = connection.prepareStatement(saveUser)){
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.executeUpdate();
            System.out.println("added");
        }catch (SQLException e){
            e.getMessage();
            System.out.println("error");
        }

    }

    public void removeUserById(long id) {
        String removeUsers = "delete from users where id=?";
        try(Connection connection = Util.connection();
            PreparedStatement preparedStatement = connection.prepareStatement(removeUsers)){
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
            System.out.println("deleted");
        }catch (SQLException e){
            e.getMessage();
            System.out.println("error");
        }
    }
    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();
        String getAllUsers = "select * from users";
        try(Statement statement = Util.connection().createStatement();
            ResultSet resultSet = statement.executeQuery(getAllUsers)){
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setAge(resultSet.getByte("age"));
                allUsers.add(user);
            }
            return allUsers;
        }catch (SQLException e){
            e.getMessage();
            System.out.println("error");
            return null;
        }
    }

    public void cleanUsersTable() {
        String cleanUsersTable = "delete from users";
        try (Connection connection = Util.connection();
        Statement statement = connection.createStatement()){
            statement.executeUpdate(cleanUsersTable);
        }catch (SQLException e){
            e.getMessage();
            System.out.println("deleted");
        }

    }
}