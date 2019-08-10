package RegEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Pattern pattern = Pattern.compile("([^\\d]+)(\\d+)");
        String str = input.nextLine();
        Matcher matcher = pattern.matcher(str);
        StringBuilder sb = new StringBuilder();
        List<Character> list = new ArrayList<>();
        while (matcher.find()) {
            String find = matcher.group(1);

            int repeats = Integer.parseInt(matcher.group(2));
            find = find.toUpperCase();

            for (int i = 0; i < repeats; i++) {
                sb.append(find);
            }

        }
        String end = sb.toString();
        char[] ch = end.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (!list.contains(ch[i])) {
                list.add(ch[i]);
            }
        }
        System.out.printf("Unique symbols used: %d%n",list.size());
        System.out.println(sb.toString());
    }
}

