package FundamentalsFinalExam;

import java.util.Scanner;

public class TextProcessing {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        StringBuilder sb = new StringBuilder();
        while (true) {
            String command = input.nextLine();
            if (command.equals("Done")) {
                break;
            }
            if (command.contains("Change ")) {
                command = command.replace("Change ","");
                String[] chars = command.split(" ");
                char old = chars[0].charAt(0);
                char newChar = chars[1].charAt(0);
                str = str.replace(old, newChar);
                System.out.println(str);
            } else if (command.contains("Includes ")) {
                command = command.replace("Includes ","");
                if (str.contains(command)) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
            } else if (command.contains("End ")) {
                command = command.replace("End ","");
                int lenght = command.length();
                for (int i = str.length() - lenght; i < str.length(); i++) {
                    sb.append(str.charAt(i));
                }
                if (sb.toString().equals(command)) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }

            } else if (command.equals("Uppercase")) {
                str = str.toUpperCase();
                System.out.println(str);
            } else if (command.contains("FindIndex ")) {
                command = command.replace("FindIndex ", "");
                char ch = command.charAt(0);
                if (command.contains(command)) {
                    System.out.println(str.indexOf(ch));
                }
            } else if (command.contains("Cut ")) {
                command = command.replace("Cut ","");
                String[] strings = command.split(" ");
                int startIndex = Integer.parseInt(strings[0]);
                int lenght = Integer.parseInt(strings[1]);
                String string = str.substring(startIndex, startIndex + lenght);
                str = string;
                System.out.println(str);
            }
        }
    }
}
