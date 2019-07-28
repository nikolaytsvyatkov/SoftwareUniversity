package RegEx;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Emailme {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String email = input.nextLine();
        int before = 0;
        int after = 0;
        Pattern pattern = Pattern.compile("(?<before>.+)@(?<after>.+)");
        Matcher matcher = pattern.matcher(email);
        if (matcher.find()) {
            String beforeStr = matcher.group("before");
            String afterStr = matcher.group("after");
            for (int i = 0; i < beforeStr.length(); i++) {
                before += (int) beforeStr.charAt(i);
            }
            for (int i = 0; i < afterStr.length(); i++) {
                after += (int) afterStr.charAt(i);
            }
        }

        int result = before - after;
        if (result >= 0) {
            System.out.println("Call her!");
        } else {
            System.out.println("She is not the one.");
        }
    }
}
