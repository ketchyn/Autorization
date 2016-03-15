package accounts;

import dbService.DBException;
import dbService.DBService;


public class AccountService {
    // private final Map<String, UserProfile> loginToProfile;
    // private final Map<String, UserProfile> sessionIdToProfile;
    private final DBService dbservice;


    public AccountService( DBService dbService) {

        this.dbservice = dbService;

    }

    public void addNewUser(UserProfile userProfile)  {

        try {
            dbservice.addUser(userProfile);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    public UserProfile  getUserByLogin(String login)  {
        try {
            return dbservice.getUser(login);
        } catch (DBException e) {
            e.printStackTrace();
        }
        return null;
    }


}
