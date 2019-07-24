package FinalExamsFundamentalsModule;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheIsleOfManTTRace {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^([#$%*&])(?<name>[A-Za-z]+)(\\1)=(?<lenght>[\\d]+)!!(?<code>.+)$");
        while (true) {
            String str = input.nextLine();
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                String name = matcher.group("name");
                int lenght = Integer.parseInt(matcher.group("lenght"));
                String code = matcher.group("code");
                if (lenght == code.length()) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0 ; i < code.length(); i++) {
                        char ch = (char)(code.charAt(i) + lenght);
                        sb.append(ch);
                    }
                    System.out.printf("Coordinates found! %s -> %s%n",name,sb.toString());
                    break;
                } else {
                    System.out.println("Nothing found!");
                }
            } else {
                System.out.println("Nothing found!");
            }
        }
    }
}
