package CEMS.src.application;

import java.util.ArrayList;
import java.util.HashMap;

public class UserForm {

    private static int formID; //needs to be called from Database, or saved and retrieved at startup
    private boolean isFilled;

    private User user;

    public UserForm(RequestType requestType, HashMap<Object, Object> hmData){

        createUser(hmData);
    }

    public void createUser(HashMap<Object, Object> hmData){





    }

    public User getUser() {
        return user;
    }



}
