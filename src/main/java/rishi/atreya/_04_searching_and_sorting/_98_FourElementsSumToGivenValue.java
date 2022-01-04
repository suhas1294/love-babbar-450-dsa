package rishi.atreya._04_searching_and_sorting;

import lombok.AllArgsConstructor;

import java.util.HashMap;

public class _98_FourElementsSumToGivenValue {
    @AllArgsConstructor
    private static class pair { int first, second;}

    // The function finds four elements with given sum X
    static void findFourElements(int arr[], int n, int X){
        HashMap<Integer, pair> mp = new HashMap<>(); // Store sums of all pairs in a hash table
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                mp.put(arr[i] + arr[j], new pair(i, j));
            }
        }

        // Traverse through all pairs and search for X - (current pair sum).
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];
                if (mp.containsKey(X - sum)) {
                    // Making sure that all elements are distinct array elements
                    // and an element is not considered more than once.
                    pair p = mp.get(X - sum);
                    if (p.first != i && p.first != j
                            && p.second != i && p.second != j) {
                        System.out.print(
                                arr[i] + ", " + arr[j] + ", "
                                        + arr[p.first] + ", "
                                        + arr[p.second]);
                        return;
                    } // inner if end
                } // outer if end
            } // inner for end
        } // outer for end
    }

    public static void main(String[] args){
        int arr[] = { 10, 20, 30, 40, 1, 2 };
        int n = arr.length;
        int X = 91;
        findFourElements(arr, n, X);
    }
}
