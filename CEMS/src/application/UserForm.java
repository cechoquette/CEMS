package CEMS.src.application;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.HashMap;

public class UserForm {

    private static int formID; //needs to be called from Database, or saved and retrieved at startup
    private boolean isFilled;

    private User user;
    private HashMap<Object, Object> hmData;

    public UserForm(RequestType requestType, HashMap<Object, Object> hmData){


        this.hmData = hmData;
    }

    public User createUser() {
        //process data
        Integer userStudentID = Integer.parseInt((String)hmData.get("CreateUserStudentID"));
        String userFirstName = (String)hmData.get("CreateUserFirstName");
        String userLastName = (String)hmData.get("CreateUserLastName");
        String userEmail = (String)hmData.get("CreateUserEmail");
        String userPhone = (String)hmData.get("CreateUserPhone");
        String userPermission = (String)hmData.get("CreateUserPermission").toString();
        String userSecurityQ = (String)hmData.get("CreateUserSecurityQ");
        String userSecurityA = (String)hmData.get("CreateUserSecurityA");
        Club userClub = (Club)hmData.get("CreateUserClub");

        try {
            this.user = new User(userFirstName, userLastName, userPhone, userEmail,
                                userStudentID, userClub, userPermission, userSecurityQ,
                                userSecurityA);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
        return user;
    }

    // To update a users profile information
    public void updateUser(User CURRENTUSER){
        if(hmData.get("UpdateUserFirstName") != CURRENTUSER.getFirstName())
            user.setFirstName((String)hmData.get("UpdateUserFirstName"));
        if(hmData.get("UpdateUserLastName") != CURRENTUSER.getFirstName())
            user.setFirstName((String)hmData.get("UpdateUserLastName"));
        if(hmData.get("UpdateUserEmail") != CURRENTUSER.getEmail())
            user.setEmail((String)hmData.get("UpdateUserEmail"));
        if(!hmData.get("UpdateUserStudentID").equals(CURRENTUSER.getStudentID()))
            user.setStudentID(Integer.parseInt((String)hmData.get("CreateUserStudentID")));
        if(hmData.get("UpdateUserSecurityQ") != CURRENTUSER.getSecurityQuestion())
            user.setSecurityQuestion((String)hmData.get("UpdateUserSecurityQ"));
        if(hmData.get("UpdateUserSecurityA") != CURRENTUSER.getSecurityAnswer())
            user.setSecurityAnswer((String)hmData.get("UpdateUserSecurityA"));
    }

    // To update a users permission only
    public void updateUserPermission(User CURRENTUSER){
        if(hmData.get("UpdateUserPermission") != CURRENTUSER.getPermission())
            user.setPermission((String)hmData.get("UpdateUserPermission"));
    }

    public User getUser() {
        return user;
    }



}
