package rishi.atreya._02_matrix;

public class _37_SearchElementInMatrix {
    static final int rows = 3;
    static final int cols = 4;

    //Divide and conquer approach
    static boolean searchMatrix(int matrix[][], int targetNo){
        int low = 0;
        int high = rows - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // if the element lies in the range of this row then call
            // 1-D binary search on this row
            if (targetNo >= matrix[mid][0]
                    && targetNo <= matrix[mid][cols - 1]) {
                return binarySearch1D(matrix[mid], targetNo);
            }

            // if the element is less then the starting element of that row then
            // search in upper rows else search in the lower rows
            if (targetNo < matrix[mid][0]) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return false; // if not found
    }

    // Basic binary search to find an element in a 1-D array
    static boolean binarySearch1D(int arr[], int K){
        int low = 0;
        int high = cols - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == K) return true;
            if (arr[mid] < K) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return false;
    }

    public static void main(String args[]){
        int matrix[][] = { { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 50 } };
        int K = 3;
        if (searchMatrix(matrix, K)) {
            System.out.println("Found");
        }else {
            System.out.println("Not found");
        }
    }
}
