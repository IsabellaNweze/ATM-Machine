public interface ATMService {
    void CheckBalance(AccountInfo accountInfo);
    double Withdraw(AccountInfo accountInfo, String pin);
    int displayMenu();

    //String ChangePin();
    boolean verify (String Pin);

    double Transfer(AccountInfo accountInfo, String pin);



}
