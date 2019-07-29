package Maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Moba{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, Map<String, Integer>> map = new LinkedHashMap<>();
        //name, posiiton, skills
        Map<String, Integer> totalSkills = new LinkedHashMap<>();

        while (true) {
            String command = input.nextLine();
            if (command.equals("Season end")) {
                break;
            }
            if (command.contains(" -> ")) {
                String[] strings = command.split(" -> ");

                Map<String, Integer> map1 = map.get(strings[0]);
                if (map1 == null) {
                    map1 = new LinkedHashMap<>();
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

            } else if (command.contains("vs")) {
                String[] strings = command.split(" vs ");
                boolean flag = false;
                if (map.containsKey(strings[0]) && map.containsKey(strings[1])) {
                    Map<String, Integer>  name1 = map.get(strings[0]);
                    Map<String, Integer>  name2 = map.get(strings[1]);
                    int total1 = 0;
                    int total2 = 0;
                    for (Map.Entry<String, Integer> entry : name1.entrySet()) {
                        String currentPos = entry.getKey();
                        if (name2.containsKey(currentPos)) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        for (Map.Entry<String, Integer> entry : name1.entrySet()) {
                            total1 += entry.getValue();
                        }
                        for (Map.Entry<String, Integer> entry : name2.entrySet()) {
                            total2 += entry.getValue();
                        }
                        if (total1 > total2) {
                            map.remove(strings[1]);
                        } else if (total2 > total1) {
                            map.remove(strings[0]);
                        }
                    }

                }
            }
        }
        for (Map.Entry<String, Map<String, Integer>> entry : map.entrySet()) {
            Map<String, Integer> map1 = entry.getValue();
            int sum = 0;
            for (Map.Entry<String, Integer> entry1 : map1.entrySet()) {
                sum += entry1.getValue();
            }
            if (!totalSkills.containsKey(entry.getKey())) {
                totalSkills.put(entry.getKey(), sum);
            } else {
                totalSkills.put(entry.getKey(), totalSkills.get(entry.getKey()) + sum);
            }

        }
        totalSkills.entrySet().stream().sorted((a, b)->{
            int result = Integer.compare(b.getValue(), a.getValue());
            if (result == 0) {
                result =  a.getKey().compareTo(b.getKey());
            }
            return result;
        }).forEach(e->{
            Map<String, Integer> map1 = map.get(e.getKey());
            System.out.printf("%s: %d skill%n",e.getKey(), e.getValue());
            map1.entrySet().stream().sorted((a, b) ->{
                int result = Integer.compare(b.getValue(), a.getValue());
                if (result == 0) {
                    result = a.getKey().compareTo(b.getKey());
                }
                return result;
            }).forEach(a ->{
                System.out.printf("- %s <::> %d%n",a.getKey(),a.getValue());
            });
        });

    }
}