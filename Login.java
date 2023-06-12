import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {

    public static void main(String[] args) throws IOException {

        Scanner input1 = new Scanner(System.in);
        int choice;
        do {

            ArrayList<NewAccount> accounts = readAllAccount();
            ArrayList<Donor> donorAccounts = readDonorAccount();
            ArrayList<NGO> NGOAccounts = readNGOAccount();
            // ArrayList<View> aidsViews = readAllAids();
            ArrayList<View> donorViews = readDonorAids();
            ArrayList<View> NGOViews = readNGOAids();
            ArrayList<Match> allMatch = readMatchFile();

            System.out.println();
            System.out.println("--------------------------------------");
            System.out.println("Welcome to Aid Distribution System");
            System.out.println("Enter your choice:");
            System.out.println("1: Register new account");
            System.out.println("2: Login account");
            System.out.println("3: Distribution center");
            System.out.println("0: Quit");
            System.out.print("> ");

            choice = input1.nextInt();

            switch (choice) {
                case 1:
                    int loginPage = 1;
                    while (loginPage != 0) {
                        System.out.println();
                        System.out.println("Register new account");
                        System.out.print("Choose the account type(Donor/NGO): ");
                        Scanner input2 = new Scanner(System.in);
                        String newType = input2.nextLine();

                        if (!newType.equals("Donor") && !newType.equals("NGO")) {
                            System.out.println("Please enter the correct type(Donor/NGO)");
                            System.out.println();
                        } else {
                            if (newType.equals("Donor")) {
                                Scanner input3 = new Scanner(System.in);
                                System.out.print("Enter new username: ");
                                String username = input3.nextLine();
                                System.out.print("Enter new password: ");
                                String password = input3.nextLine();
                                System.out.print("Enter new donor name: ");
                                String name = input3.nextLine();
                                System.out.print("Enter new donor telephone number (eg: 011-12345): ");
                                String telephone = input3.nextLine();

                                int count = 0;
                                for (int i = 0; i < accounts.size(); i++) {
                                    if (username.equals(accounts.get(i).getUsername())) {
                                        count = 1;
                                    }
                                }
                                if (count == 1) {
                                    System.out.println("Username already exist. Please change username");
                                } else {
                                    accounts.add(new NewAccount(username, password, name, newType, telephone));
                                    System.out.println("Account successfully registered!");
                                    saveNewAccountToFile(accounts);
                                    loginPage = 0;

                                }
                            } else if (newType.equals("NGO")) {
                                Scanner input4 = new Scanner(System.in);
                                System.out.print("Enter new username: ");
                                String username = input4.nextLine();
                                System.out.print("Enter new password: ");
                                String password = input4.nextLine();
                                System.out.print("Enter new NGO name: ");
                                String name = input4.nextLine();
                                System.out.print("Enter number of manpower: ");
                                String manpower = input4.nextLine();

                                int count = 0;
                                for (int i = 0; i < accounts.size(); i++) {
                                    if (username.equals(accounts.get(i).getUsername())) {
                                        count = 1;
                                    }
                                }
                                if (count == 1) {
                                    System.out.println("Username already exist. Please change username");
                                } else {
                                    accounts.add(new NewAccount(username, password, name, newType, manpower));
                                    saveNewAccountToFile(accounts);
                                    System.out.println("Account successfully registered!");
                                    loginPage = 0;
                                }

                            }

                        }

                    }
                    break;
                case 2:
                    int nextPage1 = 1;
                    while (nextPage1 != 0) {
                        System.out.println();
                        Scanner input5 = new Scanner(System.in);
                        System.out.println("Enter username:");
                        String userName = input5.nextLine();
                        System.out.println("Enter password:");
                        String passWord = input5.nextLine();
                        System.out.println("Enter account type(Donor/NGO): ");
                        String accountType = input5.nextLine();
                        System.out.println();

                        String loginID = (userName + "," + passWord + "," + accountType);

                        for (int i = 0; i < donorAccounts.size(); i++) {
                            if (loginID.equals(donorAccounts.get(i).getDonorLogin())) {
                                System.out.println("Login Successful Donor");

                                int nextPage2 = 1;
                                Scanner input6 = new Scanner(System.in);
                                int choice1;
                                while (nextPage2 != 0) {
                                    System.out.println();
                                    System.out.println("Donor page");
                                    System.out.println("Donor name:" + donorAccounts.get(i).getName());
                                    System.out.println("Phone number:" + donorAccounts.get(i).getPhoneNumber());
                                    System.out.println();
                                    System.out.println("1: Enter aids to donate");
                                    System.out.println("2: View the list of aids");
                                    System.out.println("0: Quit");
                                    System.out.print("> ");

                                    choice1 = input6.nextInt();

                                    switch (choice1) {
                                        case 0:
                                            nextPage2 = 0;
                                            break;
                                        case 1:
                                            System.out.println();
                                            System.out.println(
                                                    "Guidance: C = Clothes, M = Medicine, S = Shoes, T = Tissue");
                                            System.out.println("Enter aids code to donate (C, M, S, T");
                                            String aidName = input6.next();
                                            System.out.println("Quantity: ");
                                            String quantity = input6.next();
                                            System.out.println();
                                            int aidQuantity = Integer.parseInt(quantity);

                                            if (!aidName.equals("C") && !aidName.equals("M") && !aidName.equals("S")
                                                    && !aidName.equals("T")) {
                                                System.out.println("Please enter the correct code(C, M, S, T)");
                                                System.out.println();
                                            } else {
                                                donorViews.add(new View(donorAccounts.get(i).getName(),
                                                        donorAccounts.get(i).getPhoneNumber(), aidName, aidQuantity));
                                                saveDonorAidToFile(donorViews);
                                            }
                                            System.out.println("Press 1 to continue");
                                            input6.nextInt();
                                            break;

                                        case 2:
                                            System.out.println();
                                            System.out.println(
                                                    "Guidance: C = Clothes, M = Medicine, S = Shoes, T = Tissue");
                                            System.out.println();
                                            System.out.println(
                                                    "Donor      Phone Number     Aids Name     Quantity     Receiver    Manpower");
                                            for (int j = 0; j < donorViews.size(); j++)
                                                System.out.println(donorViews.get(j));
                                            System.out.println("Donation is successful");
                                            System.out.println();
                                            System.out.println("Press 1 to continue");
                                            input6.nextInt();
                                            break;
                                        default:
                                            System.out.println("Please enter the right choice");
                                            break;
                                    }
                                }
                                input5.nextLine();
                            }
                        }

                        for (int i = 0; i < NGOAccounts.size(); i++) {
                            if (loginID.equals(NGOAccounts.get(i).getNGOLogin())) {
                                System.out.println("Login Successful NGO");

                                int nextPage2 = 1;
                                Scanner input6 = new Scanner(System.in);
                                int choice1;
                                while (nextPage2 != 0) {
                                    System.out.println();
                                    System.out.println("NGO page");
                                    System.out.println("NGO name:" + NGOAccounts.get(i).getName());
                                    System.out.println("Manpower:" + NGOAccounts.get(i).getManpower());
                                    System.out.println();
                                    System.out.println("1: Enter aids to receive");
                                    System.out.println("2: View the list of aids");
                                    System.out.println("0: Quit");
                                    System.out.print("> ");

                                    choice1 = input6.nextInt();

                                    switch (choice1) {
                                        case 0:
                                            nextPage2 = 0;
                                            break;
                                        case 1:
                                            System.out.println();
                                            System.out.println(
                                                    "Guidance: C = Clothes, M = Medicine, S = Shoes, T = Tissue");
                                            System.out.println("Enter aids code to donate (C, M, S, T");
                                            String aidName = input6.next();
                                            System.out.println("Quantity: ");
                                            String quantity = input6.next();
                                            System.out.println();
                                            int aidQuantity = Integer.parseInt(quantity);

                                            if (!aidName.equals("C") && !aidName.equals("M") && !aidName.equals("S")
                                                    && !aidName.equals("T")) {
                                                System.out.println("Please enter the correct code(C, M, S, T)");
                                                System.out.println();
                                            } else {
                                                NGOViews.add(new View(NGOAccounts.get(i).getName(),
                                                        NGOAccounts.get(i).getManpower(), aidName, aidQuantity));
                                                saveNGOAidToFile(NGOViews);
                                                System.out.println("Donation to be received is registered");
                                            }
                                            System.out.println("Press 1 to continue");
                                            input6.nextInt();

                                            break;

                                        case 2:
                                            System.out.println();
                                            System.out.println(
                                                    "Guidance: C = Clothes, M = Medicine, S = Shoes, T = Tissue");
                                            System.out.println();
                                            System.out.println(
                                                    "NGO      Manpower     Aids Name     Quantity       Donor         Phone Number");
                                            for (int j = 0; j < NGOViews.size(); j++)
                                                System.out.println(NGOViews.get(j));
                                            System.out.println();
                                            System.out.println("Press 1 to continue");
                                            input6.nextInt();
                                            break;
                                        default:
                                            System.out.println("Please enter the right choice");
                                            break;
                                    }
                                }
                                input5.nextLine();
                            }
                        }
                        if (!accountType.equals("Donor") && !accountType.equals("NGO")) {
                            System.out.println("Please try again and enter the correct type(Donor/NGO)");
                        } else {
                            System.out.println("Invalid username or password");
                            System.out.println();
                            System.out.println("Please try again or register new account");
                            System.out.println("Retry (Press 1)  /  Exit login page (Press 0)");
                            int retry = input5.nextInt();
                            if (retry == 0)
                                nextPage1 = 0;
                        }
                    }
                    break;
                case 3:
                    int nextPage3 = 1;
                    while (nextPage3 != 0) {
                        Scanner input7 = new Scanner(System.in);
                        int choice2;
                        System.out.println();
                        System.out.println("Distribution center");
                        System.out.println("Enter your choice:");
                        System.out.println("1: View all aids matched");
                        System.out.println("0: Quit");
                        System.out.print("> ");

                        choice2 = input1.nextInt();

                        switch (choice2) {
                            case 0:
                                nextPage3 = 0;
                                break;
                            case 1:
                                System.out.println();
                                System.out.println("Match aids 1 to 1");
                                System.out.println(
                                        "Guidance: C = Clothes, M = Medicine, S = Shoes, T = Tissue");
                                System.out.println();
                                System.out.println(
                                        "Donor      Phone Number     Aids Name     Quantity     Receiver    Manpower");
                                allMatch = readMatchFile();

                                for (int i = 0; i < allMatch.size(); i++) {
                                    System.out.println(allMatch.get(i));
                                }

                                System.out.println("Press 1 to continue");
                                input7.nextInt();
                                System.out.println();
                                break;
                            default:
                                System.out.println("Please enter the right choice");
                                break;

                        }

                    }
                    break;
                default:
                    System.out.println("Please enter the right choice");
                    break;
            }
            input1.nextLine();
        } while (choice != 0);
        System.out.println("---- Program end ----");
    }

    private static ArrayList<Donor> readDonorAccount() throws IOException {
        ArrayList<Donor> donorAccounts = new ArrayList<>();

        List<String> lines = Files.readAllLines(Paths.get("account.csv"));
        for (int i = 0; i < lines.size(); i++) {
            // split a line by comma
            String[] items = lines.get(i).split(",");
            if (items[3].equals("Donor"))
                donorAccounts.add(new Donor(items[0], items[1], items[2], items[3], items[4]));
        }
        return donorAccounts;
    }

    private static ArrayList<NGO> readNGOAccount() throws IOException {
        ArrayList<NGO> NGOAccounts = new ArrayList<>();

        List<String> lines = Files.readAllLines(Paths.get("account.csv"));
        for (int i = 0; i < lines.size(); i++) {
            // split a line by comma
            String[] items = lines.get(i).split(",");
            if (items[3].equals("NGO"))
                NGOAccounts.add(new NGO(items[0], items[1], items[2], items[3], items[4]));
        }
        return NGOAccounts;
    }

    private static ArrayList<NewAccount> readAllAccount() throws IOException {
        ArrayList<NewAccount> accounts = new ArrayList<>();

        List<String> lines = Files.readAllLines(Paths.get("account.csv"));
        for (int i = 0; i < lines.size(); i++) {
            // split a line by comma
            String[] items = lines.get(i).split(",");
            accounts.add(new NewAccount(items[0], items[1], items[2], items[3], items[4]));

        }
        return accounts;
    }

    private static ArrayList<View> readDonorAids() throws IOException {
        ArrayList<View> donorViews = new ArrayList<>();

        List<String> lines = Files.readAllLines(Paths.get("donorAids.csv"));
        for (int i = 0; i < lines.size(); i++) {
            // split a line by comma
            String[] items = lines.get(i).split(",");
            int quantity = Integer.parseInt(items[3]); // convert String to int

            donorViews.add(new View(items[0], items[1], items[2], quantity));
        }
        return donorViews;
    }

    private static ArrayList<View> readNGOAids() throws IOException {
        ArrayList<View> NGOViews = new ArrayList<>();

        List<String> lines = Files.readAllLines(Paths.get("NGOAids.csv"));
        for (int i = 0; i < lines.size(); i++) {
            // split a line by comma
            String[] items = lines.get(i).split(",");
            int quantity = Integer.parseInt(items[3]); // convert String to int

            NGOViews.add(new View(items[0], items[1], items[2], quantity));
        }
        return NGOViews;
    }

    private static ArrayList<Match> readMatchFile() throws IOException {
        ArrayList<Match> allMatch = new ArrayList<>();

        List<String> lines = Files.readAllLines(Paths.get("match.csv"));
        for (int i = 0; i < lines.size(); i++) {
            // split a line by comma
            String[] items = lines.get(i).split(",");
            int quantity = Integer.parseInt(items[3]); // convert String to int
            allMatch.add(new Match(items[0], items[1], items[2], quantity, items[4], items[5]));
        }
        return allMatch;
    }

    private static void saveNewAccountToFile(ArrayList<NewAccount> accounts) throws IOException {
        // read donor.csv into a list of lines.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < accounts.size(); i++)
            sb.append(accounts.get(i).toCSVString() + "\n");
        Files.write(Paths.get("account.csv"), sb.toString().getBytes());
    }

    private static void saveDonorAidToFile(ArrayList<View> accounts) throws IOException {
        // read donor.csv into a list of lines.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < accounts.size(); i++)
            sb.append(accounts.get(i).toCSVString() + "\n");
        Files.write(Paths.get("donorAids.csv"), sb.toString().getBytes());
    }

    private static void saveNGOAidToFile(ArrayList<View> accounts) throws IOException {
        // read NGO.csv into a list of lines.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < accounts.size(); i++)
            sb.append(accounts.get(i).toCSVString() + "\n");
        Files.write(Paths.get("NGOAids.csv"), sb.toString().getBytes());
    }

}
