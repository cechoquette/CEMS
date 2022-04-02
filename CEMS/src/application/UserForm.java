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
    public void updateUser(User userEntered){
        if(hmData.get("UpdateUserFirstName") != userEntered.getFirstName())
            userEntered.setFirstName((String)hmData.get("UpdateUserFirstName"));
        if(hmData.get("UpdateUserLastName") != userEntered.getFirstName())
            userEntered.setFirstName((String)hmData.get("UpdateUserLastName"));
        if(hmData.get("UpdateUserEmail") != userEntered.getEmail())
            userEntered.setEmail((String)hmData.get("UpdateUserEmail"));
//        if(hmData.get("UpdateUserPassword") != userEntered.getPassword()) // This is handled in the passwordReset function of LoginForm
//            userEntered.setPassword((String)hmData.get("UpdateUserPassword"));
//        if(hmData.get("UpdateUserStudentID") != (String.valueOf(userEntered.getStudentID())))
//            userEntered.setStudentID(Integer.parseInt((String)hmData.get("CreateUserStudentID")));
        if(hmData.get("UpdateUserSecurityQ") != userEntered.getSecurityQuestion())
            userEntered.setSecurityQuestion((String)hmData.get("UpdateUserSecurityQ"));
        if(hmData.get("UpdateUserSecurityA") != userEntered.getSecurityAnswer())
            userEntered.setSecurityAnswer((String)hmData.get("UpdateUserSecurityA"));
    }

    public void updateUserPermission(User userEntered) {
        if(hmData.get("UpdateUserPermission") != (String.valueOf(userEntered.getPermission())));
        userEntered.setPermission(String.valueOf(hmData.get("UpdateUserPermission")));
    }

    public User getUser() {
        return user;
    }



}
