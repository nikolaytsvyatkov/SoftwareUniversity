package FinalExamsFundamentalsModule;

import java.util.*;
import java.util.stream.Collectors;

public class PokemonEvolution {
    static class Evolution {
        private String type;
        private int index ;
        public Evolution( String type, int index) {
            this.type = type;
            this.index = index;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, List<Evolution>> map = new LinkedHashMap<>();
        //name, type, evolution
        while (true) {
            String commnad = input.nextLine();
            if (commnad.equals("wubbalubbadubdub")) {
                break;
            }
            if (commnad.contains(" -> ")) {
                String[] strings = commnad.split(" -> ");
                List<Evolution> list = map.get(strings[0]);
                if (list == null) {
                    list = new ArrayList<>();
                }
                Evolution evolution = new Evolution(strings[1], Integer.parseInt(strings[2]));
                list.add(evolution);
                map.put(strings[0], list);
            } else {
               if (map.containsKey(commnad)) {
                   System.out.printf("# %s%n",commnad);
                   List<Evolution> list = map.get(commnad);
                   for (int i = 0; i < list.size(); i++) {
                       System.out.printf("%s <-> %d%n",list.get(i).type, list.get(i).index);
                   }
               }
            }
        }
        map.entrySet().stream().forEach(e -> {
            System.out.printf("# %s%n", e.getKey());
            List<Evolution> list = map.get(e.getKey());
            list.stream().sorted((a,b) ->{
                return Integer.compare(b.index, a.index);
            }).forEach(a->{
                System.out.printf("%s <-> %d%n",a.type,a.index);
            });
        });

    }
}
