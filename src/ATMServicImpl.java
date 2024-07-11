import java.util.Scanner;

public class ATMServicImpl implements ATMService {
    Scanner scanner = new Scanner (System.in);
    @Override
    public void CheckBalance(AccountInfo accountInfo) {
        System.out.println(accountInfo.getName() + " Your account balance is :"+ accountInfo.getBalance());
    }

    @Override
    public double Withdraw(AccountInfo accountInfo, String pin) {

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
    public int displayMenu() {
        System.out.println("Hello Customer");
        System.out.print("1.Check Balance  \t  2.Withdraw \n3.Change Pin  \t    4.Transfer\n");
        System.out.println("Select 0 to exit");
        System.out.println("Select the number on the menu you wish to perform");
        return scanner.nextInt();
    }
    @Override
    public boolean verify(String pin){
        int count=0;
        while(count<3){
            System.out.println("Enter your ATM pin  below \n xxxx");
            String pinReq = scanner.nextLine();
            if (pin.equals(pinReq))
                return true;
            count++;
        }
        return false;
    }

    @Override
    public double Transfer(AccountInfo accountInfo, String pin) {
        System.out.println("Enter the Bank you wish to transfer to");
        String Bank = scanner.nextLine();
        System.out.println("Enter The Account Number ");
        String acct_no = scanner.nextLine();
        System.out.println("How much do you want to transfer");

        Double amount = scanner.nextDouble();
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
}