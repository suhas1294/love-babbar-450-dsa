package rishi.atreya._04_searching_and_sorting;

public class _25_AllocateMinNoOfPages {
    // method to find minimum pages
    static int findPages(int arr[],  int noOfStudents){
        long sum = 0;
        if (arr.length < noOfStudents) return -1;
        for (int i = 0; i < arr.length; i++) { // Count total number of pages
            sum += arr[i];
        }
        // initialize start as 0 pages and end as total pages
        int start = 0, end = (int) sum;
        int result = Integer.MAX_VALUE;

        while (start <= end){
            // check if it is possible to distribute books by using mid is current minimum
            int mid = (start + end) / 2;
            if (isPossible(arr, noOfStudents, mid)){
                // update result to current distribution as it's the best we have found till now.
                result = mid;
                // as we are finding minimum and books are sorted so reduce end = mid -1 that means
                end = mid - 1;
            }else{ // means pages should be increased so update start = mid + 1
                start = mid + 1;
            }
        }
        return result; // at-last return minimum no. of  pages
    }

    // Utility method to check if current minimum value is feasible or not.
    static boolean isPossible(int arr[], int noOfStudents, int curr_min){
        int studentsRequired = 1;
        int curr_sum = 0;
        for (int i = 0; i < arr.length; i++){
            // check if current number of pages are greater than curr_min
            // that means we will get the result after mid no. of pages
            if (arr[i] > curr_min) return false;
            // count how many students are required to distribute curr_min pages
            if (curr_sum + arr[i] > curr_min){
                studentsRequired++;
                curr_sum = arr[i];
                if (studentsRequired > noOfStudents) return false;
            }else {
                curr_sum += arr[i];
            }
        }
        return true;
    }

    public static void main(String[] args){
        int arr[] = {12, 34, 67, 90}; //Number of pages in books
        int noOfStudents = 2; //No. of students
        System.out.println("Minimum number of pages = " + findPages(arr, noOfStudents));
    }
}
