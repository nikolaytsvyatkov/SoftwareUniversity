package FinalExamsFundamentalsModule;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActivitionKey {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] strings = input.nextLine().split("&");
        Pattern pattern = Pattern.compile("([A-Za-z\\d]{25}|[A-Za-z\\d]{16})");
        List<String> code = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            Matcher matcher = pattern.matcher(strings[i]);
            StringBuilder sb = new StringBuilder();
            if (matcher.find()) {
                String str = matcher.group();
                str = str.toUpperCase();

                for (int j = 0; j < str.length(); j++) {
                    if (Character.isDigit(str.charAt(j))) {
                        int digit = str.charAt(j) - 48;
                        digit = 9 - digit;
                        sb.append(digit);

                    } else {
                        sb.append(str.charAt(j));
                    }

                }
                String string = sb.toString();
                sb = new StringBuilder();
                if (string.length() == 25) {
                    for (int j = 0; j < string.length(); j++) {
                        if (j % 5 == 0 && j != 0) {
                            sb.append("-");
                        }
                        sb.append(string.charAt(j));
                    }
                } else if (string.length() == 16) {
                    for (int j = 0; j < string.length(); j++) {
                        if (j % 4 == 0 && j != 0) {
                            sb.append("-");
                        }
                        sb.append(string.charAt(j));
                    }
                }


            }
            if (!sb.toString().equals(""))
                code.add(sb.toString());

        }
        for (int i = 0; i < code.size(); i++) {
            if (i != code.size() - 1) {
                System.out.printf("%s, ", code.get(i));
            } else {
                System.out.printf("%s", code.get(i));
            }
        }
    }
}

