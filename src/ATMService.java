public interface ATMService {
    void CheckBalance(AccountInfo accountInfo);
    double Withdraw(AccountInfo accountInfo);
    int displayMenu(AccountInfo accountInfo);

    //String ChangePin();
    boolean verify (AccountInfo accountInfo);

    double Transfer(AccountInfo accountInfo);

    void ChangePin(AccountInfo accountInfo);

    String CurrentTime();


}
