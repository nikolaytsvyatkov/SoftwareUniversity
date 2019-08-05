package RegEx;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
public class ExtractMeils {





    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        Pattern pattern = Pattern.compile("\\b[A-Za-z\\d]+([._-][A-Za-z\\d]+)*@([A-Za-z\\-]+)\\.([A-Za-z\\-]+)(\\.[A-Za-z\\-]+)*");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

    }


}

