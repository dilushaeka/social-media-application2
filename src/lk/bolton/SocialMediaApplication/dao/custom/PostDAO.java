package lk.bolton.SocialMediaApplication.dao.custom;

/*
 * @Author  dilus
 * @Project social-media-app
 * @Created 08/12/2024 - 3:32 AM

 */


import javafx.collections.ObservableList;
import lk.bolton.SocialMediaApplication.dao.CrudDAO;
import lk.bolton.SocialMediaApplication.dto.PostDTO;
import lk.bolton.SocialMediaApplication.entity.Post;
import java.sql.SQLException;
import java.util.List;

public interface PostDAO extends CrudDAO<Post,String> {
    boolean addPost(PostDTO post) throws SQLException, ClassNotFoundException;


    ObservableList<Post> getPostsByUser(String castID) throws SQLException, ClassNotFoundException;
    List<Post> getAllPosts() throws SQLException, ClassNotFoundException;

    List<Post> getAllPosts(String castID) throws SQLException, ClassNotFoundException;
}

