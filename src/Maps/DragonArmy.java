package Maps;
import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, Map<String, List<Integer>>> map = new LinkedHashMap<>();
        int n = Integer.parseInt(input.nextLine());
        int health;// = 250;
        int damage;//= 45;
        int armor; // = 10;



        for (int i = 0; i < n; i++) {
            String str[] = input.nextLine().split(" ");
            //colour, name, damage, health, armor
            Map<String, List<Integer>> map1 = map.get(str[0]);
            health = 0;
            damage = 0;
            armor = 0;
            if (map1 == null) {
                map1 = new LinkedHashMap<>();
            }
            List<Integer> list = map1.get(str[1]);
            if (!str[2].equals("null")) {
                damage = Integer.parseInt(str[2]);
            } else {
                damage = 45;
            }
            if (!str[3].equals("null")) {
                health = Integer.parseInt(str[3]);
            } else {
                health = 250;
            }
            if (!str[4].equals("null")) {
                armor = Integer.parseInt(str[4]);
            } else {
                armor = 10;
            }
            if (list == null) {
                list = new ArrayList<>();

                list.add(damage);
                list.add(health);
                list.add(armor);
            } else {
                list.set(0,damage);
                list.set(1,health);
                list.set(2,armor);
            }
            map1.put(str[1], list);
            map.put(str[0], map1);

        }
        for (Map.Entry<String, Map<String, List<Integer>>> entry : map.entrySet()) {
            Map<String, List<Integer>> mapp = entry.getValue();
            System.out.printf("%s::",entry.getKey());
            int sumDamage = 0;
            int sumHealth = 0;
            int sumArmor = 0;
            for (Map.Entry<String, List<Integer>> entry1 : mapp.entrySet()) {

                List<Integer> list = entry1.getValue();
                sumDamage+= list.get(0);
                sumHealth += list.get(1);
                sumArmor += list.get(2);

            }
            System.out.printf("(%.2f/%.2f/%.2f)%n",(double)sumDamage/mapp.size(),(double)sumHealth/mapp.size(), (double)  sumArmor/mapp.size());
            mapp.entrySet().stream().sorted((a, b) -> a.getKey().compareTo(b.getKey())).forEach(e->{

                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",e.getKey(), e.getValue().get(0), e.getValue().get(1), e.getValue().get(2));
            });
        }
    }
}
