package RegEx;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PostOffice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> list = Arrays.stream(input.nextLine().split("\\|")).collect(Collectors.toList());
        Map<Character, Integer> map = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();
        Pattern capLetter = Pattern.compile("([#$%*&])([A-Z]+)(\\1)");
        Matcher capLetter1 = capLetter.matcher(list.get(0));
        List<String> words = new ArrayList<>();
        if (capLetter1.find()) {
            sb.append(capLetter1.group(2));
            String letters = sb.toString();
            for (int i = 0; i < letters.length(); i++) {
                map.put(letters.charAt(i), 0);
            }
        }
        Pattern asciCode = Pattern.compile("(\\d\\d):(\\d\\d)");
        Matcher asciCode1 = asciCode.matcher(list.get(1));
        while (asciCode1.find()) {
            int code = Integer.parseInt(asciCode1.group(1));
            int lenght = Integer.parseInt(asciCode1.group(2));
            char ch = (char)code;
            if (map.containsKey(ch) ) {
                map.put(ch,  lenght + 1);
            }
        }
        Pattern last = Pattern.compile(" ?\\b([A-Z][^\\s]+)\\b ?");
        Matcher last1 = last.matcher(list.get(2));
        while (last1.find()) {
            words.add(last1.group(1));
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            for (int i = 0; i < words.size(); i++) {
                String ligit = words.get(i);
                if (ligit.charAt(0) == entry.getKey() && ligit.length() == entry.getValue()) {
                    System.out.println(ligit);
                }
            }
        }


    }
}

