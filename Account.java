
public class Account {
    private String id;
    private String name;
    private double balance;
    private int type;
    private double interest;
    private int installments = 0;
    private double srate = 0.025;
    private double drate = 0.07;
    private String typString;

    public Account(String id, String name, int type, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.type = type;
        if (this.type == 1) {
            typString = "Regular";
        } else if (this.type == 2) {
            typString = "Savings";
        } else if (this.type == 3) {
            typString = "Deposit";
        }
        this.installments++;
    }

    public Account(String id, String name, int type) {
        this.id = id;
        this.name = name;
        this.type = type;
        if (this.type == 1) {
            typString = "Regular";
        } else if (this.type == 2) {
            typString = "Savings";
        } else if (this.type == 3) {
            typString = "Deposit";
        }
        this.balance = 0.0;
    }

    public String getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getInterest() {

        if (this.type == 1) {

            this.interest = 0;
        } else if (this.type == 2) {
            this.interest = (this.balance) * srate;
        } else if (this.type == 3) {
            this.interest = (this.balance) * drate;
        }
        return this.interest;
    }

    public void withdrawInterest() {
        this.interest = 0;
        System.out.println("Interest money withdrawn !\n");
    }

    public double getBal() {
        return this.balance;
    }

    public void withdraw(double amount) {
        if (amount <= this.balance) {
            switch (this.type) {
                case 1:
                    this.balance -= amount;
                    System.out.println("\nWithdrawl finished !\n");
                    break;
                case 2:
                    if (this.balance < 1000) {
                        System.out.println("Can not withdraw less than 1000 !");
                    } else {
                        this.balance -= amount;
                        System.out.println("\nWithdrawl finished !\n");
                    }
                    break;
                case 3:
                    if (installments < 5) {
                        System.out.println("Can not withdraw less than 5 installments !");
                    } else {
                        this.balance -= amount;
                        System.out.println("\nWithdrawl finished !\n");
                        installments = 0;
                    }
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("NOT enough balance !");

        }

    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount");
            return;
        }
        if (this.type == 3)
            installments++;
        this.balance += amount;
        System.out.println("\nDeposit finished !\n");
    }

    public void transfer(Account accdes, double amount) {
        if (amount <= this.balance && this.type != 3) {
            this.balance -= amount;
            accdes.balance += amount;
            System.out.println("\nTransfer finished !\n");
        } else {
            if (amount > this.balance) {
                System.out.println("Not enough balance");
            }
            if (this.type == 3) {
                System.out.println("Cannot transfer in deposit account");
            }
        }

    }

    public String toString() {

        return "name: " + this.name + "\nid: " + this.id + "\nbalance: " + this.balance + "\ntype :" + this.typString;

    }
}
