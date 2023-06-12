/**
 * View represents the details needed to display aid donated, quantity for Donor and aids received for NGO account. 
 * The name1, name1info, aidName and quantity
 */
public class View {
    protected String name1;
    protected String name1Info;
    protected String aidName;
    protected int quantity;

/**
 * @param name1 the username of an account
 * @param name1info the manpower - NGO, telephone number - Donor
 * @param aidName the aid name to be donated or received
 * @param quantity quantity of the aid to be donated or received
 */
    public View() {}
    public View (String name1, String name1Info, String aidName, int quantity) {
        this.name1 = name1;
        this.name1Info = name1Info;
        this.aidName = aidName;
        this.quantity = quantity;
    }

    public String getName1() {
        return name1;
    }

    public String getName1Info() {
        return name1Info;
    }

    public String getAidName() {
        return aidName;
    }

    public int getQuantity() {
        return quantity;
    }


    public String toString() {
        return name1 + "         " + name1Info + "           " + aidName + "             "+ quantity ;
    }

    public String toCSVString() {
        return name1 + "," + name1Info + "," + aidName + ","+ quantity ;
    }
}
