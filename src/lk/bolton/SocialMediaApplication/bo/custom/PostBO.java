package lk.bolton.SocialMediaApplication.bo.custom;

/*
 * @Author  dilus
 * @Project social-media-app
 * @Created 08/12/2024 - 3:35 AM

 */



import javafx.collections.ObservableList;
import lk.bolton.SocialMediaApplication.bo.SuperBO;
import lk.bolton.SocialMediaApplication.dao.custom.PostDAO;
import lk.bolton.SocialMediaApplication.entity.Post;
import lk.bolton.SocialMediaApplication.dto.PostDTO;

import java.sql.SQLException;
import java.util.List;

public interface PostBO extends SuperBO {
    boolean addPost(PostDTO post) throws SQLException, ClassNotFoundException;

    ObservableList<PostDTO> getPostsByUser(String userID) throws SQLException, ClassNotFoundException;

    List<PostDTO> getAllPosts() throws SQLException, ClassNotFoundException;
}

