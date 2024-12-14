package lk.bolton.SocialMediaApplication.controller;

import animatefx.animation.FadeIn;
import animatefx.animation.FadeInDownBig;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.paint.Color.TRANSPARENT;

/*
 * @Author  dilus
 * @Project social-media-app
 * @Created 08/12/2024 - 1:27 AM

 */public class dashboardController implements Initializable {
    public Pane context;
    public JFXButton dtnDashBoard;
    public AnchorPane root1;
    public JFXButton btnDashBoard;

    Parent root;

    double xOffset, yOffset;


    private void setUi(String location) throws IOException {
        context.getChildren().clear();
        context.getChildren().add(FXMLLoader.load(this.getClass().
                getResource("/lk/bolton/SocialMediaApplication/view/" + location + ".fxml")));
    }

    public void DashBoardOnAction() throws IOException {
        setUi("HomePageForm");
        new FadeIn(context).play();

    }


    public void btnAboutOnAction() throws IOException {
        setUi("AboutForm");
        new FadeIn(context).play();
    }

    public void btnLogOut(ActionEvent actionEvent) {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.close();

        try {
            // Load the login form again
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/ijse/UkTileShopManage/view/LoginForm.fxml"));
            Parent root = loader.load();

            // Set up a new stage for the login form
            Stage loginStage = new Stage();
            Scene scene = new Scene(root);
            loginStage.initStyle(StageStyle.TRANSPARENT);
            loginStage.setScene(scene);
            loginStage.show();

            // Add animations for the login form
            new FadeInDownBig(root).play();
            scene.setFill(TRANSPARENT);

            // Make the login form draggable
            root.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });
            root.setOnMouseDragged(event -> {
                loginStage.setX(event.getScreenX() - xOffset);
                loginStage.setY(event.getScreenY() - yOffset);
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            DashBoardOnAction();
            new FadeIn(context).play();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void AddPostOnAction(ActionEvent actionEvent) throws IOException {
        setUi("AddPostForm");
        new FadeIn(context).play();
    }

    public void btnViewAllUsers(ActionEvent actionEvent) throws IOException {
        setUi("ViewUsers");
        new FadeIn(context).play();
    }
}
