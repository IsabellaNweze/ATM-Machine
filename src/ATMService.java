public interface ATMService {
    void CheckBalance(AccountInfo accountInfo);
    double Withdraw(AccountInfo accountInfo);
    int displayMenu();

    //String ChangePin();
    boolean verify (AccountInfo accountInfo);

    double Transfer(AccountInfo accountInfo);

    void ChangePin(AccountInfo accountInfo);



}
