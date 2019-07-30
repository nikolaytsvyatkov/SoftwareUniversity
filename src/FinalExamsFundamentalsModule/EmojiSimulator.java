package FinalExamsFundamentalsModule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class EmojiSimulator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(?<=[ ]):(?<emoji>[a-z]{4,}):(?=[ .,?!])");
        List<String> emoji = new ArrayList<>();
        int totalPoints = 0;
        boolean flag = false;
        String str = input.nextLine();
        Matcher matcher = pattern.matcher(str);
        List<Integer> numbers = Arrays.stream(input.nextLine().split(":")).map(e->Integer.parseInt(e)).collect(Collectors.toList());
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        while (matcher.find()) {
            int currentPoints = 0;
            String emoj = matcher.group("emoji");
            for (int i = 0; i < emoj.length(); i++) {
                currentPoints += emoj.charAt(i);
            }
            if (currentPoints == sum) {
                flag = true;
            }
            totalPoints += currentPoints;
            emoji.add(matcher.group());
        }
        if (flag) {
            totalPoints *= 2;
        }
        if (emoji.size() == 0) {
            System.out.println("Total Emoji Power: 0");
        } else {
            System.out.print("Emojis found: ");
            for (int i = 0; i < emoji.size(); i++) {
                if (i != emoji.size() - 1) {
                    System.out.printf("%s, ",emoji.get(i));
                } else {
                    System.out.printf("%s",emoji.get(i));
                }

            }
            System.out.println();
            System.out.printf("Total Emoji Power: %d%n", totalPoints);
        }
    }
}
