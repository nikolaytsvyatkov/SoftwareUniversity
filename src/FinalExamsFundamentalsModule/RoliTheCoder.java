package FinalExamsFundamentalsModule;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RoliTheCoder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(\\d+) #(?<name>[A-Za-z\\d]+) ?");
        Map<Integer, Map<String, List<String>>> map = new LinkedHashMap<>();
        while(true) {
            String command = input.nextLine();
            if (command.equals("Time for Code")) {
                break;
            }
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                String event = matcher.group("name");
                command = command.replace(matcher.group(),"");

                List<String> list = Arrays.stream(command.split(" ")).collect(Collectors.toList());
                if (list.contains("")){
                    list.remove("");
                }
                Map<String, List<String>> map1 = map.get(id);
                if (map1 == null) {
                    map1 = new LinkedHashMap<>();
                    List<String> participants = map1.get(event);
                    if (participants == null) {
                        participants = new ArrayList<>();
                    }
                    participants.addAll(list);
                    map1.put(event, participants);
                    map.put(id, map1);
                } else {
                    if (map1.containsKey(event)) {
                        List<String> participants = map1.get(event);
                        if (participants == null) {
                            participants = new ArrayList<>();
                        }
                        for (int i = 0; i < list.size(); i++) {
                            if (!participants.contains(list.get(i))) {
                                participants.add(list.get(i));
                            }
                        }
                        map1.put(event, participants);
                        map.put(id, map1);
                    }
                }

            }


        }
        map.entrySet().forEach(e -> {
            Map<String, List<String>> map1 = e.getValue();
            map1.entrySet().stream().sorted((a, b) -> {
                int result = Integer.compare(b.getValue().size(), a.getValue().size());
                /*if (result == 0) {
                    result = a.getKey().compareTo(b.getKey());
                }*/
                return result;
            }).forEach(a -> {
                System.out.printf("%s - %d%n",a.getKey(), a.getValue().size());
                List<String> lst = a.getValue();
                //Collections.sort(lst);
                for (String i : lst) {
                    System.out.println(i);
                }
            });
        });
    }
}
