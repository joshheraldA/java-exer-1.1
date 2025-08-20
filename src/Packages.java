import java.util.Scanner;
import java.util.Random;

abstract class Packages {
    String result;

    abstract void init(String message);
    abstract int num_init(String message);

    public void set_result(String result) { this.result = result; }
    public String get_result() { return this.result; }
}

class Scanner_Package extends Packages {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void init(String message) {
        if(message.isEmpty()) {
            System.err.println("[ERROR] The message string is empty");
            return;
        }

        System.out.print("[MESSAGE] " + message);
        result = scanner.nextLine();
        set_result(result);
    }

    public int num_init(String message) {
        System.out.print("[MESSAGE] " + message);
        return scanner.nextInt();
    }
}

class Random_Package extends Packages {
    private final Random random = new Random();
    private final StringBuilder result = new StringBuilder();

    @Override
    public void init(String message) {
        int num = 0;
        try {
            num = Integer.parseInt(message);

        } catch (NumberFormatException e) {
            System.err.println("Not a number");
        }

        for (int i = 0; i <= num - 1; i++) {
            int rand_num = random.nextInt(9);
            result.append(rand_num);
        }
        set_result(result.toString());
        System.out.println("HELLO WORLD");
    }

    @Override
    public int num_init(String message) {
        return 0;
    }
}