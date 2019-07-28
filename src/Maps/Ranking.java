package Maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ranking {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String,String> contest = new LinkedHashMap<>();
        Map<String, Map<String, Integer>> map = new TreeMap<>();
        //name
        int top = 0;
        String print = "";
        while (true) {
            String command = input.nextLine();
            if (command.equals("end of contests")) {
                break;
            }
            String[] strings = command.split(":");
            if (!contest.containsKey(strings[0])) {
                contest.put(strings[0], strings[1]);
            }


        }
        while (true) {
            String command = input.nextLine();
            if (command.equals("end of submissions")) {
                break;
            }
            String[] strings = command.split("=>");
            //contest, password, username, poinst
            if (contest.containsKey(strings[0]) && contest.get(strings[0]).equals(strings[1])) {
                 Map<String, Integer> map1 = map.get(strings[2]);
                 if (map1 == null) {
                     map1 = new LinkedHashMap<>();
                 }
                 if (!map1.containsKey(strings[0])) {
                     map1.put(strings[0], Integer.parseInt(strings[3]));
                 } else {
                     int currentPoint = map1.get(strings[0]);
                     if (currentPoint < Integer.parseInt(strings[3])) {
                         map1.put(strings[0], Integer.parseInt(strings[3]));
                     }
                 }
                 map.put(strings[2], map1);
            }

        }
        for (Map.Entry<String, Map<String, Integer>> entry : map.entrySet()) {
            Map<String, Integer> map1 = entry.getValue();
            int current = 0;
            for (Map.Entry<String, Integer> entry1 : map1.entrySet()) {
                current += entry1.getValue();
            }
            if (top < current) {
                top = current;
                print = entry.getKey();
            }
        }
        System.out.printf("Best candidate is %s with total %d points.%n",print,top);
        System.out.println("Ranking: ");
        map.entrySet().stream().forEach(e->{
            System.out.printf("%s%n",e.getKey());
            Map<String, Integer> map1 = e.getValue();
            map1.entrySet().stream().sorted((a,b)->{
                return Integer.compare(b.getValue(), a.getValue());
            }).forEach(a->{
                System.out.printf("#  %s -> %d%n",a.getKey(), a.getValue());
            });
        });


    }
}
