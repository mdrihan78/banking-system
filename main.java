
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Account[] accounts = new Account[200];
        Scanner scan = new Scanner(System.in);
        int count = 0;
        int choice = -1;

        do {
            String name;
            String id;
            double balance;
            double amount;
            Account acc;
            System.out.println("1) Create Account");
            System.out.println("2) Deposit");
            System.out.println("3) Withdraw");
            System.out.println("4) Transfer Money");
            System.out.println("5) Show all");
            System.out.println("6) Interests");
            System.out.println("7) EXIT");
            System.out.print("Enter Choice :");
            choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter your name:");
                    name = scan.nextLine();
                    System.out.print("Enter your id:");
                    id = scan.nextLine();
                    System.out.println("Enter Account type --");
                    System.out.println("1) Regular");
                    System.out.println("2) Savings");
                    System.out.println("3) Deposit");
                    int type;
                    do {
                        System.out.print("Enter type :");
                        type = scan.nextInt();
                    } while (type != 1 && type != 2 && type != 3);
                    System.out.print("Enter inintial balance  ( if balance is 0 type -1):");
                    balance = scan.nextDouble();
                    if (balance < 0) {

                        accounts[count++] = new Account(id, name, type);
                    }

                    else {
                        accounts[count++] = new Account(id, name, type, balance);
                    }
                    break;
                case 2:
                    System.out.print("Enter ID:");
                    id = scan.nextLine();
                    System.out.print("Enter deposit amount:");
                    amount = scan.nextDouble();
                    acc = find(accounts, count, id);
                    if (acc != null) {
                        acc.deposit(amount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                case 3:
                    System.out.print("Enter ID:");
                    id = scan.nextLine();
                    System.out.print("Enter withdrawl amount:");
                    amount = scan.nextDouble();
                    acc = find(accounts, count, id);
                    if (acc != null) {
                        acc.withdraw(amount);
                    } else {
                        System.out.println("Account Not found!");
                    }
                    break;
                case 4:
                    System.out.print("Enter source account ID:");
                    String idsrc;
                    idsrc = scan.nextLine();
                    System.out.print("Enter destination account ID:");
                    String iddes;
                    iddes = scan.nextLine();
                    System.out.print("Enter transfer amount:");
                    amount = scan.nextDouble();
                    Account acc1 = find(accounts, count, idsrc);
                    Account acc2 = find(accounts, count, iddes);
                    if (acc1 != null && acc2 != null) {
                        acc1.transfer(acc2, amount);
                    } else {
                        System.out.print("No account found!");
                    }
                    break;
                case 5:
                    for (int i = 0; i < count; i++) {
                        System.out.print("\n");
                        System.out.println(accounts[i]);
                        System.out.print("\n");
                    }
                    break;
                case 6:
                    System.out.print("Enter ID:");
                    id = scan.nextLine();
                    acc = find(accounts, count, id);
                    if (acc != null) {
                        balance = acc.getBal();
                        System.out.println("Your current balance :" + balance);
                        double interest = acc.getInterest();
                        System.out.println("Your Interest balance :" + interest);
                        System.out.print("Do you want to withdraw interest (type 1 if YES) :");
                        int wint = 0;
                        wint = scan.nextInt();
                        if (wint == 1) {
                            acc.withdrawInterest();
                        }
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 7:
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            for (int i = 0; i < 50; i++) {
                System.out.print("=");
            }
            System.out.print("\n");
        } while (choice < 8 && choice > 0);
    }

    private static Account find(Account[] accounts, int count, String id) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getID().equals(id)) {
                return accounts[i];

            }
        }
        return null;
    }

}

