package lk.bolton.SocialMediaApplication.dao;

import lk.bolton.SocialMediaApplication.dao.custom.impl.*;

import java.sql.SQLException;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory() { }
    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory(); }
        return daoFactory; }
    public SuperDAO getDAO(DAOTypes Types)  {
        switch (Types) {
            case USER:
                return new UserDAOImpl();

            case POST:
                return  new PostDAOImpl();
            default:
                return null; } }
    public enum DAOTypes {
        CUSTOMER, QUERYDAO, ITEM, ORDER, ORDERDETAILS, BATCH, USER, POST, SUPLAY,
    }
}