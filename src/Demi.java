import java.util.*;

public class Demi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[][] matrix = new char[8][8];
        for (int i = 0; i < 8; i++) {
            String[] strings = input.nextLine().split(" ");
            for (int j = 0; j < 8; j++) {
                matrix[i][j] = strings[j].charAt(0);
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (matrix[i][j] == 'q') {
                    int quennPosition1 = i;
                    int quennPosition2 = j;
                    if ((horizontalBackward(matrix,quennPosition1,quennPosition2) && horizontalForward(matrix,quennPosition1,quennPosition2))
                    && verticalBackward(matrix, quennPosition1,quennPosition2) && verticalForward(matrix,quennPosition1,quennPosition2)
                    && diagonal1(matrix,quennPosition1,quennPosition2) && diagonal2(matrix, quennPosition1, quennPosition2)) {
                        System.out.println(quennPosition1 + " " + quennPosition2);
                        break;
                    }

                }
            }
        }

    }
    static boolean horizontalForward(char[][] matrix, int pos1, int pos2) {
        boolean flag = true;
        int i = pos1 + 1;

        while (i < 8 && i>=0 ) {
            if (matrix[i][pos2] == 'q') {
                return false;
            }
            i++;

        }

        return true;

    }
    static boolean horizontalBackward(char[][] matrix, int pos1, int pos2) {
        boolean flag = true;
        int i = pos1 - 1;

        while (i < 8 && i>=0 ) {
            if (matrix[i][pos2] == 'q') {
                return false;
            }
            i--;

        }

        return true;

    }
    static boolean verticalForward(char[][] matrix, int pos1, int pos2) {
        int j = pos2 + 1;
        while (j < 8 && j>=0 ) {
            if (matrix[pos1][j] == 'q') {
                return false;
            }
            j++;

        }

        return true;
    }
    static boolean verticalBackward(char[][] matrix, int pos1, int pos2) {
        int j = pos2 - 1;
        while (j < 8 && j>=0 ) {
            if (matrix[pos1][j] == 'q') {
                return false;
            }
            j--;

        }

        return true;
    }
    static boolean diagonal1 (char [][] matrix, int pos1, int pos2) {
        int j = pos2 - 1;
        int i = pos1 - 1;
        while (j < 8 && j>=0 && i >= 0 && i < 8) {
            if (matrix[i][j] == 'q') {
                return false;
            }
            j--;
            i--;

        }

        return true;
    }
    static boolean diagonal2 (char [][] matrix, int pos1, int pos2) {
        int j = pos2 + 1;
        int i = pos1 + 1;
        while (j < 8 && j>=0 && i >= 0 && i < 8) {
            if (matrix[i][j] == 'q') {
                return false;
            }
            j++;
            i++;

        }

        return true;
        //return true;
    }
}
