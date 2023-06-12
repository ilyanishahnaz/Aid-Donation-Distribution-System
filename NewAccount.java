public class NewAccount extends Account {
    private String accountInfo;

    public NewAccount() {}
    public NewAccount (String username, String password, String name, String accountType,String accountInfo) {
        super(username, password, name, accountType);
        this.accountInfo = accountInfo;
    }

    public String getAcountInfo() {
        return accountInfo;
    }

    public String toCSVString(){
        return username + "," + password + ","+ name + "," + accountType + "," + accountInfo;
    }

    public String toString(){
        return username + "     " + password + "      "+ name + "     " + accountType + "     " + accountInfo;
    }
    
}
