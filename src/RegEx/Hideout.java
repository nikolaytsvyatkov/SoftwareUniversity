package RegEx;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hideout {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
            String string = input.nextLine();
            while (true) {
                String[] arr = input.nextLine().split(" ");
                String charachter = arr[0];
                int number = Integer.parseInt(arr[1]);
                String num = String.format("{%d,}", number);
                charachter += num;
                String pattern = String.format("(\\%s)", charachter);
                //System.out.println(pattern);
                Pattern pattern1 = Pattern.compile(pattern);
                Matcher matcher = pattern1.matcher(string);
                if (matcher.find()) {
                    int firstIndex = string.indexOf(matcher.group());
                    StringBuilder sb = new StringBuilder();
                    for (int i = firstIndex; i < string.length(); i++) {
                        if (string.charAt(i) == charachter.charAt(0)) {
                            sb.append(string.charAt(i));
                        }
                    }
                    System.out.printf("Hideout found at index %d and it is with size %d!%n",firstIndex,sb.toString().length());
                    break;
                }
            }


    }
}
