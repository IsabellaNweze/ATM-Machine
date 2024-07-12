import java.sql.SQLOutput;

public class AccountInfo {
    private String name;
    private String AccountType;
    private Double balance;

    private String pin;

    public AccountInfo(String name, String AccountType, double balance, String pin){
        this.name = name;
        this.AccountType= AccountType;
        this.balance = balance;
        this.pin = pin;
    }
    public AccountInfo(String name, String AccountType,String pin){
        this.name = name;
        this.AccountType= AccountType;
        this.balance = 20000.00;
        this.pin = pin;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return AccountType;
    }

    public void setAccountType(String accountType) {
        AccountType = accountType;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
