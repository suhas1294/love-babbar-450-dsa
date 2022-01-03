package rishi.atreya._02_matrix;

public class _39_FindRowWithMaxOnes {
    static int rows = 4, cols = 4;
    static int rowWithMax1s(int mat[][]){
        int j, rowWithMax1s = 0; // Initialize first row as row with max 1s
        j = cols - 1;

        for (int i = 0; i < rows; i++) {
            // Move left until a 0 is found
            while (j >= 0 && mat[i][j] == 1) {
                j = j - 1; // Update the index of leftmost 1 seen so far
                rowWithMax1s = i; // Update max_row_index
            }
        }
        if(rowWithMax1s == 0 && mat[0][cols -1] == 0) return -1;
        return rowWithMax1s;
    }

    public static void main(String[] args){
        int mat[][] = { { 0, 0, 0, 1 },
                { 0, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 0, 0, 0, 0 } };
        System.out.println("Index of row with maximum 1s is "+ rowWithMax1s(mat));
    }
}
