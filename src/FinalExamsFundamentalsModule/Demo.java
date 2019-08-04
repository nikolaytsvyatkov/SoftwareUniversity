package FinalExamsFundamentalsModule;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] delimeters = input.nextLine().split(" ");
        Map<String, String> map = new LinkedHashMap<>();
        Map<String, Integer> coffeQuantity = new LinkedHashMap<>();
        Map<String, Integer> coffeDrinking = new LinkedHashMap<>();
        while (true) {
            String info = input.nextLine();
            if (info.equals("end of info")) {
                break;
            }
            if (info.contains(delimeters[0])) {
                String name = info.substring(0 , info.indexOf(delimeters[0]));
                String coffeType = info.substring(info.indexOf(delimeters[0]) + delimeters[0].length());
                if (!map.containsKey(name)) {
                    map.put(name, coffeType);
                }
            } else if (info.contains(delimeters[1])) {
                String[] str = info.split(delimeters[1]);
                if (!coffeQuantity.containsKey(str[0])) {
                    coffeQuantity.put(str[0], Integer.parseInt(str[1]));
                } else {
                    coffeQuantity.put(str[0], coffeQuantity.get(str[0]) + Integer.parseInt(str[1]));
                }
            }
        }
        while (true) {
            String information = input.nextLine();
            if (information.equals("end of week")) {
                break;
            }
            String[] strings = information.split(" ");
            String name = strings[0];
            int qunatity = Integer.parseInt(strings[1]);
            if (!coffeDrinking.containsKey(name)) {
                coffeDrinking.put(name, qunatity);
            } else {
                coffeDrinking.put(name, coffeDrinking.get(name) + qunatity);
            }
        }
        for (Map.Entry<String, Integer> entry : coffeDrinking.entrySet()) {
            String name = entry.getKey();
            if (map.containsKey(name)) {
                String coffeType = map.get(name);
                if (coffeQuantity.containsKey(coffeType)) {
                    coffeQuantity.put(coffeType, coffeQuantity.get(coffeType) - entry.getValue());
                }
                if (coffeQuantity.get(coffeType) <= 0) {
                    System.out.println("Out of " + coffeType);
                }
            }
        }


    }

}
