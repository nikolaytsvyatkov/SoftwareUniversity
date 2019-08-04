package FundamentalsFinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        Pattern pattern = Pattern.compile("([\\*\\@])(?<tag>[A-Z][a-z]{3,})(\\1): (\\[(?<first>[A-Za-z])\\]\\|\\[(?<second>[A-Za-z])\\]\\|\\[(?<third>[A-Za-z])\\]\\|)$");
        for (int i = 0; i < n; i++) {
            String str = input.nextLine();
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                int first =(int) matcher.group("first").charAt(0);
                int second = matcher.group("second").charAt(0);
                int third = matcher.group("third").charAt(0);
                String tag = matcher.group("tag");
                System.out.printf("%s: %d %d %d%n",tag, first,second,third);

            } else {
                System.out.println("Valid message not found!");
            }
        }

    }
}

