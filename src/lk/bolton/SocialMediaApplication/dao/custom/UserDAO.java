package lk.bolton.SocialMediaApplication.dao.custom;

import lk.bolton.SocialMediaApplication.dao.CrudDAO;
import lk.bolton.SocialMediaApplication.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO extends CrudDAO<User,String> {
    String getUserLastId()throws Exception;
    int getRowCount()throws ClassNotFoundException, SQLException;
    User validate(String userName) throws SQLException, ClassNotFoundException;


//    List<User> getAllUsers() throws SQLException;
//    User getUserByID(String castID) throws SQLException;
}
