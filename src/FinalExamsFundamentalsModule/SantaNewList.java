package FinalExamsFundamentalsModule;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SantaNewList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();
        Map<String, Integer> typePresent = new LinkedHashMap<>();
        while (true) {
            String command = input.nextLine();
            if (command.equals("END")) {
                break;
            }
            if (command.contains("Remove->")) {
                command = command.replace("Remove->","");
                map.remove(command);

            } else {
                String[] strings = command.split("->");
                //name. type , amount
                if (!map.containsKey(strings[0])) {
                    map.put(strings[0], Integer.parseInt(strings[2]));
                } else {
                    map.put(strings[0], map.get(strings[0]) + Integer.parseInt(strings[2]));
                }
                if (!typePresent.containsKey(strings[1])) {
                    typePresent.put(strings[1], Integer.parseInt(strings[2]));
                } else {
                    typePresent.put(strings[1], typePresent.get(strings[1]) + Integer.parseInt(strings[2]));
                }
            }
        }
        System.out.println("Children:");
        map.entrySet().stream().sorted((a, b)->{
            int result = Integer.compare(b.getValue(), a.getValue());
            if (result == 0) {
                result = a.getKey().compareTo(b.getKey());
            }
            return result;
        }).forEach(e->{
            System.out.printf("%s -> %d%n",e.getKey(), e.getValue());
        });
        System.out.println("Presents:");
        typePresent.entrySet().stream().forEach(e -> {
            System.out.printf("%s -> %d%n",e.getKey(),e.getValue());
        });
    }
}
