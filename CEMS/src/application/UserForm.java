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
        Integer userStudentID = (Integer)hmData.get("UserStudentID");
        String userFirstName = (String)hmData.get("UserFirstName");
        String userLastName = (String)hmData.get("UserLastName");
        String userEmail = (String)hmData.get("UserEmail");
        String userPhone = (String)hmData.get("UserPhone");
        String userPermission = (String)hmData.get("UserPermission");
        String userSecurityQ = (String)hmData.get("UserSecurityQ");
        String userSecurityA = (String)hmData.get("UserSecurityA");
        Club userClub = (Club)hmData.get("UserClub");

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

    public void updateUser(User CURRENTUSER){
        // Are we updating the user ever? We update permissions in below method have been copied here
        if(hmData.get("UserPermission") != CURRENTUSER.getPermission())
            user.setPermission((String)hmData.get("UserPermission"));
    }

    public void updateUserPermissions(User CURRENTUSER){
        if(hmData.get("UserPermission") != CURRENTUSER.getPermission())
            user.setPermission((String)hmData.get("UserPermission"));
    }

    public User getUser() {
        return user;
    }



}
