package FinalExamsFundamentalsModule;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMon {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Pattern bojomon = Pattern.compile("([A-Za-z]+)-\\1");
        Pattern didimon  = Pattern.compile("([^A-Za-z\\-]+)");
        String str = input.nextLine();

        while (!str.equals("")) {
            Matcher d = didimon.matcher(str);
            if (d.find()) {
                String print = d.group();
                str = str.replace(print,"");
                System.out.println(print);
            }
            Matcher b = bojomon.matcher(str);
            if (b.find()) {
                String print = b.group();
                str = str.replace(print,"");
                System.out.println(print);
            }

        }
    }
}
