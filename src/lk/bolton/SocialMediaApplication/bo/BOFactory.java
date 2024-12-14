package lk.bolton.SocialMediaApplication.bo;

import lk.bolton.SocialMediaApplication.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }
    public static BOFactory getInstance() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }
    public enum BOTypes {
         USER ,POST ;
    }
    public SuperBO getBO(BOTypes types) {
        switch (types) {

            case USER:
                return new UserBOImpl() ;
            case  POST:
                return new PostBOImpl() ;
                }
        return null;
    }

    }