import java.io.BufferedReader;
import java.io.FileReader;

public class ATMProcess {

    private static int balance = 10000;

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: java ATMProcess <fifo>");
            System.exit(1);
        }

        String fifo = args[0];
        BufferedReader in = new BufferedReader(new FileReader(fifo));

        System.out.println("ATM STARTED");
        System.out.println("Initial balance: " + balance);
        System.out.println("--------------------------------");

        while (true) {
            String input = in.readLine();
            if (input == null) {
                continue;
            }

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("ATM STOPPED");
                break;
            }

            int amount;

            try{
                amount = Integer.parseInt(input);
            }
            catch(NumberFormatException e){
                System.out.println("Invalid input. Enter number only");
                System.out.println("--------------------------------");
                continue;
            }

            if (amount <= 0 || amount > balance) {
                System.out.println("Invalid withdrawal amount");
                System.out.println("Current balance: " + balance);
                System.out.println("--------------------------------");
                continue;
            }

            balance -= amount;

            System.out.println("Withdrawal successful");
            System.out.println("Remaining balance: " + balance);
            System.out.println("--------------------------------");
        }

        in.close();
    }
}

