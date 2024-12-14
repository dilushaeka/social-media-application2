package lk.bolton.SocialMediaApplication.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.bolton.SocialMediaApplication.dao.CrudUtil;
import lk.bolton.SocialMediaApplication.dao.custom.UserDAO;
import lk.bolton.SocialMediaApplication.entity.User;
import lk.bolton.SocialMediaApplication.db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public String getUserLastId() throws Exception {
        String sql = "select max(id) from user";
        ResultSet rst = CrudUtil.executeQuery(sql);
        if (rst.next()) {
            return rst.getString(1);
        }
        return "";
    }

    @Override
    public int getRowCount() throws ClassNotFoundException, SQLException {
        return 0;
    }

    @Override
    public User validate(String userName) throws SQLException, ClassNotFoundException {
        String sql = "SELECT castID , caslogin , caspassword FROM user WHERE caslogin=?";
        ResultSet resultSet = CrudUtil.executeQuery(sql, userName);
        if(resultSet.next()){
            return new User(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
        }
        return null;
    }

    @Override
    public boolean add(User ID) throws ClassNotFoundException, SQLException {
        String sql = "insert into user values(?,?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql, ID.getCastID(), ID.getCastName(), ID.getCastBirthDay(), ID.getCastAddress(),  ID.getCastlogin(), ID.getCastPassword());
    }

    @Override
    public boolean delete(String ID) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM user WHERE castID= ?";
        return CrudUtil.executeUpdate(sql, ID);
    }

    @Override
    public boolean update(User ID) throws ClassNotFoundException, SQLException {
        String sql = "update user set castName =?,castBirthDay=?,castAddress=?,caslogin=?,caspassword=? where castID=?";
        return CrudUtil.executeUpdate(sql, ID.getCastID(), ID.getCastName(), ID.getCastBirthDay(), ID.getCastAddress(),ID.getCastlogin(), ID.getCastPassword());
    }

    @Override
    public User search(String ID) throws ClassNotFoundException, SQLException {
        String sql = "select * from user where castID=?";
        ResultSet rst = CrudUtil.executeQuery(sql, ID);
        if (rst.next()) {
            return new User(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6));
        }
        return null;
    }

    @Override
    public ObservableList<User> getAll() throws ClassNotFoundException, SQLException {
        String sql = "select * from user";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ObservableList<User> allUser = FXCollections.observableArrayList();
        while (rst.next()) {
            allUser.add(new User(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6)));
        }
        return allUser;
    }
}
