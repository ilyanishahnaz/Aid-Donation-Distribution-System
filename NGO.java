/**
 * NGO represents the details needed to login to a NGO account. 
 * The username, password, name and accountType and manpower are String
 * Uses superclass Account
 */
public class NGO extends Account {
    private String manpower;

    /**
 * 
 * @param username the username of an account
 * @param password the password of an account
 * @param name the name of an account
 * @param accountType the account type (Donor) of an account
 * @param manpower the phoneNumber of an account
 * 
 */
    public NGO() {}
    public NGO (String username, String password, String name, String accountType, String manpower) {
        super(username, password, name, accountType);
        this.manpower = manpower;
    }

    public String getManpower() {
        return manpower;
    }
    public String toCSVString() {
        return username + "," + password + ","+ name + "," + accountType + "," + manpower;
    }

    public String toString() {
        return username + "     " + password + "      "+ name + "     " + accountType + "     " + manpower;
    }

    public String getNGOLogin() {
        return username + "," + password + ","+ accountType;
    }

    @Override
    public boolean equals(Object comparedObject) {
        if (this == comparedObject) {
            return true;
        }
        if (!(comparedObject instanceof NGO)) {
            return false;
        }

        NGO comparedNGO = (NGO) comparedObject;

        // if the instance variables of the objects are the same, so are the objects
        if (this.username.equals(comparedNGO.username) &&
            this.password.equals(comparedNGO.password) &&
            //this.name.equals(comparedNGO.name) &&
            this.accountType.equals(comparedNGO.accountType)) {//&&
            //this.manpower.equals(comparedNGO.manpower)) {
            return true;
        }

        // otherwise, the objects aren't the same
        return false;
    }
}
