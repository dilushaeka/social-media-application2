package lk.bolton.SocialMediaApplication.entity;

/*
 * @Author  dilus
 * @Project social-media-app
 * @Created 08/12/2024 - 4:11 AM

 */

public class Subscription {
    private String subscriberID;
    private String subscribedID;

    // Getters and Setters
    public String getSubscriberID() {
        return subscriberID;
    }

    public void setSubscriberID(String subscriberID) {
        this.subscriberID = subscriberID;
    }

    public String getSubscribedID() {
        return subscribedID;
    }

    public void setSubscribedID(String subscribedID) {
        this.subscribedID = subscribedID;
    }
}

