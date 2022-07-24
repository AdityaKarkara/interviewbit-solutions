package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class UniquePathsInGrid {
    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        int rows = A.size();
        int cols = A.get(0).size();

        // checking if the first cell has obstacle or not
        if (A.get(0).get(0) == 1)
            return 0;

        A.get(0).set(0, 1);
        System.out.println("Printing after first element");
        printGrid(A);

        // filling the values of first column

        for (int i = 1; i < cols; i++) {
            int value = A.get(0).get(i) == 0 && A.get(0).get(i - 1) == 1 ? 1 : 0;
            A.get(0).set(i, value);
        }

        System.out.println("Printing after first column");
        printGrid(A);

        // filling the values of first row

        for (int i = 1; i < rows; i++) {
            int value = A.get(i).get(0) == 0 && A.get(i - 1).get(0) == 1 ? 1 : 0;
            A.get(i).set(0, value);
        }

        System.out.println("Printing after first row");
        printGrid(A);

        // filling the rest of grid

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                int value = 0;
                if (A.get(i).get(j) == 0) {
                    int left = A.get(i - 1).get(j);
                    int up = A.get(i).get(j - 1);
                    value = left + up;
                }
                A.get(i).set(j, value);
                System.out.println("Printing after row: " + i);
                printGrid(A);
            }
        }

        return A.get(rows - 1).get(cols - 1);
    }

    private void printGrid(ArrayList<ArrayList<Integer>> grid) {
        System.out.println("[");
        for (ArrayList<Integer> row : grid) {
            System.out.print("[ ");
            StringBuilder rowStr = new StringBuilder();
            for (int element : row) {
                rowStr.append(element);
                rowStr.append(", ");
            }
            System.out.print(rowStr.substring(0, rowStr.length() - 2));
            System.out.println("]");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(0, 0)),
                new ArrayList<>(Arrays.asList(0, 0)),
                new ArrayList<>(Arrays.asList(0, 0)),
                new ArrayList<>(Arrays.asList(1, 0)),
                new ArrayList<>(Arrays.asList(0, 0))
        ));
        int uniquePaths = new UniquePathsInGrid().uniquePathsWithObstacles(A);
        System.out.println(uniquePaths);
    }
}
