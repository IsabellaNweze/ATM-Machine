import java.util.Scanner;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
public class ATMServicImpl implements ATMService {
    Scanner scanner = new Scanner (System.in);
    @Override
    public void CheckBalance(AccountInfo accountInfo) {
        System.out.println(accountInfo.getName() + " Your" + accountInfo.getAccountType() +  " account balance is :"+ accountInfo.getBalance());
    }

    @Override
    public double Withdraw(AccountInfo accountInfo) {

        System.out.println("Enter the amount you want to withdraw?");
        double amount = scanner.nextDouble();
        if(accountInfo.getBalance()<amount){
            System.out.println("Insufficient funds");
        }
        else {
            System.out.println("Please collect your cash ");
            double old_bal = accountInfo.getBalance();
            double new_bal = old_bal - amount;
            accountInfo.setBalance(new_bal);

        }
        return amount;
    }


    @Override
    public int displayMenu(AccountInfo accountInfo) {
        System.out.println("\n Hello "+ accountInfo.getName());

        System.out.print("1.Check Balance  \t  2.Withdraw \n3.Change Pin  \t    4.Transfer\n");
        System.out.println("Select 0 to exit");
        System.out.println("Select the number on the menu you wish to perform");
        return scanner.nextInt();
    }
    @Override
    public boolean verify(AccountInfo accountInfo){
        int count=0;

        while(count<3){
            System.out.println("Enter your ATM pin  below \n xxxx");
            String pinReq = scanner.nextLine();
            if (accountInfo.getPin().equals(pinReq))
                return true;
            count++;
            System.out.println("Incorrect pin Try Again");

        }
        return false;
    }

    @Override
    public double Transfer(AccountInfo accountInfo) {
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Enter the Bank you wish to transfer to");
        String Bank = scanner2.nextLine();
        String acct_no= "";
        if(Bank.length()>1) {
            System.out.println("Enter The Account Number ");
             acct_no = scanner2.nextLine();
        }
        System.out.println("How much do you want to transfer");
        Double amount = scanner2.nextDouble();
        if (amount> accountInfo.getBalance()){
            System.out.println("Unable to transfer due to insufficient balance");
        }
        else{
            System.out.println("Transfer of "+ amount+ " to "+ acct_no + "\n  "+ Bank+ "was succesful"  );
            double new_balance = accountInfo.getBalance()- amount;
            accountInfo.setBalance(new_balance);
        }
        return amount;
    }

    @Override
    public void ChangePin(AccountInfo accountInfo) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter previous pin");
        String old_pin = scanner1.nextLine();
        System.out.println(old_pin);
        if (old_pin.equals(accountInfo.getPin())){
            System.out.println("Enter the new pin ");
            String new_pin= scanner1.nextLine();
            accountInfo.setPin(new_pin);
        }
        else{
            System.out.println("The pin you entered was incorrect");
        }

    }

    @Override
    public String CurrentTime() {
        LocalTime now = LocalTime.now();
        LocalTime currentTime = now.truncatedTo(ChronoUnit.SECONDS);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String format= currentTime.format(formatter);
        return format;
    }
}
