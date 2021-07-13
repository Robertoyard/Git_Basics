import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;  // Import the Scanner class


public class minesweep {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner mineScan = new Scanner(System.in);
        int n = 0, m = 0;
        int counter = 0;
        int fieldCount = 1;
        int[][] field = new int[0][0];
        while (mineScan.hasNextLine()) {
            if (mineScan.hasNextInt()) {
                n = mineScan.nextInt();
                m = mineScan.nextInt();
                field = new int[n][m];
                counter = 0;
                mineScan.nextLine();
            } else {
                String mineLine = mineScan.nextLine();
                for (int i = 0; i < m; i++) {
                    if (mineLine.charAt(i) == '*') {
                        field[counter][i] = -1;
                    }
                }
                counter++;
                if (counter == n) {
                    calcField(field);
                    System.out.println("Field #" + (fieldCount++) + ":");
                    for (int i = 0; i < n; i++){
                        for (int j = 0; j < m; j++) {
                            if (field[i][j] == -1) {
                                System.out.print("*");
                            } else {
                                System.out.print(field[i][j]);
                            }
                        }
                        System.out.println();
                    }
                    System.out.println();
                }
            }

        }
    }

    private static void calcField(int[][] field) {
        for (int i = 0; i < field.length; i++){
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j] != -1) {
                    if (i > 0 && field[i-1][j] == -1){
                        field[i][j]++;
                    }
                    if (i > 0 && j > 0 && field[i-1][j-1] == -1){
                        field[i][j]++;
                    }
                    if (i > 0 && j < field[0].length - 1 && field[i-1][j+1] == -1){
                        field[i][j]++;
                    }
                    if (j > 0 && field[i][j-1] == -1){
                        field[i][j]++;
                    }
                    if (j < field[0].length - 1 && field[i][j+1] == -1) {
                        field[i][j]++;
                    }
                    if (i < field.length - 1 && j > 0 && field[i+1][j-1] == -1){
                        field[i][j]++;
                    }
                    if (i < field.length - 1 && field[i+1][j] == -1){
                        field[i][j]++;
                    }
                    if (i < field.length - 1 && j < field[0].length - 1 && field[i+1][j+1] == -1){
                        field[i][j]++;
                    }

                }
            }
        }
    }

}
