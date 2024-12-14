package lk.bolton.SocialMediaApplication.controller;

/*
 * @Author  dilus
 * @Project social-media-app
 * @Created 08/12/2024 - 4:20 AM

 */



import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import lk.bolton.SocialMediaApplication.bo.custom.SubscriptionBO;
import lk.bolton.SocialMediaApplication.bo.custom.impl.SubscriptionBOImpl;
import lk.bolton.SocialMediaApplication.entity.Subscription;

import java.sql.SQLException;

public class SubscriptionController {

    private SubscriptionBO subscriptionBO;

    @FXML
    private Button subscribeButton;

    @FXML
    private Button unsubscribeButton;

    private String loggedInUserID;

    public SubscriptionController() throws SQLException {
        subscriptionBO = new SubscriptionBOImpl();
    }

    @FXML
    private void initialize() {
        // Add initialization logic here if needed
    }

    @FXML
    private void onSubscribeClicked() {
        String selectedUserID = "someUserID";  // This should come from UI selection

        Subscription subscription = new Subscription();
        subscription.setSubscriberID(loggedInUserID);
        subscription.setSubscribedID(selectedUserID);

        try {
            if (!subscriptionBO.isSubscribed(loggedInUserID, selectedUserID)) {
                subscriptionBO.subscribeUser(subscription);
                Alert alert = new Alert(AlertType.INFORMATION, "You have successfully subscribed.");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(AlertType.WARNING, "You are already subscribed.");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "Error subscribing: " + e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void onUnsubscribeClicked() {
        String selectedUserID = "someUserID";  // This should come from UI selection

        Subscription subscription = new Subscription();
        subscription.setSubscriberID(loggedInUserID);
        subscription.setSubscribedID(selectedUserID);

        try {
            subscriptionBO.unsubscribeUser(subscription);
            Alert alert = new Alert(AlertType.INFORMATION, "You have successfully unsubscribed.");
            alert.showAndWait();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "Error unsubscribing: " + e.getMessage());
            alert.showAndWait();
        }
    }
}

