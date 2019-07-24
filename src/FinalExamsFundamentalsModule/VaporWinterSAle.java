package FinalExamsFundamentalsModule;


import java.util.*;

public class VaporWinterSAle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] strings = input.nextLine().split(", ");
        Map<String, Double> map = new LinkedHashMap<>();
        Map<String, List<String>> dlc = new LinkedHashMap<>();
        List<String> gameWithDLC = new ArrayList<>();
        for (int i = 0 ; i < strings.length; i++) {
            if (strings[i].contains("-")) {
                String[] str = strings[i].split("-");
                if (!map.containsKey(str[0])) {
                    map.put(str[0], Double.parseDouble(str[1]));
                }
            } else  if (strings[i].contains(":")) {
                String[] str = strings[i].split(":");
                if (map.containsKey(str[0])) {
                    map.put(str[0],map.get(str[0]) + map.get(str[0]) * 0.20);
                    List<String> list = dlc.get(str[0]);
                    if (list == null) {
                        list = new ArrayList<>();
                        list.add(str[1]);
                        list.add(Double.toString(map.get(str[0])));
                        gameWithDLC.add(str[0]);
                        dlc.put(str[0], list);
                    }
                }


            }
        }
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            if (dlc.containsKey(entry.getKey())) {
                List<String> list = dlc.get(entry.getKey());
                list.set(1, Double.toString( entry.getValue() - entry.getValue()*0.50));
                dlc.put(entry.getKey(), list);
                map.put(entry.getKey(), entry.getValue() - entry.getValue()*0.50);

            } else {
                map.put(entry.getKey(), entry.getValue() - entry.getValue()*0.20);

            }
        }
        dlc.entrySet().stream().sorted((a, b) -> {
            double a1 =Double.parseDouble(a.getValue().get(1));
            double b1 = Double.parseDouble(b.getValue().get(1));
            return Double.compare(a1,b1);
        }).forEach(e ->{
            System.out.printf("%s - %s - %.2f%n",e.getKey(),e.getValue().get(0), Double.parseDouble(e.getValue().get(1)));
        });
        map.entrySet().stream().sorted((a,b) ->{
            return Double.compare(b.getValue(), a.getValue());
        }).forEach(e -> {
            if (!gameWithDLC.contains(e.getKey())) {
                System.out.printf("%s - %.2f%n",e.getKey(), e.getValue());
            }
        });


    }
}
