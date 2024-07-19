import java.util.ArrayList;
import java.util.List;

abstract class Account{
    String firstName;
    String lastName;
    String sorId;
    String accountNumber;
    double availableBalance;
    double currentBalance;

    public Account(String firstName, String lastName, String sorId, String accountNumber, double availableBalance, double currentBalance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sorId = sorId;
        this.accountNumber = accountNumber;
        this.availableBalance = availableBalance;
        this.currentBalance = currentBalance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sorId='" + sorId + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", availableBalance=" + availableBalance +
                ", currentBalance=" + currentBalance +
                '}';
    }
}

class CheckingAccount extends Account {
    String wireRoutingNumber;

    public CheckingAccount(String firstName, String lastName, String sorId, String accountNumber, String wireRoutingNumber, double availableBalance, double currentBalance) {
        super(firstName, lastName, sorId, accountNumber, availableBalance, currentBalance);
        this.wireRoutingNumber = wireRoutingNumber;
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "wireRoutingNumber='" + wireRoutingNumber + '\'' +
                ", " + super.toString() +
                '}';
    }
}

class SavingAccount extends Account {

    public SavingAccount(String firstName, String lastName, String sorId, String accountNumber, double availableBalance, double currentBalance) {
        super(firstName, lastName, sorId, accountNumber, availableBalance, currentBalance);
    }

    @Override
    public String toString() {
        return "SavingAccount{" + super.toString() + '}';
    }
}

class CreditCardAccount extends Account {
    String last4Digits;

    public CreditCardAccount(String firstName, String lastName, String last4Digits, String sorId, String accountNumber, double availableBalance, double currentBalance) {
        super(firstName, lastName, sorId, accountNumber, availableBalance, currentBalance);
        this.last4Digits = last4Digits;
    }

    @Override
    public String toString() {
        return "CreditCardAccount{" +
                "last4Digits='" + last4Digits + '\'' +
                ", " + super.toString() +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();

        accounts.add(new CheckingAccount("John", "Doe", "SOR123", "CHK001", "WR001", 1000.0, 1200.0));
        accounts.add(new SavingAccount("Jane", "Smith", "SOR124", "SAV001", 2000.0, 2200.0));
        accounts.add(new CreditCardAccount("Emily", "Jones", "1234", "SOR125", "CC001", 5000.0, 5500.0));

        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
