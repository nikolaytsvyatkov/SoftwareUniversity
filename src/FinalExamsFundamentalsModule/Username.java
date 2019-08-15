package FinalExamsFundamentalsModule;

import java.util.Arrays;
import java.util.Scanner;

public class Username {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String username = input.nextLine();
        while (true) {
            String command = input.nextLine();
            if (command.equals("Sign up")) {
                break;
            }
            if (command.contains("Case ")) {
                command = command.replace("Case ","");
                if (command.equals("lower")) {
                    username = username.toLowerCase();
                } else if (command.equals("upper")) {
                    username = username.toUpperCase();
                }
                System.out.println(username);
            } else if (command.contains("Reverse ")) {
                command = command.replace("Reverse ","");
                int startIndex = Integer.parseInt(command.substring(0, command.indexOf(" ")));
                int endIndex = Integer.parseInt(command.substring(command.indexOf(" ") + 1,command.length()));
                if (startIndex >= 0 && startIndex < username.length() && endIndex >= 0 && endIndex < username.length()) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = startIndex; i <= endIndex; i++) {
                        sb.append(username.charAt(i));
                    }
                    System.out.println(sb.reverse().toString());
                }

            } else if (command.contains("Cut ")) {
                command = command.replace("Cut ","");
                if (username.contains(command)) {
                    username = username.replace(command, "");
                    System.out.println(username);
                } else {
                    System.out.printf("The word %s doesn't contain %s.%n",username,command);
                }
            } else if (command.contains("Replace ")) {
                command = command.replace("Replace ", "");
                if (username.contains(command)) {
                    username = username.replace(command,"*");
                    System.out.println(username);
                }
            } else if (command.contains("Check ")) {
                command = command.replace("Check ","");
                if (username.contains(command)) {
                    System.out.println("Valid");
                } else {
                    System.out.printf("Your username must contain %s.%n",command);
                }
            }
        }
    }
}
