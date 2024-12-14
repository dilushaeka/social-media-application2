package lk.bolton.SocialMediaApplication.dao.custom.impl;

/*
 * @Author  dilus
 * @Project social-media-app
 * @Created 08/12/2024 - 3:33 AM

 */


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.bolton.SocialMediaApplication.dao.CrudUtil;
import lk.bolton.SocialMediaApplication.dao.custom.PostDAO;
import lk.bolton.SocialMediaApplication.dto.PostDTO;
import lk.bolton.SocialMediaApplication.entity.Post;

import java.sql.*;
import java.util.Collections;
import java.util.List;

public class PostDAOImpl implements PostDAO {



    @Override
    public boolean addPost(PostDTO post) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO post VALUES (?, ?, ?, ?)";
        return CrudUtil.executeUpdate(sql, post.getPostID(), post.getCastID(), post.getPostContent(), post.getPostDate());

    }

    @Override
    public ObservableList<Post> getPostsByUser(String castID) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM post WHERE userID = ?";
        ResultSet rst = CrudUtil.executeQuery(sql, castID);
        ObservableList<Post> posts = FXCollections.observableArrayList();
        while (rst.next()) {
            posts.add(new Post(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getTimestamp(4)));
        }
        return posts;
    }

    @Override
    public List<Post> getAllPosts() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM post = ?";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ObservableList<Post> posts = FXCollections.observableArrayList();
        while (rst.next()) {
            posts.add(new Post(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getTimestamp(4)));
        }
        return posts;
    }

    @Override
    public List<Post> getAllPosts(String castID) throws SQLException, ClassNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public boolean add(Post ID) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean delete(String ID) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean update(Post ID) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public Post search(String ID) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ObservableList<Post> getAll() throws ClassNotFoundException, SQLException {
        return null;
    }
}

