package RegEx;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> list = Arrays.stream(input.nextLine().trim().split("[, ]+")).collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).length() == 20) {
                String left = list.get(i).substring(0,10);
                String right = list.get(i).substring(10,20);
                Pattern win = Pattern.compile("[\\\\@]{6,}|[\\\\$]{6,}|[\\\\#]{6,}|[\\\\^]{6,}");
                Matcher leftWin = win.matcher(left);
                Matcher righrtWin = win.matcher(right);
                if (leftWin.find() && righrtWin.find() && ((leftWin.group().charAt(0) == righrtWin.group().charAt(0)))) {

                    if ((leftWin.group().length() >= 6 && leftWin.group().length() <= 9) && (righrtWin.group().length() >= 6 && righrtWin.group().length() <= 9)) {
                        int min = Math.min(leftWin.group().length(),righrtWin.group().length());
                        System.out.printf("ticket \"%s\" - %d%c%n",list.get(i),min,leftWin.group().charAt(0));
                    } else if (leftWin.group().length() == 10 && righrtWin.group().length() == 10) {
                        System.out.printf("ticket \"%s\" - %d%c Jackpot!%n",list.get(i),leftWin.group().length(),leftWin.group().charAt(0));
                    }

                } else {
                    System.out.printf("ticket \"%s\" - no match%n",list.get(i));
                }
            } else {
                System.out.println("invalid ticket");
            }
        }
    }
}

