package FinalExamsFundamentalsModule;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String key = input.nextLine();

        Map<String, Integer> points = new LinkedHashMap<>();
        Map<String, Integer> goals = new LinkedHashMap<>();
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(1);
        while (true) {
            String team = input.nextLine();
            if (team.equals("final")) {
                break;
            }

                String[] strings = team.split(" ");
            int index1 = strings[0].indexOf(key);
            int index2 = strings[0].lastIndexOf(key);
                String team1 = strings[0].substring(index1 + key.length(), index2);
                team1 = team(team1);
            index1 = strings[1].indexOf(key);
            index2 = strings[1].lastIndexOf(key);
            String team2 = strings[1].substring(index1 + key.length(), index2);
            team2 = team(team2);
                String[] score = strings[2].split(":");
                int sc1 = Integer.parseInt(score[0]);
                int sc2 = Integer.parseInt(score[1]);
                if (!goals.containsKey(team1)) {
                    goals.put(team1, sc1);
                } else {
                    goals.put(team1, goals.get(team1) + sc1);
                }
                if (!goals.containsKey(team2)) {
                    goals.put(team2, sc2);
                } else {
                    goals.put(team2, goals.get(team2) + sc2);
                }
                if (sc1 > sc2) {
                    if (!points.containsKey(team1)) {
                        points.put(team1, 3);
                    } else {
                        points.put(team1, points.get(team1) + 3);
                    }
                    if (!points.containsKey(team2)) {
                        points.put(team2, 0);
                    } else {
                        points.put(team2, points.get(team2) + 0);
                    }
                } else if (sc2 > sc1) {
                    if (!points.containsKey(team2)) {
                        points.put(team2, 3);
                    } else {
                        points.put(team2, points.get(team2) + 3);
                    }
                    if (!points.containsKey(team1)) {
                        points.put(team1, 0);
                    } else {
                        points.put(team1, points.get(team1) + 0);
                    }
                } else if (sc1 == sc2) {
                    if (!points.containsKey(team1)) {
                        points.put(team1, 1);
                    } else {
                        points.put(team1, points.get(team1) + 1);
                    }
                    if (!points.containsKey(team2)) {
                        points.put(team2, 1);
                    } else {
                        points.put(team2, points.get(team2) + 1);
                    }
                }
            }
        System.out.println("League standings:");
        points.entrySet().stream().sorted((a, b) ->{
            int result = Integer.compare(b.getValue(), a.getValue());
            if (result == 0) {
                result = a.getKey().compareTo(b.getKey());
            }
            return result;
        }).forEach(e -> {
            System.out.printf("%d. %s %d%n",atomicInteger.getAndIncrement(), e.getKey(), e.getValue());
        });
        System.out.println("Top 3 scored goals:");
        goals.entrySet().stream().sorted((a, b) -> {
            int result = Integer.compare(b.getValue(), a.getValue());
            if (result == 0) {
                result = a.getKey().compareTo(b.getKey());
            }
            return result;
        }).limit(3).forEach(e -> {
            System.out.printf("- %s -> %d%n",e.getKey(),e.getValue());
        });
        }

    static  String team (String name) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            if (Character.isLetter(name.charAt(i))) {
                stringBuilder.append(name.charAt(i));
            }
        }
        stringBuilder.reverse();
        return stringBuilder.toString().toUpperCase();
    }
}
