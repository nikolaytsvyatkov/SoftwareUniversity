package FinalExamsFundamentalsModule;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> list =  Arrays.stream(input.nextLine().split("\\|")).collect(Collectors.toList());
        List<String> stollen = new ArrayList<>();

        while (true) {
            String command = input.nextLine();
            if (command.equals("Yohoho!")) {
                break;
            }
            if (command.contains("Loot ")) {
                command = command.replace("Loot ","");
                List<String> list2 = Arrays.stream(command.split(" +")).collect(Collectors.toList());
                List<String> stringList = new ArrayList<>();
                for (int i = 0; i < list2.size(); i++) {
                    if (!list.contains(list2.get(i))) {
                        stringList.add(0, list2.get(i));
                    }
                }
                list.addAll(0, stringList);
            } else if (command.contains("Drop ")) {
                command = command.replace("Drop ","");
                int index = Integer.parseInt(command);
                if (index >= 0 && index < list.size()) {
                    String add = list.get(index);
                    list.remove(index);
                    list.add(add);
                }
            }else if (command.contains("Steal ")) {
                command = command.replace("Steal ","");
                int count = Integer.parseInt(command);
                while (count != 0) {
                    stollen.add(list.get(list.size() - 1));
                    list.remove(list.get(list.size() - 1));
                    count --;
                    if (list.size() <= 0) {
                        break;
                    }
                }
                Collections.reverse(stollen);
                for (int i = 0; i < stollen.size(); i++) {
                    if (i != stollen.size() - 1) {
                        System.out.print(stollen.get(i) + ", ");
                    } else {
                        System.out.print(stollen.get(i));
                        System.out.println();
                    }
                }
            }

        }
        if (list.size() == 0) {
            System.out.println("Failed treasure hunt.");
        } else {
            double count = 0;
            for (String i : list) {
                count += i.length();
            }
            System.out.printf("Average treasure gain: %.2f pirate credits.%n",count / list.size());
        }
    }
}
