package Maps;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Demo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, Map<String, Integer>> map = new TreeMap<>();
        Map<String, Integer> totalPoints = new LinkedHashMap<>();
        boolean flag = false;
        while (true) {
            String command = input.nextLine();
            if (command.equals("Season end")) {
                break;
            }
            if (command.contains("->")) {
                String[] strings = command.split(" -> ");
                // name, position, skills
                Map<String, Integer> map1 = map.get(strings[0]);
                if (map1 == null) {
                    map1 = new TreeMap<>();
                }
                if (!map1.containsKey(strings[1])) {
                    map1.put(strings[1], Integer.parseInt(strings[2]));


                } else {
                    int current = Integer.parseInt(strings[2]);
                    if (current > map1.get(strings[1])) {
                        map1.put(strings[1], current);
                    }
                }
                if (!totalPoints.containsKey(strings[0])) {
                    totalPoints.put(strings[0], map1.get(strings[1]));
                } else {
                    totalPoints.put(strings[0],totalPoints.get(strings[0]) + map1.get(strings[1]));
                }
                map.put(strings[0],map1);
            } else {
                String[] strings = command.split(" vs ");
                if (totalPoints.containsKey(strings[0]) && totalPoints.containsKey(strings[1])) {
                    String player1 = strings[0];
                    String player2 = strings[1];
                    int skills1 = totalPoints.get(player1);
                    int skills2 = totalPoints.get(player2);
                    Map<String, Integer> map1 = map.get(player1);
                    Map<String, Integer> map2 = map.get(player2);
                    for (Map.Entry<String, Integer> entry : map1.entrySet()) {
                        String positon = entry.getKey();
                        for (Map.Entry<String, Integer> entry1 : map2.entrySet()) {
                            String position2 = entry1.getKey();
                            if (positon.equals(position2)) {
                                if (skills1 > skills2) {
                                    totalPoints.remove(player2);
                                    break;
                                } else if (skills1 < skills2) {
                                    totalPoints.remove(player1);
                                    break;
                                }
                            }
                        }
                    }

                }
            }
        }
        totalPoints.entrySet().stream().sorted((a, b) -> {
            int result  = Integer.compare(b.getValue(), a.getValue());
            if (result == 0) {
                result = a.getKey().compareTo(b.getKey());
            }
            return result;
        }).forEach(e -> {
            System.out.printf("%s: %d skill%n",e.getKey(),e.getValue());
            Map<String, Integer> map1 = map.get(e.getKey());
            map1.entrySet().stream().sorted((a, b)->{
                int result  = Integer.compare(b.getValue(), a.getValue());
                if (result == 0) {
                    result = a.getKey().compareTo(b.getKey());
                }
                return result;
            }).forEach(e1-> {
                System.out.printf("- %s <::> %d%n",e1.getKey(),e1.getValue());
            });
        });

    }
}
