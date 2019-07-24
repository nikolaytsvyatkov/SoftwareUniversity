package FinalExamsFundamentalsModule;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deciphering {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        String[] strings = input.nextLine().split(" ");
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("^[d-z{}|#]+$");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            for (int i = 0; i < str.length(); i++) {
                char ch = (char)(str.charAt(i) - 3);
                sb.append(ch);
            }
            String newString = sb.toString();
            String first = strings[0];
            String second = strings[1];
            if (newString.contains(first)) {
                newString = newString.replaceAll(first, second);
            }
            System.out.println(newString);
        } else {
            System.out.println("This is not the book you are looking for.");
        }

    }
}
