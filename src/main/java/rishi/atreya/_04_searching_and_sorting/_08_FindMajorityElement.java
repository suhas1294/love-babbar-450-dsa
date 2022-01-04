package rishi.atreya._04_searching_and_sorting;


public class _08_FindMajorityElement {
    static void printMajority(int a[], int size){
        int cand = findCandidate(a, size); /* Find the candidate for Majority*/
        if (isMajority(a, size, cand))
            System.out.println(" " + cand + " ");
        else
            System.out.println("No Majority Element");
    }

    /* Function to find the candidate for Majority */
    static int findCandidate(int a[], int size){
        int maj_index = 0, count = 1;
        int i;
        for (i = 1; i < size; i++) {
            if (a[maj_index] == a[i]) {
                count++;
            }else {
                count--;
            }
            if (count == 0) {
                maj_index = i;
                count = 1;
            }
        }
        return a[maj_index];
    }

    // Function to check if the candidate occurs more than n/2 times
    static boolean isMajority(int a[], int size, int cand){
        int i, count = 0;
        for (i = 0; i < size; i++) {
            if (a[i] == cand) count++;
        }
        return count > size / 2;
    }

    public static void main(String[] args){
        int arr[] = new int[] { 1, 3, 3, 1, 2 };
        printMajority(arr, arr.length);
    }
}
