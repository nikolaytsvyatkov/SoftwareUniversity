package FinalExamsFundamentalsModule;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnimalSanctuary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        Pattern pattern = Pattern.compile("n:(?<name>[^;]+);t:(?<kind>[^;]+);c--(?<country>[A-Za-z ]+)");
        StringBuilder sb = new StringBuilder();
        int kg = 0;
        for (int i = 0; i < n; i++) {
            String str = input.nextLine();
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()){
                String name = matcher.group("name");
                name = name(name);
                String kind = matcher.group("kind");
                kind = name(kind);
                String country = matcher.group("country");
                country = name(country);
                System.out.printf("%s is a %s from %s%n",name, kind, country);
                kg = calculate(kg,matcher.group("name"));
                kg = calculate(kg, matcher.group("kind"));


            }
        }
        System.out.printf("Total weight of animals: %d%s%n",kg,"KG");
    }
    static String name (String str) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < str.length(); j++) {
            if (Character.isAlphabetic(str.charAt(j)) || str.charAt(j) == ' ') {
                sb.append(str.charAt(j));
            }

        }
        str = sb.toString();
        return str;
    }
    static int calculate (int a, String str) {
        for (int s = 0; s < str.length(); s++) {
            if (Character.isDigit(str.charAt(s))){
                a += str.charAt(s) - 48;
            }
        }
        return a;
    }


}
