package lk.bolton.SocialMediaApplication.bo.custom.impl;

import lk.bolton.SocialMediaApplication.bo.custom.LoginBO;
import lk.bolton.SocialMediaApplication.dao.DAOFactory;
import lk.bolton.SocialMediaApplication.dao.custom.UserDAO;
import lk.bolton.SocialMediaApplication.dto.UserDTO;
import lk.bolton.SocialMediaApplication.entity.User;

import java.sql.SQLException;

public class LoginBOImpl implements LoginBO {
    UserDAO userDAO = (UserDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public UserDTO getValidated(String userName) throws SQLException, ClassNotFoundException {
//        User validate = usersDAO.validate(userName);
//        return new UsersDTO(validate.getUser_name(),validate.getUser_password(),validate.getPosition());
        User cus = userDAO.validate(userName);
        return new UserDTO(cus.getCastID(),cus.getCastlogin(),cus.getCastPassword());
    }
}
