package rishi.atreya._04_searching_and_sorting;

public class _10_FindPairWithGivenDiff {
    // The function assumes that the array is sorted
    static boolean findPair(int arr[], int diff){
        int size = arr.length;
        int i = 0, j = 1; // Initialize positions of two elements
        while (i < size && j < size){
            if (i != j && (arr[j] - arr[i] == diff || arr[i] - arr[j] == diff)){
                System.out.printf("Pair Found: (%d, %d)\n", arr[i], arr[j]);
                return true;
            }
            else if (arr[j] - arr[i] < diff)
                j++;
            else
                i++;
        }
        return false; // No such pair
    }

    public static void main (String[] args){
        int arr[] = {1, 8, 30, 40, 100};
        int n = -60;
        findPair(arr,n);
    }
}
