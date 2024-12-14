package lk.bolton.SocialMediaApplication.bo.custom;

import lk.bolton.SocialMediaApplication.bo.SuperBO;
import lk.bolton.SocialMediaApplication.dto.UserDTO;

import java.sql.SQLException;

public interface LoginBO extends SuperBO {
    UserDTO getValidated(String userName) throws SQLException, ClassNotFoundException;
}
