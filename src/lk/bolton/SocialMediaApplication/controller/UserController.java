package lk.bolton.SocialMediaApplication.controller;

/*
 * @Author  dilus
 * @Project social-media-app
 * @Created 08/12/2024 - 4:07 AM

 */


import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import lk.bolton.SocialMediaApplication.bo.custom.UserBO;
import lk.bolton.SocialMediaApplication.bo.custom.impl.UserBOImpl;
import lk.bolton.SocialMediaApplication.dto.UserDTO;
import lk.bolton.SocialMediaApplication.entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserController {

    private UserBO userBO;

    @FXML
    private ListView<String> userListView;

    @FXML
    private Button viewUserDetailsButton;

    public UserController() {
        userBO = new UserBOImpl();
    }

    @FXML
    private void initialize() {
//        try {
//            List<User> users = userBO.getAllUsers();
//            for (User user : users) {
//                userListView.getItems().add(user.getCastName());
//            }
//        } catch (SQLException e) {
//            Alert alert = new Alert(AlertType.ERROR, "Error loading users: " + e.getMessage());
//            alert.showAndWait();
//        }
    }

    @FXML
    private void onViewUserDetailsClicked() {
        String selectedUserName = userListView.getSelectionModel().getSelectedItem();
//        try {
//            User user = userBO.searchUser(selectedUserName);
//            if (user != null) {
//                // Show user details (a new view or dialog can be opened here)
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//            Alert alert = new Alert(AlertType.ERROR, "Error fetching user details: " + e.getMessage());
//            alert.showAndWait();
//        }
    }
}

