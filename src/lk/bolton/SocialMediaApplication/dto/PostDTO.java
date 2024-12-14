package lk.bolton.SocialMediaApplication.dto;

/*
 * @Author  dilus
 * @Project social-media-app
 * @Created 08/12/2024 - 4:28 AM

 */


import java.util.Date;

public class PostDTO {
    private int postID;
    private String castID;   // The user who created the post
    private String postContent;  // The content of the post
    private Date postDate; // The time when the post was created

    public PostDTO(int postID, String castID, String postContent, Date postDate) {
        this.postID = postID;
        this.castID = castID;
        this.postContent = postContent;
        this.postDate = postDate;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public String getCastID() {
        return castID;
    }

    public void setCastID(String castID) {
        this.castID = castID;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }
}

