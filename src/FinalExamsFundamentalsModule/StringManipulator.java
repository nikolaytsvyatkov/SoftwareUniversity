package FinalExamsFundamentalsModule;

import java.util.Scanner;

public class StringManipulator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = "";
        while (true) {
            String command = input.nextLine();
            if (command.equals("End")) {
                break;
            }
            if (command.contains("Add ")) {
                command = command.replace("Add ","");
                str += command;
            } else if (command.contains("Upgrade ")) {
                char current = command.replace("Upgrade ","").charAt(0);
                char replaced = (char)(current + 1);
                str = str.replace(current, replaced);
            } else if (command.equals("Print")) {
                System.out.println(str);
            } else if (command.contains("Index ")) {
                boolean flag = false;
                char ch = command.replace("Index ","").charAt(0);
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == ch) {
                        flag = true;
                        System.out.print(i+" ");
                    }
                }
                if (!flag) {
                    System.out.println("None");
                } else {
                    System.out.println();
                }

            } else if (command.contains("Remove ")) {
                command = command.replace("Remove ","");
                if (str.contains(command)) {
                    str = str.replace(command, "");
                }
            }
        }
    }
}
