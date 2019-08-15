package FinalExamsFundamentalsModule;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        Pattern pattern = Pattern.compile("(.+)>(?<numbers>[\\d]{3})\\|(?<lower>[a-z]{3})\\|(?<uper>[A-Z]{3})\\|(?<all>[^<>]+)<(\\1)");
        for (int i = 0; i < n; i++) {
            String string = input.nextLine();
            Matcher matcher = pattern.matcher(string);
            StringBuilder sb = new StringBuilder();
            if (matcher.find()) {
                sb.append(matcher.group("numbers"));
                sb.append(matcher.group("lower"));
                sb.append(matcher.group("uper"));
                sb.append(matcher.group("all"));
                System.out.println("Password: " + sb.toString());

            } else {
                System.out.println("Try another password!");
            }
        }
    }
}
