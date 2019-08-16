package RegEx;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
public class StarEnigma {




    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        int countA = 0;
        int countD = 0;
        List<String> destroied = new ArrayList<>();
        List<String> attacked = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = input.nextLine();
            int count = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 's' || str.charAt(j) == 't' || str.charAt(j) == 'a' || str.charAt(j) == 'r'
                        || str.charAt(j) == 'S' || str.charAt(j) == 'T' || str.charAt(j) == 'A' || str.charAt(j) == 'R') {
                    count ++;
                }
            }
            for (int j = 0; j < str.length(); j++) {
                char append = (char) (str.charAt(j)  - count);
                sb.append(append);
            }
            String currentString = sb.toString();
            Pattern pattern = Pattern.compile("([^@\\-\\!:>])*@(?<name>[A-Za-z]+)([^@\\-\\!:>])*:(?<population>[\\d]+)([^@\\-\\!:>])*!(?<attack>[AD])!([^@\\-\\!:>])*->(?<solderCount>[\\d]+)([^@\\-\\!:>])*");
            Matcher matcher = pattern.matcher(currentString);
            if (matcher.find()) {
                String planet = matcher.group("name");
                String attack = matcher.group("attack");
                if (attack.equals("A")) {
                    countA++;
                    attacked.add(planet);
                } else if (attack.equals("D")) {
                    destroied.add(planet);
                    countD++;
                }
            }

        }
        System.out.println("Attacked planets: " + countA);
        if (attacked.size() != 0) {
            Collections.sort(attacked);
            for (String i : attacked) {
                System.out.printf("-> %s%n",i);
            }
        }
        System.out.println("Destroyed planets: " + countD);
        if (destroied.size() != 0) {
            Collections.sort(destroied);
            for (String i : destroied) {
                System.out.printf("-> %s%n",i);
            }
        }
    }
}




