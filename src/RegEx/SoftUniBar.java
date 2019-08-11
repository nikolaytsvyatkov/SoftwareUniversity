package RegEx;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class SoftUniBar {




    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^%(?<name>[A-Z][a-z]*)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<count>[0-9]+)\\|[^|$%.]*?(?<price>[0-9]+\\.*[0-9]*)\\$$");

        double sum = 0;
        while (true) {
            String str = input.nextLine();
            if (str.equals("end of shift")) {
                System.out.printf("Total income: %.2f%n",sum);
                break;
            }
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()){
                String name = matcher.group("name");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double prise = Double.parseDouble(matcher.group("price"));

                System.out.printf("%s: %s - %.2f%n",name, product, count*prise);
                sum += count * prise;
            }


        }
    }
}





