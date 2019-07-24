package RegEx;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BarIncome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Pattern name = Pattern.compile("%[A-Z][a-z]+%");
        Pattern product = Pattern.compile("<[A-Za-z]+>");
        Pattern count = Pattern.compile("\\|\\d+\\|");
        Pattern prise = Pattern.compile("\\d+.?\\d+\\$");


        while (true) {
            String str = input.nextLine();
            if (str.equals("end of shift")) {
                break;
            }
            Matcher name1 = name.matcher(str);
            while (name1.find()) {
                String nam = name1.group().replaceAll("%","");
                // String prod =
                // System.out.printf();
            }
        }
    }
}

