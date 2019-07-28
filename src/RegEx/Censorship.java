package RegEx;

import java.util.Scanner;

public class Censorship {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String word = input.nextLine();
        String sentence = input.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            sb.append("*");
        }
        if (sentence.contains(word)) {
           sentence = sentence.replaceAll(word,sb.toString());
        }
        System.out.println(sentence);
    }
}
