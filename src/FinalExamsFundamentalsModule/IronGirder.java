package FinalExamsFundamentalsModule;

import java.util.*;

public class IronGirder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String,Integer> time = new LinkedHashMap<>();
        Map<String,Integer> passangers = new LinkedHashMap<>();
        //time, passengercount
        while (true) {
            String command = input.nextLine();
            if (command.equals("Slide rule")) {
                break;
            }
            if (command.contains(":ambush")) {
                command = command.replace(":ambush","");
                String[] strings = command.split("->");
                if (time.containsKey(strings[0])) {
                    time.put(strings[0], 0);
                }
                if (passangers.containsKey(strings[0])) {
                    passangers.put(strings[0], passangers.get(strings[0]) - Integer.parseInt(strings[1]));
                }

            } else {
                String townName = command.substring(0, command.indexOf(":"));
                command = command.replace(command.substring(0, command.indexOf(":") + 1),"");
                String[] strings = command.split("->");
                if (!time.containsKey(townName)) {
                    time.put(townName, Integer.parseInt(strings[0]));
                } else {
                    if (time.get(townName) == 0) {
                        time.put(townName, Integer.parseInt(strings[0]));
                    } else {
                        if (time.get(townName) > Integer.parseInt(strings[0])) {
                            time.put(townName, Integer.parseInt(strings[0]));
                        }
                    }

                }
                if (!passangers.containsKey(townName)) {
                    passangers.put(townName, Integer.parseInt(strings[1]));
                } else {
                    passangers.put(townName, passangers.get(townName) + Integer.parseInt(strings[1]));
                }
            }
        }
        time.entrySet().stream().sorted((a, b) ->{
            int result = Integer.compare(a.getValue(),  b.getValue());
            if (result == 0) {
                result = a.getKey().compareTo(b.getKey());
            }
            return result;
        }).forEach(e->{
            if (!(e.getValue() == 0 || passangers.get(e.getKey()) <= 0)) {
                System.out.printf("%s -> Time: %d -> Passengers: %d%n",e.getKey(), e.getValue(), passangers.get(e.getKey()));
            }
        });

    }
}
