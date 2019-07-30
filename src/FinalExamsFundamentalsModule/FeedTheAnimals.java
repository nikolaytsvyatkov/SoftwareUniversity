package FinalExamsFundamentalsModule;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FeedTheAnimals {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, Integer> animal = new LinkedHashMap<>();
        Map<String, Integer> area = new LinkedHashMap<>();
        while (true) {
            String command = input.nextLine();
            if (command.equals("Last Info")) {
                break;
            }
            if (command.contains("Add:")) {
                command = command.replace("Add:","");
                String[] strings = command.split(":");
                if (!animal.containsKey(strings[0])) {
                    animal.put(strings[0], Integer.parseInt(strings[1]));
                    if (!area.containsKey(strings[2])) {
                        area.put(strings[2], 1);
                    } else {
                        area.put(strings[2], area.get(strings[2]) + 1);
                    }
                } else {
                    animal.put(strings[0], animal.get(strings[0]) + Integer.parseInt(strings[1]));
                }

            } else if (command.contains("Feed:")) {
                command = command.replace("Feed:","");
                String[] strings = command.split(":");
                if (animal.containsKey(strings[0])) {
                    int reduce = animal.get(strings[0]) - Integer.parseInt(strings[1]);
                    if (reduce <= 0) {
                        animal.remove(strings[0]);
                        area.put(strings[2], area.get(strings[2]) - 1);
                        System.out.println(strings[0] + " was successfully fed");
                    } else {
                        animal.put(strings[0], reduce);
                    }
                }
            }
        }
        System.out.println("Animals:");
        animal.entrySet().stream().sorted((a, b) ->{
            int result = Integer.compare(b.getValue(), a.getValue());
            if (result == 0) {
                result = a.getKey().compareTo(b.getKey());
            }
            return result;
        }).forEach(e->{
            System.out.printf("%s -> %d%s%n",e.getKey(), e.getValue(),"g");
        });
        System.out.println("Areas with hungry animals:");
        area.entrySet().stream().sorted((a, b) ->{
            return Integer.compare(b.getValue(), a.getValue());
        }).forEach(e -> {
            if (e.getValue() > 0) {
                System.out.printf("%s : %d%n",e.getKey(),e.getValue());
            }
        });
    }
}
