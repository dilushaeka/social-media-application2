package lk.bolton.SocialMediaApplication.controller;

/*
 * @Author  dilus
 * @Project social-media-app
 * @Created 08/12/2024 - 3:38 AM

 */


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import lk.bolton.SocialMediaApplication.bo.custom.PostBO;
import lk.bolton.SocialMediaApplication.bo.custom.impl.PostBOImpl;
import lk.bolton.SocialMediaApplication.db.DBConnection;
import lk.bolton.SocialMediaApplication.entity.Post;
import lk.bolton.SocialMediaApplication.dto.PostDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class PostController {

    private PostBO postBO;
    private String loggedInUserID; // Assume this comes from login

    @FXML
    private TextArea postContentTextArea;

    @FXML
    private Button createPostButton;

    public PostController() {
        postBO = new PostBOImpl();
    }

    @FXML
    private void initialize() {
    }

    public int generateNextUserID() {
        int nextUserID;
        int lastUserID = 0;

        // SQL query to get the last user ID from the database
        String query = "SELECT postID FROM post ORDER BY postID DESC LIMIT 1";

        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                lastUserID = rs.getInt("postID");
            }
        } catch (SQLException e) {
            System.err.println("Error while generating next Post ID: " + e.getMessage());
            e.printStackTrace();
        }

        // If no user ID is found, start with "0001"
        if (lastUserID == 0) {
            nextUserID = 0001;
        } else {
            // Extract the numeric part of the user ID
            int numericPart = lastUserID;
            numericPart++; // Increment the ID

            // Format the new ID with leading zeros (up to 4 digits)
            String formattedUserID = String.format("%04d", numericPart);
            nextUserID = Integer.parseInt(formattedUserID);
        }

        System.out.println("Generated next User ID: " + nextUserID);
        return nextUserID;
    }


    int nextPostID = generateNextUserID();

    @FXML
    private void onCreatePostClicked() {
        String content = postContentTextArea.getText();
        if (content.isEmpty()) {
            Alert alert = new Alert(AlertType.WARNING, "Post content cannot be empty!");
            alert.showAndWait();
            return;
        }

        PostDTO post = new PostDTO(
                nextPostID,
                loggedInUserID,
                content,
                new Date());

        try {
            postBO.addPost(post);
            Alert alert = new Alert(AlertType.INFORMATION, "Post created successfully!");
            alert.showAndWait();
        } catch (SQLException | ClassNotFoundException e) {
            Alert alert = new Alert(AlertType.ERROR, "Error creating post: " + e.getMessage());
            alert.showAndWait();
        }
    }
}
