public class Main {
    public static void main(String[] args) {
        AccountInfo accountInfo = new AccountInfo("Bella", "Savings", "2004");
        ATMService atmService = new ATMServicImpl();

        if(atmService.verify(accountInfo) ){

            int count = 1;
            while (count != 0) {
                count = atmService.displayMenu(accountInfo);
                switch(count){
                    case 0:
                        System.out.println("Collect your card from the ATM");

                        break;

                    case 1:
                        atmService.CheckBalance(accountInfo);
                        break;

                    case 2:
                        atmService.Withdraw(accountInfo);
                        break;

                    case 3:
                        atmService.ChangePin(accountInfo);
                        break;

                    case 4:
                        atmService.Transfer(accountInfo);
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
