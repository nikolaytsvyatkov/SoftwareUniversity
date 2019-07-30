package FinalExamsFundamentalsModule;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnimalSanctuary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Pattern pattern = Pattern.compile("n:(?<name>[^;]+);t:(?<kind>[^;]+);c--(?<country>[A-Za-z ]+)");
        int n = Integer.parseInt(input.nextLine());
        int totalKg = 0;
        for (int i = 0; i < n; i++) {
            String str = input.nextLine();
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                String name = matcher.group("name");
                name = name.replaceAll("[^A-Za-z ]","");
                String kind = matcher.group("kind").replaceAll("[^A-Za-z ]","");
                String country = matcher.group("country");
                int kg = kg(matcher.group("name"));
                kg += kg(matcher.group("kind"));
                totalKg += kg;
                System.out.printf("%s is a %s from %s%n",name,kind,country);

            }
        }
        System.out.printf("Total weight of animals: %d%s",totalKg,"KG");

    }
    static int kg (String str) {
        int kg = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                kg += str.charAt(i) - 48;
            }
        }
        return kg;
    }
}
