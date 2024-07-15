import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileWriter writer = null;
        try {
            writer = new FileWriter("customerlog.txt");

            AccountInfo accountInfo = new AccountInfo("Bella", "Savings", "2004");
            ATMService atmService = new ATMServicImpl();

            if(atmService.verify(accountInfo)) {
                int count = 1;
                while (count != 0) {
                    count = atmService.displayMenu(accountInfo);
                    switch(count) {
                        case 0:
                            System.out.println("Collect your card from the ATM");
                            writer.write("User session ended.\n");
                            break;
                        case 1:
                            atmService.CheckBalance(accountInfo);
                            writer.write("Checked balance.\n");
                            break;
                        case 2:
                            atmService.Withdraw(accountInfo);
                            writer.write("Performed withdrawal.\n");
                            break;
                        case 3:
                            atmService.ChangePin(accountInfo);
                            writer.write("Changed PIN.\n");
                            break;
                        case 4:
                            atmService.Transfer(accountInfo);
                            writer.write("Performed transfer.\n");
                            break;
                        default:
                            System.out.println("Invalid input");
                           // writer.write("Invalid input.\n");
                            break;
                    }
                }
            } else {
                System.out.println("Incorrect pin entered too many times please remove your card");
                writer.write("Failed verification.\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
