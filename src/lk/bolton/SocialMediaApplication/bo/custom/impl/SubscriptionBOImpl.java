package lk.bolton.SocialMediaApplication.bo.custom.impl;

/*
 * @Author  dilus
 * @Project social-media-app
 * @Created 08/12/2024 - 4:19 AM

 */


import lk.bolton.SocialMediaApplication.bo.custom.SubscriptionBO;
import lk.bolton.SocialMediaApplication.dao.custom.SubscriptionDAO;
import lk.bolton.SocialMediaApplication.dao.custom.impl.SubscriptionDAOImpl;
import lk.bolton.SocialMediaApplication.entity.Subscription;

import java.sql.SQLException;

public class SubscriptionBOImpl implements SubscriptionBO {

    private SubscriptionDAO subscriptionDAO;

    public SubscriptionBOImpl() throws SQLException {
        subscriptionDAO = new SubscriptionDAOImpl();
    }

    @Override
    public void subscribeUser(Subscription subscription) throws SQLException {
        subscriptionDAO.subscribeUser(subscription);
    }

    @Override
    public void unsubscribeUser(Subscription subscription) throws SQLException {
        subscriptionDAO.unsubscribeUser(subscription);
    }

    @Override
    public boolean isSubscribed(String subscriberID, String subscribedID) throws SQLException {
        return subscriptionDAO.isSubscribed(subscriberID, subscribedID);
    }
}
