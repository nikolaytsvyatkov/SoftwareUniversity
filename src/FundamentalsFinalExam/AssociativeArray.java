package FundamentalsFinalExam;

import java.util.*;

public class AssociativeArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, List<Integer>> map = new LinkedHashMap<>();
        while (true) {
            String command = input.nextLine();
            if (command.equals("Results")) {
                break;
            }
            if (command.contains("Add:")) {
                command = command.replace("Add:","");
                String[] strings = command.split(":");
                String name = strings[0];
                int health =  Integer.parseInt(strings[1]);
                int energy  = Integer.parseInt(strings[2]);
                List<Integer> list = map.get(name);
                if (list == null) {
                    list = new ArrayList<>();
                    list.add(health);
                    list.add(energy);
                } else {
                    list.set(0, list.get(0) + health);
                }
                map.put(name, list);
            } else if (command.contains("Attack:")) {
                command = command.replace("Attack:","");
                String[] strings = command.split(":");
                String attacker = strings[0];
                String defender = strings[1];
                int damage = Integer.parseInt(strings[2]);
                if (map.containsKey(attacker) && map.containsKey(defender)) {
                    List<Integer> list = map.get(defender);
                    list.set(0, list.get(0) - damage);
                    map.put(defender, list);
                    if (list.get(0) <= 0) {
                        System.out.printf("%s was disqualified!%n",defender);
                        map.remove(defender);
                    }

                    List<Integer> attack = map.get(attacker);
                    attack.set(1, attack.get(1) - 1);
                    map.put(attacker, attack);
                    if (attack.get(1) <= 0) {
                        System.out.printf("%s was disqualified!%n",attacker);
                        map.remove(attacker);
                    }
                }
            } else if (command.contains("Delete:")) {
                command = command.replace("Delete:","");
                if (command.equals("All")) {
                    map = new LinkedHashMap<>();
                }
                if (map.containsKey(command)) {
                    map.remove(command);
                }
            }

        }
        System.out.printf("People count: %d%n",map.size());
        map.entrySet().stream().sorted((a, b) ->{
            int result = Integer.compare(b.getValue().get(0), a.getValue().get(0));
            if (result == 0) {
                result = a.getKey().compareTo(b.getKey());
            }
            return result;
        }).forEach(e -> {
            System.out.printf("%s - %d - %d%n",e.getKey(), e.getValue().get(0), e.getValue().get(1));
        });
    }
}

