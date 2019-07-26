package FinalExamsFundamentalsModule;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MeTubeStatistics {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, Integer> views = new LinkedHashMap<>();
        Map<String, Integer> likes = new LinkedHashMap<>();
        while (true) {
            String str = input.nextLine();
            if (str.equals("stats time")) {
                break;
            }
            if (str.contains("-")) {
                String[] strings = str.split("-");
                if (!views.containsKey(strings[0])) {
                    views.put(strings[0], Integer.parseInt(strings[1]));
                } else {
                    views.put(strings[0], views.get(strings[0]) + Integer.parseInt(strings[1]));
                }
                if (!likes.containsKey(strings[0])) {
                    likes.put(strings[0], 0);
                }
            } else if (str.contains("dislike:")) {
                str = str.replace("dislike:","");
                if (likes.containsKey(str))
                    likes.put(str, likes.get(str) - 1);
            } else if (str.contains("like:")) {
                str = str.replace("like:","");
                if (likes.containsKey(str))
                    likes.put(str, likes.get(str) + 1);
            }
        }
        String sort = input.nextLine();
        if (sort.equals("by views")) {
            views.entrySet().stream().sorted((a,b) ->{
                return Integer.compare(b.getValue(), a.getValue());
            }).forEach(e ->{
                System.out.printf("%s - %d views - %d likes%n",e.getKey(),e.getValue(),likes.get(e.getKey()));
            });
        } else if (sort.equals("by likes")) {
            likes.entrySet().stream().sorted((a, b) ->{
                return Integer.compare(b.getValue(), a.getValue());
            }).forEach(e -> {
                System.out.printf("%s - %d views - %d likes%n",e.getKey(), views.get(e.getKey()), e.getValue());
            });
        }
    }
}
