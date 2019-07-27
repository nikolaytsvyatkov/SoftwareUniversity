package FinalExamsFundamentalsModule;

import java.util.*;
import java.util.stream.Collectors;

public class ConcertNew {
    static class Band {
        private String name;
        private int playedTime;
        private List<String> list = new ArrayList<>();
        public Band(String name, int playedTime, List<String> list) {
            this.name = name;
            this.list = list;
            this.playedTime = playedTime;

        }

        public void setList(List<String> list) {
            this.list = list;
        }

        public void setPlayedTime(int playedTime) {
            this.playedTime = playedTime;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, Band> map = new LinkedHashMap<>();
        int totalTime = 0;
        while (true) {
            String command = input.nextLine();
            if (command.equals("start of concert")) {
                break;
            }
            if (command.contains("Add; ")) {
                command = command.replace("Add; ","");
                String bandName = command.substring(0, command.indexOf(";"));
                command = command.replace(command.substring(0, command.indexOf(";") + 2),"");
                String[] artist = command.split(", ");

                if (!map.containsKey(bandName)) {
                    Band band = new Band(bandName, 0,Arrays.stream(artist).collect(Collectors.toList()));
                    map.put(bandName, band);
                } else {
                    Band band = map.get(bandName);
                    List<String> list = band.list;
                    for (int i = 0; i < artist.length; i++) {
                        if (!list.contains(artist[i])) {
                            list.add(artist[i]);
                            band.setList(list);
                            map.put(bandName, band);
                        }

                    }


                }


            } else if (command.contains("Play; ")) {
                command = command.replace("Play; ","");
                String name = command.substring(0, command.indexOf(";"));
                int time = Integer.parseInt(command.substring(command.indexOf(";") + 2));
                totalTime += time;
                if (map.containsKey(name)) {
                    Band band = map.get(name);
                    band.setPlayedTime(band.playedTime + time);
                    map.put(name, band);
                } else {
                    List<String> list = new ArrayList<>();
                    Band band = new Band(name,time,list);
                    map.put(name, band);
                }
            }
        }
        String bandToPrint = input.nextLine();
        System.out.println("Total time: "+ totalTime);
        map.entrySet().stream().sorted((a, b) ->{
            int result = Integer.compare(b.getValue().playedTime,a.getValue().playedTime);
            if (result == 0) {
                result = a.getKey().compareTo(b.getKey());
            }
            return result;
        }).forEach(e -> {
            System.out.printf("%s -> %d%n", e.getKey(), e.getValue().playedTime);
        });
        Band band = map.get(bandToPrint);
        System.out.printf("%s%n",band.name);
        band.list.stream().forEach(e ->{
            System.out.printf("=> %s%n",e);
        });

    }
}
