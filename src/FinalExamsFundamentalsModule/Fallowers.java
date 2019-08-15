package FinalExamsFundamentalsModule;

import java.util.*;

public class Fallowers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, List<Integer>> map = new LinkedHashMap<>();
        while (true) {
            String command = input.nextLine();
            if (command.equals("Log out")) {
                break;
            }
            if (command.contains("New follower: ")) {
                command = command.replace("New follower: ","");
                List<Integer> list = map.get(command);
                if (list == null) {
                    list = new ArrayList<>();
                    list.add(0,0);
                    list.add(1,0);
                }
                map.put(command, list);
            } else if (command.contains("Like: ")) {
                command = command.replace("Like: ","");
                String name = command.substring(0, command.indexOf(":"));
                int count = Integer.parseInt(command.substring(command.indexOf(":") + 2));
                List<Integer> list = map.get(name);
                if (list == null) {
                    list = new ArrayList<>();
                    list.add(0, count);
                    list.add(1, 0);
                } else {
                    list.set(0,list.get(0) + count);
                }
                map.put(name, list);
            } else if (command.contains("Comment: ")) {
                command = command.replace("Comment: ","");

                List<Integer> list = map.get(command);
                if (list == null) {
                    list = new ArrayList<>();
                    list.add(0, 0);
                    list.add(1, 1);
                } else {
                    list.set(1,list.get(1) + 1);
                }
                map.put(command, list);

            } else if (command.contains("Blocked: ")) {
                command = command.replace("Blocked: ","");
                map.remove(command);
            }

        }
        System.out.printf("%d followers%n",map.size());
        map.entrySet().stream().sorted((a, b) -> {
            int result = Integer.compare(b.getValue().get(0), a.getValue().get(0));
            if (result == 0) {
                result = a.getKey().compareTo(b.getKey());
            }
            return result;
        }).forEach(e -> {
            System.out.printf("%s: %d%n",e.getKey(),e.getValue().get(0) + e.getValue().get(1));
        });
    }
}
