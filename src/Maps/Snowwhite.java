package Maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Snowwhite {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, Map<String, Integer>> map = new LinkedHashMap<>();
        Map<String, Integer> sameCap = new LinkedHashMap<>();
        //name, colour, physic

        while (true) {
            String command = input.nextLine();
            if (command.equals("Once upon a time")) {
                break;
            }
            String[] strings = command.split(" <:> ");
            //name, colour, physic
            Map<String, Integer> map1 = map.get(strings[0]);
            if (map1 == null) {
                map1 = new LinkedHashMap<>();
                sameCap.put(strings[0], 0);
            }
            if (!map1.containsKey(strings[1])) {
                map1.put(strings[1], Integer.parseInt(strings[2]));
            } else {
                int current = map1.get(strings[1]);
                if (current < Integer.parseInt(strings[2])) {
                    map1.put(strings[1], Integer.parseInt(strings[2]));
                }
            }
            map.put(strings[0], map1);
            for(Map.Entry<String, Map<String, Integer>> entry : map.entrySet()) {
                Map<String, Integer> map2 = entry.getValue();

            }
        }

    }
}
