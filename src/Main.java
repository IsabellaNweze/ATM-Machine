import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        FileWriter writer = null;
        try {

            writer = new FileWriter("customerlog.txt");

            AccountInfo accountInfo = new AccountInfo("Bella", "Savings", "2004");
            ATMService atmService = new ATMServicImpl();

            if(atmService.verify(accountInfo)) {
                Instant start= Instant.now();
                int count = 1;
                while (count != 0) {
                    count = atmService.displayMenu(accountInfo);
                    switch(count) {
                        case 0:
                            System.out.println("Collect your card from the ATM");

                            Instant end =Instant.now();
                            Duration duration = Duration.between(start,end);
                            writer.write("User session ended.\t  "+atmService.CurrentTime()+"\n Total duration of session : "+ duration.toSeconds()+"seconds");

                            break;

                        case 1:
                            atmService.CheckBalance(accountInfo);
                            writer.write("Checked balance.\t"+ atmService.CurrentTime()+ "\n");
                            break;
                        case 2:
                            atmService.Withdraw(accountInfo);
                            writer.write("Performed withdrawal.\t" +atmService.CurrentTime() +"\n");
                            break;
                        case 3:
                            atmService.ChangePin(accountInfo);
                            writer.write("Changed PIN.\t"+ atmService.CurrentTime() +"\n");
                            break;
                        case 4:
                            atmService.Transfer(accountInfo);
                            writer.write("Performed transfer.\t"+ atmService.CurrentTime()+" \n");
                            break;
                        default:
                            System.out.println("Invalid input");
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
