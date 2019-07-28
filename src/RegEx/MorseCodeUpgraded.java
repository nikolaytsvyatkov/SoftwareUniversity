package RegEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MorseCodeUpgraded {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] strings = input.nextLine().split("\\|");
        boolean flag = false;

        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            int zero = 0;
            int ones = 0;
            int repeated = 0;
            int toAdd = 0;
            String current = strings[i];
            for (int j = 0; j < current.length(); j++) {
                if (current.charAt(j) == '0') {
                    zero++;
                } else if (current.charAt(j) == '1') {
                    ones++;
                }
                if (current.length() - 1 != j) {
                    if (current.charAt(j) == current.charAt(j + 1)) {
                        repeated++;
                    } else {
                        if (repeated != 0)
                            toAdd += repeated + 1;
                        repeated = 0;
                    }
                } else {
                    if (current.charAt(current.length() - 2) == current.charAt(current.length() - 1)) {
                        repeated++;

                    }
                    toAdd += repeated;

                }
            }
            int sum = zero * 3 + ones * 5 + toAdd;
            sb.append((char) sum);
            sum = 0;
        }
        System.out.println(sb.toString());
    }
}
