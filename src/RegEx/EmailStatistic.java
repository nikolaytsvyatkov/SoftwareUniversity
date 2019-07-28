package RegEx;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailStatistic {
    public static void main(String[] args) {
        Map<String, List<String>> map = new LinkedHashMap<>();
        Scanner input = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^(?<username>[A-Zaa-z]{5,})@(?<server>[a-z]{3,})(?<domain>(.com)|(.bg)|(.org))$");
        int n = Integer.parseInt(input.nextLine());
        for (int i = 0; i < n; i++) {
            String email = input.nextLine();
            Matcher matcher = pattern.matcher(email);
            if (matcher.find()) {
                String name = matcher.group("username");
                String server = matcher.group("server");
                String domain = matcher.group("domain");
                server += domain;
                List<String> list = map.get(server);
                if (list == null) {
                    list = new ArrayList<>();
                }
                if (!list.contains(name))
                    list.add(name);
                map.put(server, list);
            }
        }
        map.entrySet().stream().sorted((a, b) ->{
            return Integer.compare(b.getValue().size(), a.getValue().size());
        }).forEach(e->{
            System.out.printf("%s:%n",e.getKey());
            List<String> list = e.getValue();
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("### %s%n",list.get(i));
            }
        });
    }
}
