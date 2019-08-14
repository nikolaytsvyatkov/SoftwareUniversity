package FinalExamsFundamentalsModule;

import java.util.Scanner;

public class BlackFlag {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int days = Integer.parseInt(input.nextLine());
        int dailyPlunder = Integer.parseInt(input.nextLine());
        double expectedPlunder = Integer.parseInt(input.nextLine());
        double plunder = 0;
        for (int i = 1; i <= days; i++) {
            plunder += dailyPlunder;
            if (i % 3 == 0) {
              plunder += (double) dailyPlunder / 2;
            }
            if (i % 5 == 0) {
                plunder -= plunder * 0.3;
            }
        }
        if (plunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.%n",plunder);
        } else {
            System.out.printf("Collected only %.2f%s of the plunder.%n",(100 * plunder) / expectedPlunder,"%");
        }
    }
}
