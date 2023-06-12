/**
 * Account represents the details needed to register and login to an account. 
 * The username, password, name and accountType are String
 * Superclass
 */

public class Account {
    protected String username;
    protected String password;
    protected String name;
    protected String accountType;


/**
 * Constructs the account with the specified username, password, name and account type ; Donor/NGO
 * 
 * @param username the username of an account
 * @param password the password of an account
 * @param name the name of an account
 * @param accountType the account type (Donor/NGO) of an account
 * 
 */
    public Account() {}
    public Account (String username, String password, String name, String accountType) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.accountType = accountType;
    }

/**
 * @return username, password, name, accountType as String to display in console
 */
    public String toString() {
        return username + "     " + password + "      "+ name + "     " + accountType;
    }
/**
 * 
 * @return username, password, name, accountType to be formatted into the csv file
 */
    public String toCSVString() {
        return username + "," + password + ","+ name + "," + accountType ;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword(){
        return password;
    }
    
    public String getName() {
        return name;
    }

    public String getAccountType() {
        return accountType;
    }

    @Override
    public boolean equals(Object comparedObject) {
        if (this == comparedObject) {
            return true;
        }
        if (!(comparedObject instanceof Account)) {
            return false;
        }
        Account comparedAccount = (Account) comparedObject;
        // if the instance variables of the objects are the same, so are the objects
        if (this.username.equals(comparedAccount.username) &&
            this.password.equals(comparedAccount.password) &&
            this.name.equals(comparedAccount.name) &&
            this.accountType.equals(comparedAccount.accountType)) {
            return true;
        }

        // otherwise, the objects aren't the same
        return false;
    }
}