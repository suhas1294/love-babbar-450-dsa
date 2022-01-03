package rishi.atreya._02_matrix;

import java.util.HashMap;
import java.util.Map;

public class _45_CommonElementsInAllRowsInMatrix {
    static int rows = 4;
    static int cols = 5;

    static void printCommonElements(int mat[][]){
        Map<Integer,Integer> mp = new HashMap<>();
        for (int j = 0; j < cols; j++) { // initialize 1st row elements with value 1
            mp.put(mat[0][j], 1);
        }

        for (int i = 1; i < rows; i++){
            for (int j = 0; j < cols; j++){
                // If element is present in the map and
                // is not duplicated in current row.
                if (mp.get(mat[i][j]) != null && mp.get(mat[i][j]) == i){
                    // we increment count of the element in map by 1
                    mp.put(mat[i][j], i + 1);
                    if (i == rows - 1) { // If this is last row
                        System.out.print(mat[i][j] + " ");
                    } // inner if end
                } // outer if end
            } // inner loop end
        } // outer loop end
    }

    public static void main(String[] args){
        int mat[][] = {
                        {1, 2, 1, 4, 8},
                        {3, 7, 8, 5, 1},
                        {8, 7, 7, 3, 1},
                        {8, 1, 2, 7, 9},
                };
        printCommonElements(mat);
    }
}
