package lk.bolton.SocialMediaApplication.dao.custom.impl;

/*
 * @Author  dilus
 * @Project social-media-app
 * @Created 08/12/2024 - 4:14 AM

 */

import lk.bolton.SocialMediaApplication.dao.custom.SubscriptionDAO;
import lk.bolton.SocialMediaApplication.db.DBConnection;
import lk.bolton.SocialMediaApplication.entity.Subscription;

import java.sql.*;

public class SubscriptionDAOImpl implements SubscriptionDAO {

    private Connection connection;

    public SubscriptionDAOImpl() throws SQLException {
        this.connection = DBConnection.getConnection();
    }

    @Override
    public void subscribeUser(Subscription subscription) throws SQLException {
        String query = "INSERT INTO subscription (subscriberID, subscribedID) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, subscription.getSubscriberID());
            stmt.setString(2, subscription.getSubscribedID());
            stmt.executeUpdate();
        }
    }

    @Override
    public void unsubscribeUser(Subscription subscription) throws SQLException {
        String query = "DELETE FROM subscription WHERE subscriberID = ? AND subscribedID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, subscription.getSubscriberID());
            stmt.setString(2, subscription.getSubscribedID());
            stmt.executeUpdate();
        }
    }

    @Override
    public boolean isSubscribed(String subscriberID, String subscribedID) throws SQLException {
        String query = "SELECT * FROM subscription WHERE subscriberID = ? AND subscribedID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, subscriberID);
            stmt.setString(2, subscribedID);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        }
    }
}

