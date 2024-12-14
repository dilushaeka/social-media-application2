package lk.bolton.SocialMediaApplication.entity;

/*
 * @Author  dilus
 * @Project social-media-app
 * @Created 08/12/2024 - 3:26 AM

 */


import java.util.Date;

public class Post {
    private int postId;
    private String castID; // References user (castID)
    private String postContent;
    private Date postDate;

    public Post() {
    }

    public Post(int postId, String castID, String postContent, Date postDate) {
        this.postId = postId;
        this.castID = castID;
        this.postContent = postContent;
        this.postDate = postDate;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
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
