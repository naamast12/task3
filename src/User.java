public class User {

    private final String USERNAME;
    private final String PASSWORD;
    private final String PHONE_NUMBER;
    private final String INTERMEDIARY_OR_ORDINARY_USER;

    //O(1)
    public User(String userName, String password, String phoneNumber, String intermediaryOrOrdinaryUser)
    {
        this.USERNAME = userName;
        this.PASSWORD = password;
        this.PHONE_NUMBER = phoneNumber;
        this.INTERMEDIARY_OR_ORDINARY_USER = intermediaryOrOrdinaryUser;
    }

    //O(1)
    public String getUserName()
    {
        return USERNAME;
    }

    //O(1)
    public String getPassword()
    {
        return PASSWORD;
    }

    //O(1)
    public String getPhoneNumber()
    {
        return PHONE_NUMBER;
    }

    //O(1)
    public String getIntermediaryOrOrdinaryUser()
    {
        return INTERMEDIARY_OR_ORDINARY_USER;
    }

    //O(1)
    public String toString()
    {
        return this.USERNAME+"  "+ this.PHONE_NUMBER+" ("+this.INTERMEDIARY_OR_ORDINARY_USER+").";
    }
}
