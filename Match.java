public class Match  extends View{
    private String name2;
    private String name2Info;

    public Match() {}
    public Match (String name1, String name1Info, String aidName, int quantity,String name2, String name2Info) {
        super(name1,name1Info,aidName,quantity);
        this.name2 = name2;
        this.name2Info = name2Info;

    }

    public String getName2() {
        return name2;
    }

    public String getName2Info() {
        return name2Info;
    }


    public String toString() {
        return name1 + "         " + name1Info + "           " + aidName + "             "+ quantity  + "             " + name2 + "             " + name2Info;
    }

    public String toCSVString() {
        return name1 + "," + name1Info + "," + aidName + ","+ quantity  + ","+  name2 + ","+ name2Info;
    }


}
