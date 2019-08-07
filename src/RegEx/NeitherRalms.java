package RegEx;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NeitherRalms {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> names = Arrays.stream(input.nextLine().split("[, ]+")).collect(Collectors.toList());
        Pattern  name = Pattern.compile("[^\\d+\\+\\.\\-\\*\\/]");
        Pattern attack = Pattern.compile("[-?\\d+\\.?\\d+]");
        Map<String, List<Double>> map = new LinkedHashMap<>();
        for (String i : names) {
            Matcher matcher = name.matcher(i);
            Matcher matcher2 = attack.matcher(i);
            StringBuilder sb = new StringBuilder();
            double health = 0;
            double sum = 0;
            while (matcher.find()) {
                sb.append(matcher.group());
            }
            String str = sb.toString();
            for (int j = 0; j < str.length(); j++) {
                health += str.charAt(j);
            }
            while (matcher2.find()) {
                sum += Double.parseDouble(matcher2.group());

            }
            for (int j = 0; j < i.length(); j++) {
                if (i.charAt(j) == '*') {
                    sum *= 2;
                } else if (i.charAt(j) == '/') {
                    sum /= 2;
                }
            }
            List<Double> list = map.get(i);
            if (list == null) {
                list = new ArrayList<>();
                list.add(health);
                list.add(sum);
            }
            map.put(i,list);
        }
        map.entrySet().stream().sorted((a,b) ->
                a.getKey().compareTo(b.getKey())
        ).forEach(e -> {
            System.out.printf("%s - %.0f health, %.2f damage%n",e.getKey(),e.getValue().get(0), e.getValue().get(1));

        });
    }
}
