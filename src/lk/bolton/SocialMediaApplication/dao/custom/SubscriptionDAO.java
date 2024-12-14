package lk.bolton.SocialMediaApplication.dao.custom;

/*
 * @Author  dilus
 * @Project social-media-app
 * @Created 08/12/2024 - 4:13 AM

 */


import lk.bolton.SocialMediaApplication.entity.Subscription;
import java.sql.SQLException;

public interface SubscriptionDAO {
    void subscribeUser(Subscription subscription) throws SQLException;
    void unsubscribeUser(Subscription subscription) throws SQLException;
    boolean isSubscribed(String subscriberID, String subscribedID) throws SQLException;
}

