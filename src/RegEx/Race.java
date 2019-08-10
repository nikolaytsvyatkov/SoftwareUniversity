package RegEx;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, Integer> map = new TreeMap<>();
        Pattern pattern = Pattern.compile("[A-Za-z]+");
        Pattern pattern1 = Pattern.compile("\\d");
        String string = input.nextLine();
        List<String> list = Arrays.stream(string.split(",\\s+")).collect(Collectors.toList());
        while (true) {
            String str = input.nextLine();
            if (str.equals("end of race")) {
                break;
            }

            Matcher matcher = pattern.matcher(str);
            Matcher matcher1 = pattern1.matcher(str);
            int sum = 0;
            StringBuilder sb = new StringBuilder();
            while (matcher.find()) {
                sb.append(matcher.group());
            }
            String s = sb.toString();
            while (matcher1.find()) {
                sum += Integer.parseInt(matcher1.group());
            }
            if (list.contains(s)) {
                if (!map.containsKey(s)) {
                    map.put(s, sum);
                } else {
                    map.put(s, map.get(s) + sum);
                }
            }

        }
        int count =0;
        List<String> end = new ArrayList<>();
        map.entrySet().stream().sorted((a, b) -> {
            return  Integer.compare(b.getValue(), a.getValue());
        }).forEach(e->{
            end.add(e.getKey());
        });
        System.out.println("1st place: "+end.get(0));
        System.out.println("2nd place: "+end.get(1));
        System.out.println("3rd place: "+end.get(2));
    }
}
