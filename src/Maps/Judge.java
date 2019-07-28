package Maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Judge {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, Map<String, Integer>> map = new LinkedHashMap<>();
        //contest
        Map<String, Integer> standing = new LinkedHashMap<>();
        while (true) {
            String command = input.nextLine();
            if (command.equals("no more time")) {
                break;
            }
            String[] strings = command.split(" -> ");
            // name , contest, point
            Map<String, Integer> result = map.get(strings[1]);

            if (result == null) {
                result = new LinkedHashMap<>();
                result.put(strings[0], Integer.parseInt(strings[2]));
                map.put(strings[1], result);
            } else {

                if (!result.containsKey(strings[0])) {
                    result.put(strings[0], Integer.parseInt(strings[2]));
                } else {
                    int current = Integer.parseInt(strings[2]);

                    if (result.get(strings[0]) < current) {
                        result.put(strings[0], current);
                    }

                }
                map.put(strings[1], result);
            }
        }
        for (Map.Entry<String, Map<String, Integer>> entry : map.entrySet()) {
            Map<String, Integer> map1 = entry.getValue();
            for (Map.Entry<String, Integer> entry1 : map1.entrySet()) {
                if (!standing.containsKey(entry1.getKey())) {
                    standing.put(entry1.getKey(), entry1.getValue());
                } else {
                    standing.put(entry1.getKey(), standing.get(entry1.getKey()) + entry1.getValue());
                }
            }
        }
        AtomicInteger ai = new AtomicInteger();

        for (Map.Entry<String, Map<String, Integer>> entry : map.entrySet()) {
            System.out.printf("%s: %d participants%n",entry.getKey(),entry.getValue().size());

            Map<String, Integer> map1 = entry.getValue();
            ai.set(1);
            map1.entrySet().stream().sorted((a, b) -> {
                int result = Integer.compare(b.getValue(), a.getValue());
                if (result == 0) {
                    result = a.getKey().compareTo(b.getKey());
                }
                return result;
            }).forEach(e -> {
                System.out.printf("%d. %s <::> %d%n",ai.getAndIncrement(),e.getKey(),e.getValue());
            });


        }
        System.out.println("Individual standings:");
        ai.set(1);
        standing.entrySet().stream().sorted((a, b) -> {
            int result = Integer.compare(b.getValue(), a.getValue());
            if (result == 0) {
                result = a.getKey().compareTo(b.getKey());
            }
            return result;
        }).forEach(e->{System.out.printf("%d. %s -> %d%n",ai.getAndIncrement(),e.getKey(),e.getValue());});



    }
}

