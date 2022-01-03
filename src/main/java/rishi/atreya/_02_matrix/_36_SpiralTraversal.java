package rishi.atreya._02_matrix;

public class _36_SpiralTraversal {
    static void spiralPrint(int endRowIdx, int endColIdx, int arr[][]){
        int i, startRowIdx = 0, startColIdx = 0;
        while (startRowIdx < endRowIdx && startColIdx < endColIdx) {
            // Print the first row from the remaining rows
            for (i = startColIdx; i < endColIdx; ++i) {
                System.out.print(arr[startRowIdx][i] + " ");
            }
            startRowIdx++;

            // Print the last column from the remaining columns
            for (i = startRowIdx; i < endRowIdx; ++i) {
                System.out.print(arr[i][endColIdx - 1] + " ");
            }
            endColIdx--;

            // Print the last row from the remaining rows */
            if (startRowIdx < endRowIdx) {
                for (i = endColIdx - 1; i >= startColIdx; --i) {
                    System.out.print(arr[endRowIdx - 1][i] + " ");
                }
                endRowIdx--;
            }

            // Print the first column from the remaining
            // columns */
            if (startColIdx < endColIdx) {
                for (i = endRowIdx - 1; i >= startRowIdx; --i) {
                    System.out.print(arr[i][startColIdx] + " ");
                }
                startColIdx++;
            }
        }
    }

    // Driver Code
    public static void main(String[] args){
        int row = 3;
        int col = 6;
        int arr[][] = { { 1, 2, 3, 4, 5, 6 },
                { 7, 8, 9, 10, 11, 12 },
                { 13, 14, 15, 16, 17, 18 } };

        // Function Call
        spiralPrint(row, col, arr);
    }
}
