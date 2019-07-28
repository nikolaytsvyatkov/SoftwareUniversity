package FinalExamsFundamentalsModule;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HornetAssault {
    static  class Legion {
        private int lastActivity;
        private String SolderType;
        private int solderCount;
        public Legion( int activity, String type, int count) {
            this.lastActivity = activity;
            this.SolderType = type;
            this.solderCount  = count;

        }

        public void setLastActivity(int lastActivity) {
            this.lastActivity = lastActivity;
        }

        public void setSolderCount(int solderCount) {
            this.solderCount = solderCount;
        }

        public void setSolderType(String solderType) {
            this.SolderType = solderType;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        Map<String,Long> activity = new LinkedHashMap<>();
        Map<String, Map<String, Long>> legionMap = new LinkedHashMap<>();
        Map<String, Long> print = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] command = input.nextLine().split(" -> ");
            String[] str = command[0].split(" = ");
            long activ = Long.parseLong(str[0]);
            String name = str[1];
            String[] strings = command[1].split(":");
            String type = strings[0];
            long count = Long.parseLong(strings[1]);
            if (!activity.containsKey(name)) {
                activity.put(name, activ);
            } else {
                long current = activity.get(name);
                if (current < activ){
                    activity.put(name, activ);
                }
            }
            Map<String, Long> map1 = legionMap.get(name);
            if (map1 == null) {
                map1 = new LinkedHashMap<>();
            }
            if (!map1.containsKey(type)) {
                map1.put(type, count);
            } else {
                map1.put(type, map1.get(type) + count);
            }
            legionMap.put(name, map1);





        }
        String command = input.nextLine();
        if (command.contains("\\")) {
            String[] strings = command.split("\\\\");
            activity.entrySet().stream().forEach(e->{
                if (e.getValue() < Long.parseLong(strings[0])){
                    Map<String, Long> map1 = legionMap.get(e.getKey());
                    map1.entrySet().stream().sorted((a,b) ->{
                        return Long.compare(b.getValue(), a.getValue());
                    }).forEach(a->{
                        if (a.getKey().equals(strings[1])) {

                            print.put(e.getKey(), a.getValue());
                        }
                    });

                }
            });
            print.entrySet().stream().sorted((a,b)->Long.compare(b.getValue(), a.getValue())).forEach(e->{
                System.out.printf("%s -> %d%n",e.getKey(), e.getValue());
            });
        } else {
            activity.entrySet().stream().sorted((a,b)->{
                return Long.compare(b.getValue(), a.getValue());
            }).forEach(e->{
                Map<String, Long> map = legionMap.get(e.getKey());
                map.entrySet().forEach(a->{
                    if (a.getKey().equals(command)) {
                        System.out.printf("%d : %s%n",e.getValue(),e.getKey());
                    }
                });
            });
        }

    }
}
