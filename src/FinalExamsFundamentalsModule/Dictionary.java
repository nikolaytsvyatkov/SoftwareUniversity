package FinalExamsFundamentalsModule;

import java.util.*;
import java.util.stream.Collectors;

public class Dictionary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] string = input.nextLine().split(" \\| ");
        Map<String, List<String>> map = new TreeMap<>();
        for (int i = 0; i < string.length; i++) {
            String key = string[i].substring(0, string[i].indexOf(":"));
            String defenition = string[i].substring(string[i].indexOf(":") + 2);
            List<String> list = map.get(key);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(defenition);
            list = list.stream().sorted((a, b) -> (Integer.compare(b.length(), a.length()))).collect(Collectors.toList());
            map.put(key, list);


        }
        List<String> words = Arrays.stream(input.nextLine().split(" \\| ")).collect(Collectors.toList());
        for (int i = 0; i < words.size(); i++) {
            if (map.containsKey(words.get(i))) {
                System.out.printf("%s%n",words.get(i));
                List<String> list = map.get(words.get(i));
                for (int j = 0; j < list.size(); j++) {
                    System.out.printf("-%s%n",list.get(j));
                }
            }
        }
        String command = input.nextLine();
        if (command.equals("End")) {

        } else if (command.equals("List")) {
            map.entrySet().stream().forEach(e -> {
                System.out.printf("%s ",e.getKey());
            });
        }

    }
}
