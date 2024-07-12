import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main (String[] args) {

        System.out.println("Welcome to ActivEdge Atm");
        Scanner scanner = new Scanner (System.in);
        int counter =0;
        while(counter < 3) {
            System.out.println("Enter your ATM pin  below \n xxxx");
            String pin = scanner.nextLine();
            boolean correct = verify(pin);
            if(correct){
                break;
            }
            else{
                System.out.println("Try again");
                counter++;
            }
            if(counter>=3){
                System.out.println("Invalid Customer stop trying.");
                System.exit(1);
            }
        }

        int MenuOption = displayMenu();
       // AccountInfo account1 = new AccountInfo("Isabella", " Savings");
        //account1.setBalance(20000.00);

    }

    public static boolean verify (String Pin){
        boolean verified;

        if (Pin.equals("2004")){
             verified = true;
        }
        else{
            verified = false;
        }

        return verified;
    }

    public static int displayMenu(){
        Scanner scanner = new Scanner (System.in);
        System.out.println("Hello Customer");
        System.out.print("1.Check Balance  \t  2.Withdraw \n3.Change Pin  \t    4.Transfer\n");
        System.out.println("Select the number on the menu you wish to perform");
        int option = scanner.nextInt();
        return option;

    }
}