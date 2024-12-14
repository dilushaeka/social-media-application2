package lk.bolton.SocialMediaApplication.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.bolton.SocialMediaApplication.bo.custom.PostBO;
import lk.bolton.SocialMediaApplication.dao.DAOFactory;
import lk.bolton.SocialMediaApplication.dao.custom.PostDAO;
import lk.bolton.SocialMediaApplication.dto.PostDTO;
import lk.bolton.SocialMediaApplication.entity.Post;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;


public class PostBOImpl implements PostBO {

    // Get PostDAO instance from DAOFactory
    PostDAO postDAO = (PostDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.POST);


    private Date convertStringToDate(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // Match the database date format
        try {
            return formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null; // Return null if parsing fails (or handle appropriately in your app)
        }
    }

    @Override
    public boolean addPost(PostDTO post) throws SQLException, ClassNotFoundException {

        // Convert PostDTO to Post entity and pass to DAO
        PostDTO newPost = new PostDTO(post.getPostID(), post.getCastID(), post.getPostContent(), post.getPostDate());
        return postDAO.addPost(newPost);
    }

    @Override
    public ObservableList<PostDTO> getPostsByUser(String castID) throws SQLException, ClassNotFoundException {
        // Retrieve posts from DAO, convert to DTO, and return as ObservableList
        ObservableList<Post> posts = postDAO.getPostsByUser(castID);
        ObservableList<PostDTO> postDTOs = FXCollections.observableArrayList();
        for (Post post : posts) {
            postDTOs.add(new PostDTO(post.getPostId(), post.getCastID(), post.getPostContent(), convertStringToDate(post.getPostContent())));
        }
        return postDTOs;
    }

    @Override
    public List<PostDTO> getAllPosts() throws SQLException, ClassNotFoundException {
        // Retrieve all posts from DAO, convert to DTO, and return as a List
        List<Post> posts = postDAO.getAllPosts();
        List<PostDTO> postDTOs = new ArrayList<>();
        for (Post post : posts) {
            postDTOs.add(new PostDTO(post.getPostId(), post.getCastID(), post.getPostContent(), post.getPostDate()));
        }
        return postDTOs;
    }
}
