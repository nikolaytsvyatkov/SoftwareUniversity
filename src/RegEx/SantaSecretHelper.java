package RegEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantaSecretHelper {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        List<String> kids = new ArrayList<>();
        Pattern pattern = Pattern.compile("([^\\@\\-!:>])*@(?<name>[A-Za-z]+)([^\\@\\-!:>])*!(?<behaviour>[A-Z])!([^\\@\\-!:>])*");
        while (true) {
            String command = input.nextLine();
            if (command.equals("end")) {
                break;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < command.length(); i++) {
                char ch = (char) (command.charAt(i) - n);
                sb.append(ch);

            }
            Matcher matcher = pattern.matcher(sb.toString());
            while (matcher.find()) {
                String name = matcher.group("name");
                String behaviout = matcher.group("behaviour");
                if (behaviout.equals("G")) {
                    kids.add(name);
                }
            }



        }
        for (int i = 0; i < kids.size(); i++) {
            System.out.println(kids.get(i));
        }
    }
}

