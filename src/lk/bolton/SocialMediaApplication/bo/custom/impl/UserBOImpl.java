package lk.bolton.SocialMediaApplication.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.bolton.SocialMediaApplication.bo.custom.UserBO;
import lk.bolton.SocialMediaApplication.dao.DAOFactory;
import lk.bolton.SocialMediaApplication.dao.custom.UserDAO;
import lk.bolton.SocialMediaApplication.dao.custom.impl.UserDAOImpl;
import lk.bolton.SocialMediaApplication.dto.UserDTO;
import lk.bolton.SocialMediaApplication.entity.User;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class UserBOImpl implements UserBO {
    UserDAO userDAO = (UserDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public boolean addUser(UserDTO user) throws ClassNotFoundException, SQLException {
        return userDAO.add(new User(user.getCastID(),user.getCastName(),user.getCastBirthDay(),user.getCastAddress(),user.getCastlogin(),user.getCastPassword()));
    }

    @Override
    public boolean deleteUser(String id) throws ClassNotFoundException, SQLException {
        return userDAO.delete(id);
    }

    @Override
    public boolean updateUser(UserDTO user) throws ClassNotFoundException, SQLException {
        return userDAO.update(new User(user.getCastID(),user.getCastName(),user.getCastBirthDay(),user.getCastAddress(),user.getCastlogin(),user.getCastPassword()));
    }

    @Override
    public UserDTO searchUser(String id) throws ClassNotFoundException, SQLException {
        User search = userDAO.search(id);
        return new UserDTO(search.getCastID(),search.getCastName(),search.getCastBirthDay(),search.getCastAddress(),search.getCastlogin(),search.getCastPassword());
    }

    @Override
    public ObservableList<UserDTO> getAllUser() throws ClassNotFoundException, SQLException {
        ObservableList<User> all =userDAO.getAll();
        ObservableList<UserDTO> allUser = FXCollections.observableArrayList();
        for (User ID : all) {
            UserDTO dto = new UserDTO(ID.getCastID(),ID.getCastName(),ID.getCastBirthDay(),ID.getCastAddress(),ID.getCastlogin(),ID.getCastPassword());
            allUser.add(dto);
        }
        return allUser;
    }

    @Override
    public int getRowCount() throws ClassNotFoundException, SQLException {
        return userDAO.getRowCount();
    }


}
