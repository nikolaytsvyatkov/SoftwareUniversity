package FinalExamsFundamentalsModule;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnonymousFox {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        Pattern pattern = Pattern.compile("(?<start>[A-Za-z]+)(?<placeholder>.+)(\\1)");
        String[] strings = input.nextLine().split("[{}]");
        List<String> list = new ArrayList<>();
        for (String i : strings) {
            if (!i.equals("")) {
                list.add(i);
            }
        }
        Matcher matcher = pattern.matcher(str);
        int i = 0;
        while (matcher.find()) {
            String toReplace = matcher.group("placeholder");
            String toBeReplaced = list.get(i);
            str = str.replace(toReplace, toBeReplaced);
            i++;
        }
        System.out.println(str);
    }
}
