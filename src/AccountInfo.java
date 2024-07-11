import java.sql.SQLOutput;

public class AccountInfo {
    private String name;
    private String AccountType;
    private Double balance;

    public AccountInfo(String name, String AccountType, double balance){
        this.name = name;
        this.AccountType= AccountType;
        this.balance = balance;

    }
    public AccountInfo(String name, String AccountType){
        this.name = name;
        this.AccountType= AccountType;
        this.balance = 20000.00;

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
}
