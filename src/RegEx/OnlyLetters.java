package RegEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnlyLetters {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)) && Character.isAlphabetic(str.charAt(i + 1))) {
                str = str.replace(str.charAt(i), str.charAt(i + 1));
            } else {

            }
        }
    }
}
