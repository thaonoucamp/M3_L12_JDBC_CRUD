package dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IDao {
    void insertUser(User user) throws SQLException, ClassNotFoundException;

    User selectUser(int id) throws SQLException, ClassNotFoundException;

    List<User> selectAllUser() throws SQLException, ClassNotFoundException;

    boolean deleteUser(int id);

    boolean updateUser(User user);

}
