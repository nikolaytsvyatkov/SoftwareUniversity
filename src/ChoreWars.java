import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChoreWars {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(?<dishes><[a-z0-9]+>)|(?<cleaning>\\[[A-Z0-9]+\\])|(?<laundry>\\{.+\\})");
        int dishesTime = 0;
        int cleaningTime = 0;
        int laundryTime = 0;


        while (true) {
            String command = input.nextLine();
            if (command.equals("wife is happy")) {
                break;
            }
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                String found = matcher.group();
                if (found.contains("<") && found.contains(">")) {
                    for (int i = 0; i < matcher.group().length(); i++) {
                            if (Character.isDigit(found.charAt(i))) {
                                dishesTime += matcher.group().charAt(i) - 48;
                            }
                    }
                } else if (found.contains("[") && found.contains("]")) {
                    for (int i = 0; i < matcher.group().length(); i++) {
                        if (Character.isDigit(found.charAt(i))) {
                            cleaningTime += matcher.group().charAt(i) - 48;
                        }
                    }
                } else if (found.contains("{") && found.contains("}")) {
                    for (int i = 0; i < matcher.group().length(); i++) {
                        if (Character.isDigit(found.charAt(i))) {
                            laundryTime += matcher.group().charAt(i) - 48;
                        }
                    }
                }
            }

        }
        System.out.printf("Doing the dishes - %d min.%n",dishesTime);
        System.out.printf("Cleaning the house - %d min.%n",cleaningTime);
        System.out.printf("Doing the laundry - %d min.%n",laundryTime);
        System.out.printf("Total - %d min.%n",dishesTime + laundryTime + cleaningTime);
    }
}
