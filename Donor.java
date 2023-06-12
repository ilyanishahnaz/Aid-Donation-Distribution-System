/**
 * Donor represents the details needed to login to a donor account. 
 * The username, password, name and accountType and phoneNumber are String
 * Uses superclass Account
 */
public class Donor extends Account {
    private String phoneNumber;

/**
 * 
 * @param username the username of an account
 * @param password the password of an account
 * @param name the name of an account
 * @param accountType the account type (Donor) of an account
 * @param phoneNumber the phoneNumber of an account
 * 
 */

    public Donor() {}
    public Donor (String username, String password, String name, String accountType, String phoneNumber) {
        super(username, password, name, accountType);
        this.phoneNumber = phoneNumber;
    }
    

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String toCSVString(){
        return username + "," + password + ","+ name + "," + accountType + "," + phoneNumber;
    }

    public String toString(){
        return username + "     " + password + "      "+ name + "     " + accountType + "     " + phoneNumber;
    }

    public String getDonorLogin() {
        return username + "," + password + ","+ accountType;
    }

    @Override
    public boolean equals(Object comparedObject) {
        if (this == comparedObject) {
            return true;
        }
        if (!(comparedObject instanceof Donor)) {
            return false;
        }
        Donor comparedDonor = (Donor) comparedObject;

        // if the instance variables of the objects are the same, so are the objects
        if (this.username.equals(comparedDonor.username) &&
            this.password.equals(comparedDonor.password) &&
            //this.name.equals(comparedDonor.name) &&
            this.accountType.equals(comparedDonor.accountType)) {//&&
            //this.phoneNumber.equals(comparedDonor.phoneNumber)) {
            return true;
        }

        // otherwise, the objects aren't the same
        return false;
    }
}

