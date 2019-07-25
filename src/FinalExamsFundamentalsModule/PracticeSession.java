package FinalExamsFundamentalsModule;

import java.util.*;

public class PracticeSession {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, List<String>> map =new LinkedHashMap<>();
        while (true) {
            String command = input.nextLine();
            if (command.equals("END")) {
                break;
            }
            if (command.contains("Add->")) {
                command = command.replace("Add->","");
                String[] strings = command.split("->");
                List<String> list = map.get(strings[0]);
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(strings[1]);
                map.put(strings[0], list);
            } else if (command.contains("Move->")) {
                command = command.replace("Move->","");
                String[] strings = command.split("->");
                String current = strings[0];
                String racer = strings[1];
                String nextRoad = strings[2];
                List<String> listCurrent = map.get(current);
                if (listCurrent.contains(racer)) {
                    listCurrent.remove(racer);
                    List<String> newRacer = map.get(nextRoad);
                    newRacer.add(racer);
                    map.put(nextRoad, newRacer);
                }
            } else if (command.contains("Close->")) {
                command = command.replace("Close->","");
                if (map.containsKey(command)) {
                    map.remove(command);
                }
            }
        }
        System.out.println("Practice sessions:");
        map.entrySet().stream().sorted((a, b) ->{
            int result = Integer.compare(b.getValue().size(), a.getValue().size());
            if (result == 0) {
               result = a.getKey().compareTo(b.getKey());
            }
            return result;
        }).forEach( e ->{
            System.out.println(e.getKey());
            List<String> list = e.getValue();
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("++%s%n",list.get(i));
            }
        } );
    }
}
