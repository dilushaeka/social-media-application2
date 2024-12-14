package lk.bolton.SocialMediaApplication.controller;

import animatefx.animation.FadeInDownBig;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import lk.bolton.SocialMediaApplication.bo.custom.UserBO;
import lk.bolton.SocialMediaApplication.bo.custom.impl.LoginBOImpl;
import lk.bolton.SocialMediaApplication.bo.custom.LoginBO;
import lk.bolton.SocialMediaApplication.dto.UserDTO;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

import static javafx.scene.paint.Color.TRANSPARENT;

public class LoginFormController {
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    public AnchorPane root;
    public AnchorPane loginRoot;
    public JFXButton btnSignIn;
    public JFXButton btnCLose;

    UserBO  userBO;


    public void LoginOnAction() throws IOException {

         String userName = txtUserName.getText().trim();
        String password = txtPassword.getText().trim();
        if (Pattern.compile("^(thilina)$").matcher(userName).matches()) {


        } else {
            txtUserName.setFocusColor(Paint.valueOf("red"));
            txtUserName.requestFocus();


        }
        if (Pattern.compile("^(2259)$").matcher(userName).matches()) {
        } else {
            txtPassword.setFocusColor(Paint.valueOf("red"));
            txtPassword.requestFocus();

        }
        if (userName.length() > 0 && password.length() > 0) {
            if (userName.equalsIgnoreCase("dilusha")
                    && password.equals("1234")) {
                //FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/Dashboard.fxml"));
                Stage window = (Stage) this.root.getScene().getWindow();
                window.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/lk/bolton/SocialMediaApplication/view/Dashboard.fxml"))));
                window.centerOnScreen();
                String tilte = "Sign In";
                String message = "WELCOME TO UK TILES MANAGEMENT SYSTEM ";
                TrayNotification tray = new TrayNotification();
                AnimationType type = AnimationType.POPUP;
                tray.setAnimationType(type);
                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.SUCCESS);
                tray.showAndDismiss(Duration.millis(3000));

            } else {
                LoginBO loginBO = new LoginBOImpl();
                try {
                    UserDTO userDTO = loginBO.getValidated(txtUserName.getText());
                    System.out.println(userDTO.getCastID()+" id from login form");
                    System.out.println(userDTO.getCastlogin() + " userName");
                    System.out.println(userDTO.getCastPassword() + " password");

                    if (userDTO.getCastlogin().equals(txtUserName.getText()) &&
                            userDTO.getCastPassword().equals(txtPassword.getText())) {

                        Stage window = (Stage) this.root.getScene().getWindow();
//                        window.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/UserForm.fxml"))));
                        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("../view/UserForm.fxml"));
                        Parent parent =  fxmlLoader.load();
                        UserFormController controller = fxmlLoader.getController();
                        System.out.println("sending data");
                        controller.setUserID(userDTO.getCastID());
                        window.setScene(new Scene(parent));
                        window.centerOnScreen();
                        window.show();

                    } else {
                        System.out.println("waradi ukanno");
                    }
                } catch (NullPointerException e) {
                    System.out.println("user name waradi ballo");
                    System.out.println("=======================NullPointerException  11-----===================");
                    System.out.println(e);
                } catch (SQLException throwables) {
                    System.out.println("=======================throwables===================");
                    System.out.println(throwables);
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    System.out.println("=======================ClassNotFoundException===================");
                    System.out.println(e);
                    e.printStackTrace();
                }
                txtUserName.setFocusColor(Paint.valueOf("red"));
                txtUserName.requestFocus();
                String tilte = "Sign In";
                String message = "Error Username " + "'" + txtUserName.getText() + "'" + ", and Password " + "'" + txtPassword.getText() + "'" + " Wrong";
                tray.notification.TrayNotification tray = new TrayNotification();
                AnimationType type = AnimationType.POPUP;

                tray.setAnimationType(type);
                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.ERROR);
                tray.showAndDismiss(Duration.millis(3000));
            }
        } else {
            String tilte = "Sign In";
            String message = "Empty Username Or Password";
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;

            tray.setAnimationType(type);
            tray.setTitle(tilte);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.INFORMATION);
            tray.showAndDismiss(Duration.millis(3000));
        }
    }


    public void btnCloaseOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
    }


    double xOffset, yOffset;
    public void SignUpOnAction(ActionEvent actionEvent) {
        Stage primaryStage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/SignForm.fxml"));
            root = loader.load();
            //root = FXMLLoader.load((this.getClass().getClassLoader().getResource("view/LoginForm.fxml")));
            Scene scene = new Scene(root);
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            primaryStage.setScene(scene);
            primaryStage.show();
            new FadeInDownBig(root).play();
            scene.setFill(TRANSPARENT);
            root.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });
            root.setOnMouseDragged(event -> {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
