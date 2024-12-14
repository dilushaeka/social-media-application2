package lk.bolton.SocialMediaApplication.controller;
import lk.bolton.SocialMediaApplication.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.bolton.SocialMediaApplication.bo.BOFactory;
import lk.bolton.SocialMediaApplication.bo.custom.UserBO;
import lk.bolton.SocialMediaApplication.bo.custom.impl.UserBOImpl;
import lk.bolton.SocialMediaApplication.dto.UserDTO;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class SignFormController implements Initializable {
    public JFXTextField txtUserID;
    public JFXTextField txtPassword;
    public JFXTextField txtUserName;
    public JFXTextField txtLogin;
    public ImageView imageid;
    public JFXButton btnsignup;
    public JFXDatePicker txtUserBirthDay;
    public JFXTextField txtUserAddress;
    public AnchorPane root;
    public JFXButton btnCLose;
    public JFXButton btnsignUp;

    UserBO userBO = new UserBOImpl();
    String picName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        loadAllUser();
    }

    private void loadAllUser() {
//        try {
//            ObservableList<UserDTO> allUser = userBO.getAllUser();
//            tblUser.setItems(allUser);
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
    }

    public void setOnAction() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
        File file = fileChooser.showOpenDialog(null);
        picName = file.getAbsolutePath();

        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            imageid.setImage(image);
        } catch (IOException ignored) {

        }
    }

    public String generateNextUserID() {
        String nextUserID;
        String lastUserID = null;

        // SQL query to get the last user ID from the database
        String query = "SELECT castID FROM user ORDER BY castID DESC LIMIT 1";

        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                lastUserID = rs.getString("castID");
            }
        } catch (SQLException e) {
            System.err.println("Error while generating next user ID: " + e.getMessage());
            e.printStackTrace();
        }

        // If no user ID is found, start with "0001"
        if (lastUserID == null) {
            nextUserID = "0001";
        } else {
            // Extract the numeric part of the user ID
            int numericPart = Integer.parseInt(lastUserID);
            numericPart++; // Increment the ID

            // Format the new ID with leading zeros (up to 4 digits)
            nextUserID = String.format("%04d", numericPart);
        }

        System.out.println("Generated next User ID: " + nextUserID);
        return nextUserID;
    }


    String nextUserID = generateNextUserID();

    private boolean validateInputs() {
        if (txtUserName.getText().isEmpty() ||
                txtUserAddress.getText().isEmpty() ||
                txtLogin.getText().isEmpty() ||
                txtPassword.getText().isEmpty() ||
                txtUserBirthDay.getValue() == null) {

            new Alert(Alert.AlertType.ERROR, "All fields are required! Please fill in all the details.", ButtonType.OK).show();
            return false;
        }
        return true;
    }


    public void addOnAction(ActionEvent actionEvent) {

        if (!validateInputs()) {
            return; // Prevents further execution if any field is empty
        }
        try {

            boolean isAdded = userBO.addUser(new UserDTO(
                    nextUserID,
                    txtUserName.getText(),
                    txtUserBirthDay.getValue().toString(),
                    txtUserAddress.getText(),
                    txtLogin.getText(),
                    txtPassword.getText())
            );
            String tilte;
            String message;
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            if (isAdded) {
                (new Alert(Alert.AlertType.CONFIRMATION, "User Added Successfully", new ButtonType[]{ButtonType.OK})).show();
                tilte = "Added Successful";
                message = "User Is Added";
                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.SUCCESS);
                loadAllUser();
                btnCloseOnAction(actionEvent);

            } else {
                (new Alert(Alert.AlertType.ERROR, "User Not Added ", new ButtonType[]{ButtonType.OK})).show();
                tilte = "Added Un Successful";
                message = "User Is Not Added";
                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.ERROR);
            }
            tray.showAndDismiss(Duration.millis(3000));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            String tilte = "User Is Already On The Sever you can login";
            String message = "User Is Not Added";
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle(tilte);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.NOTICE);
            tray.showAndDismiss(Duration.millis(3000));
            System.out.println("===============================================================================");
            System.out.println(ex);
        }
        clearUser();
        //Customer Add Is Over(With Notification)
    }

    public void searchOnAction(ActionEvent actionEvent) {
    }

    private void setPic(String castPhoto) {

    }

    public void testingIcon(ActionEvent actionEvent) {

    }

    public void userUpdateOnAction(ActionEvent actionEvent) {
        try {
            String castID = txtUserID.getText();
            String castName = txtUserName.getText();
            String castBirthDay = txtUserBirthDay.getValue().toString();
            String castAddress = txtUserAddress.getText();
            //String castPhoto = picName.intern();
            String caslogin = txtLogin.getText();
            String caspassword = txtPassword.getText();
            UserDTO userDTO = new UserDTO(castID, castName, castBirthDay, castAddress, caslogin, caspassword);
            boolean updateUser = userBO.updateUser(userDTO);
            String tilte;
            String message;
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            if (updateUser) {
                (new Alert(Alert.AlertType.CONFIRMATION, "User Not Update ", new ButtonType[]{ButtonType.OK})).show();
                tilte = "Update Successful";
                message = "User Is Updated";

                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.SUCCESS);
                loadAllUser();

            } else {
                (new Alert(Alert.AlertType.ERROR, "User Not Update", new ButtonType[]{ButtonType.OK})).show();
                tilte = "Update Un Successful";
                message = "User Is Not Updated";

                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.ERROR);
            }
            tray.showAndDismiss(Duration.millis(3000));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        //Customer Update Is Over(With Notification)
        //clearUser();

    }

    public void userDeleteOnAction(ActionEvent actionEvent) {
        String ID = txtUserID.getText();
        try {
            boolean isDelete = userBO.deleteUser(ID);
            String tilte;
            String message;
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            if (isDelete) {
                (new Alert(Alert.AlertType.CONFIRMATION, "User Delete Successfully", new ButtonType[]{ButtonType.OK})).show();
                tilte = "Delete Success";
                message = "User Is Deleted";
                tray.setTitle("Delete Success");
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.SUCCESS);
                loadAllUser();
            } else {
                (new Alert(Alert.AlertType.ERROR, "User Not Deleted", new ButtonType[]{ButtonType.OK})).show();
                tilte = "User Not Found";
                message = "Sorry";
                tray.setTitle("User Not Found");
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.NOTICE);
            }
            tray.showAndDismiss(Duration.millis(3000));
        } catch (SQLException | ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        //Customer Delete Is Over(With Notification)
        clearUser();
    }


    public void tblUserClick() {
//        UserDTO c = (UserDTO) tblUser.getSelectionModel().getSelectedItem();
//        txtUserID.setText(c.getCastID());
//        txtUserName.setText(c.getCastName());
//        txtUserAddress.setText(c.getCastAddress());
//        txtUserBirthDay.setValue(LocalDate.parse(c.getCastBirthDay()));
//        txtLogin.setText(c.getCastlogin());
//        txtPassword.setText(c.getCastPassword());

    }

    public void clearUser(){
        txtUserAddress.clear();
        txtPassword.clear();
        txtLogin.clear();
        txtUserName.clear();
        txtUserBirthDay.setValue(LocalDate.now());
    }

    public void btnCloseOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
    }

}
