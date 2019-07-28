package RegEx;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mines {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Pattern pattern = Pattern.compile("<(?<first>[A-Za-z])(?<second>[A-Za-z])>");
        String str = input.nextLine();
        Matcher matcher = pattern.matcher(str);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            int first = (int) matcher.group("first").charAt(0);
            int second = (int) matcher.group("second").charAt(0);
            int destroy = Math.abs(first - second);


        }
    }
}
