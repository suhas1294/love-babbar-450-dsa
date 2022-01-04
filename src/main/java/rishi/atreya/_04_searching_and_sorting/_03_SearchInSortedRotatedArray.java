package rishi.atreya._04_searching_and_sorting;

public class _03_SearchInSortedRotatedArray {
    static int search(int arr[], int left, int right, int targetNo){
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (arr[mid] == targetNo)
            return mid;
        if (arr[left] <= arr[mid]) { // If arr[l...mid] first subarray is sorted
            if (targetNo >= arr[left] && targetNo <= arr[mid]) {
                // As this subarray is sorted, we can quickly check if key lies in half or other half
                return search(arr, left, mid - 1, targetNo);
            }
            // If key not lies in first half subarray, Divide other half  into two sub arrays,
            // such that we can quickly check if key lies in other half
            return search(arr, mid + 1, right, targetNo);
        }
        // If arr[l..mid] first subarray is not sorted, then arr[mid... h] must be sorted subarray
        if (targetNo >= arr[mid] && targetNo <= arr[right]) {
            return search(arr, mid + 1, right, targetNo);
        }

        return search(arr, left, mid - 1, targetNo);
    }

    public static void main(String args[]){
        int arr[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
        int arr_len = arr.length;
        int targetNo = 6;
        int i = search(arr, 0, arr_len - 1, targetNo);
        if (i != -1)
            System.out.println("Index: " + i);
        else
            System.out.println("Key not found");
    }
}
