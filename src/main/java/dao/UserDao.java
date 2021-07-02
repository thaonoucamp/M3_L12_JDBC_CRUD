package dao;

import model.User;

import java.sql.*;
import java.util.List;

public class UserDao implements IDao {
    private String JDBC_URL = "jdbc:mysql://localhost:3306/ManageUser_JDBC_MySQL";
    private String JDBC_USER_NAME = "root";
    private String JDBC_PASSWORD = "04051990";

    private static final String INSERT_USERS_SQL = "insert in users " + "(name, email, country) values " + " (?, ?, ?);";
    private static final String DELETE_USERS_SQL = "delete from users where id = ? ";
    private static final String UPDATE_USERS_SQL = "update from users where id = ?";
    private static final String SELECT_USERS_BY_ID = "select id, name, email, country from users where id = ?";
    private static final String SELECT_ALL_USERS = "select * from users";

    public UserDao() {

    }

    protected Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName("com.mrsql.jdbc.Driver");
        connection = DriverManager.getConnection(JDBC_URL, JDBC_USER_NAME, JDBC_PASSWORD);
        return connection;
    }

    @Override
    public void insertUser(User user) throws SQLException, ClassNotFoundException {
        System.out.println(INSERT_USERS_SQL);
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setString(3, user.getAddress());
        System.out.println(preparedStatement);
        preparedStatement.executeUpdate();
    }

    @Override
    public User selectUser(int id) throws SQLException, ClassNotFoundException {
        User user = null;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getConnection().prepareStatement(SELECT_USERS_BY_ID);
        preparedStatement.setInt(1, id);
        System.out.println(preparedStatement);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String address = resultSet.getString("address");
            user = new User(id, name, email, address);
        }
        return user;
    }

    @Override
    public List<User> selectAllUser() {

        return null;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }
}
