package RegEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String regEx = ">>([A-Za-z]+)<<(\\d+.?(\\d+)?)!(\\d+)";
        Pattern pattern = Pattern.compile(">>([A-Za-z]+)<<(\\d+.?\\d+?)!(\\d+)");
        double sum = 0;
        System.out.println("Bought furniture:");
        while (true) {
            String string = input.nextLine();
            if (string.equals("Purchase")) {
                break;
            }
            Matcher matcher = pattern.matcher(string);
            while (matcher.find()) {
                double price = Double.parseDouble(matcher.group(2));
                int qunatity = Integer.parseInt(matcher.group(3));
                sum += price * qunatity;
                System.out.println(matcher.group(1));
            }

        }
        System.out.printf("Total money spend: %.2f%n",sum);

    }
}

