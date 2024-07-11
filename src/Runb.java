public class Runb {
    public static void main(String[] args) {
        AccountInfo accountInfo = new AccountInfo("Bella", "Savings");
        ATMService atmService = new ATMServicImpl();

        if(atmService.verify("2004")) {

            int count = 1;
            while (count != 0) {
                count = atmService.displayMenu();
                switch(count){
                    case 0:
                        System.out.println("Collect your card from the ATM");
                        System.exit(1);
                        break;

                    case 1:
                        atmService.CheckBalance(accountInfo);
                        break;

                    case 2:
                        atmService.Withdraw(accountInfo,"2004");
                        break;

                    case 4:
                        atmService.Transfer(accountInfo,"2004");
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }

            }

        }
        else{
            System.out.println("Incorrect pin entered too many times please remove your card");
        }

    }
}
