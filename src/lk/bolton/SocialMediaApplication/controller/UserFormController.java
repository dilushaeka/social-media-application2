package lk.bolton.SocialMediaApplication.controller;

import animatefx.animation.FadeIn;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserFormController implements Initializable {
    public Pane context;
    private String userID;

    public void setUserID(String userID) {
        System.out.println(userID + " setter methood");
        this.userID = userID;

    }

    private void setUi(String location) throws IOException {
        context.getChildren().clear();
        context.getChildren().add(FXMLLoader.load(this.getClass().
                getResource("/lk/ijse/UkTileShopManage/view/" + location + ".fxml")));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            btnPlaceOrderOnAction();
//            new FadeIn(context).play();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void btnPlaceOrderOnAction() throws IOException {
    }

    public void btnCustomerOnAction(ActionEvent actionEvent) throws IOException {
        setUi("AddCustomerForm");
        new FadeIn(context).play();
    }

    public void btnAboutOnAction(ActionEvent actionEvent) throws IOException {
        setUi("AboutForm");
        new FadeIn(context).play();
    }


    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {
//        Stage stage = (Stage) context.getScene().getWindow();
//        stage.close();
//
//        Stage dashBoardScene = new Stage();
//        dashBoardScene.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/LoginForm.fxml"))));
//
//        dashBoardScene.show();
//    }
        Stage stage = (Stage) context.getScene().getWindow();
        stage.close();
    }
}
