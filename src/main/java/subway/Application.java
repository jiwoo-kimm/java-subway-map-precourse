package subway;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager(scanner);
        manager.start();
    }
}
