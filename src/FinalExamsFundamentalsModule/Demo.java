package FinalExamsFundamentalsModule;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String ,Integer> country = new LinkedHashMap<>();
        Map<String, Map<String, Integer>> map = new LinkedHashMap<>();
        while (true) {
            String command = input.nextLine();
            if (command.equals("END")) {
                break;
            }
            String[] strings = command.split(" -> ");
            if (!country.containsKey(strings[0])) {
                country.put(strings[0], Integer.parseInt(strings[2]));
            } else {
                country.put(strings[0], country.get(strings[0]) + Integer.parseInt(strings[2]));
            }
            Map<String, Integer> map1 = map.get(strings[0]);
            if (map1 == null) {
                map1 = new LinkedHashMap<>();
            }
            if (!map1.containsKey(strings[1])) {
                map1.put(strings[1], Integer.parseInt(strings[2]));
            } else {
                map1.put(strings[1], map1.get(strings[1]) + Integer.parseInt(strings[2]));
            }
            map.put(strings[0], map1);

        }
        country.entrySet().stream().sorted((a, b)->{
            return Integer.compare(b.getValue(), a.getValue());
        }).forEach(e ->{
            System.out.printf("%s: %d%n",e.getKey(),e.getValue());
            Map<String, Integer> map1 = map.get(e.getKey());
            map1.entrySet().stream().forEach(a->{
                System.out.printf(" -- %s -> %d%n",a.getKey(),a.getValue());
            });
        });
    }
}
