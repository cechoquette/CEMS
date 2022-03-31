package CEMS.src.application;

import java.util.HashMap;

public class UserForm {

    private static int formID; //needs to be called from Database, or saved and retrieved at startup
    private boolean isFilled;

    private User user;
    private HashMap<Object, Object> hmData;

    public UserForm(RequestType requestType, HashMap<Object, Object> hmData){


        this.hmData = hmData;
    }

    public User createUser(){
        //process data



        this.user = new User();//add parameters
        return user;
    }

    public void updateUser(User CURRENTUSER){

    }

    public void updateUserPermissions(){

    }

    public User getUser() {
        return user;
    }



}
