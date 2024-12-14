package lk.bolton.SocialMediaApplication.dto;

/*
 * @Author  dilus
 * @Project social-media-app
 * @Created 08/12/2024 - 4:24 AM

 */


public class SubscriptionDTO {
    private String subscriberID;
    private String subscribedID;

    // Constructors
    public SubscriptionDTO(String subscriberID, String subscribedID) {
        this.subscriberID = subscriberID;
        this.subscribedID = subscribedID;
    }

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

