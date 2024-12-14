package lk.bolton.SocialMediaApplication.bo.custom;

import javafx.collections.ObservableList;
import lk.bolton.SocialMediaApplication.bo.SuperBO;
import lk.bolton.SocialMediaApplication.dto.UserDTO;
import lk.bolton.SocialMediaApplication.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserBO extends SuperBO {

    static UserDTO getValidated(String text) {
        return null;
    }

    boolean addUser(UserDTO user) throws ClassNotFoundException, SQLException;

    boolean deleteUser(String id) throws ClassNotFoundException, SQLException;

    boolean updateUser(UserDTO user) throws ClassNotFoundException, SQLException;

    UserDTO searchUser(String id) throws ClassNotFoundException, SQLException;

    ObservableList<UserDTO> getAllUser() throws ClassNotFoundException, SQLException;

    int getRowCount()throws ClassNotFoundException,SQLException;


}
