package lk.bolton.SocialMediaApplication.controller;

/*
 * @Author  dilus
 * @Project social-media-app
 * @Created 08/12/2024 - 11:56 PM

 */

import com.oracle.deploy.update.UpdateCheck;
import javafx.collections.ObservableList;
import lk.bolton.SocialMediaApplication.bo.custom.PostBO;
import lk.bolton.SocialMediaApplication.db.DBConnection;
import lk.bolton.SocialMediaApplication.bo.custom.impl.PostBOImpl.*;
import lk.bolton.SocialMediaApplication.dto.PostDTO;
import lk.bolton.SocialMediaApplication.controller.LoginFormController.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class HomaPageController {

    private void allPosts () throws SQLException, ClassNotFoundException {

        PostBO postBO = new PostBO() {
            @Override
            public boolean addPost(PostDTO post) throws SQLException, ClassNotFoundException {
                return false;
            }

            @Override
            public ObservableList<PostDTO> getPostsByUser(String userID) throws SQLException, ClassNotFoundException {
                return null;
            }

            @Override
            public List<PostDTO> getAllPosts() throws SQLException, ClassNotFoundException {
                return null;
            }
        };
    }

}
