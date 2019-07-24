package FinalExamsFundamentalsModule;

import java.util.*;
import java.util.stream.Collectors;

public class Concert {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, List<String>> bands = new LinkedHashMap<>();
        Map<String, Integer> singing = new LinkedHashMap<>();
        String print = "";
        while (true) {
            String command = input.nextLine();
            if (command.equals("start of concert")) {
                print = input.nextLine();
                break;
            }
            if (command.contains("Add; ")) {
                command = command.replace("Add; ","");
                String key = command.substring(0, command.indexOf(";"));
                command = command.replace(command.substring(0, command.indexOf(";") + 2), "");
                List<String> people = Arrays.stream(command.split(", ")).collect(Collectors.toList());
                List<String> list = bands.get(key);
                if (list == null) {
                    list = new ArrayList<>();
                    for (int i = 0; i < people.size(); i++) {
                        if (!list.contains(people.get(i))) {
                            list.add(people.get(i));
                        }
                    }

                } else {
                    for (int i = 0; i < people.size(); i++) {
                        if (!list.contains(people.get(i))) {
                            list.add(people.get(i));
                        }
                    }
                }
                bands.put(key, list);
            } else if (command.contains("Play; ")) {
                command = command.replace("Play; ","");
                String key = command.substring(0, command.indexOf(";"));
                command = command.replace(command.substring(0, command.indexOf(";") + 2), "");
                int playTime = Integer.parseInt(command);
                if (!singing.containsKey(key)) {
                    singing.put(key, playTime);
                } else {
                    singing.put(key, singing.get(key) + playTime);
                }

            }
        }
        int totalTime = 0;
        for (Map.Entry<String, Integer> entry : singing.entrySet()) {
            totalTime += entry.getValue();
        }
        System.out.println("Total time: " + totalTime);
        singing.entrySet().stream().sorted((a, b) -> {
            int result = Integer.compare(b.getValue(), a.getValue());
            if (result == 0) {
                result = a.getKey().compareTo(b.getKey());
            }
            return result;
        }).forEach(e -> {
            System.out.printf("%s -> %d%n", e.getKey(), e.getValue());
        });
        List<String> toPrint = bands.get(print);
        System.out.println(print);
        for (int i = 0; i < toPrint.size(); i++) {
            System.out.printf("=> %s%n", toPrint.get(i));
        }

    }
}
