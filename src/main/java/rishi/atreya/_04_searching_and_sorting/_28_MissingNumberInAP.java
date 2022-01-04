package rishi.atreya._04_searching_and_sorting;

// binary search
public class _28_MissingNumberInAP {

    static int findMissing(int arr[], int n){
        int diff = (arr[n - 1] - arr[0]) / n;
        return findMissingUtil(arr, 0, n - 1, diff);
    }

    static int findMissingUtil(int arr[], int low, int high, int diff){
        if (high <= low) return Integer.MAX_VALUE; // There must be two elements to find the missing
        int mid = low + (high - low) / 2;

        // The element just after the middle element is missing. The arr[mid+1] must exist,
        // because we return when (low == high) and take floor of (high-low)/2
        if (arr[mid + 1] - arr[mid] != diff) return (arr[mid] + diff);

        // The element just before mid is missing
        if (mid > 0 && arr[mid] -
                arr[mid - 1] != diff)
            return (arr[mid - 1] + diff);

        // If the elements till mid follow AP, then recur for right half
        if (arr[mid] == arr[0] + mid * diff) {
            return findMissingUtil(arr, mid + 1, high, diff);
        }

        // Else recur for left half
        return findMissingUtil(arr, low, mid - 1, diff);
    }

    public static void main (String[] args){
        int arr[] = {2, 4, 8, 10, 12, 14};
        System.out.println("The missing element is "+ findMissing(arr, arr.length));
    }
}

/*
    It assumes that there is exactly one missing element and may give incorrect
    result when there is no missing element or more than one missing elements.
    This function also assumes that the difference in AP is an integer.

    If exactly one element is missing,  then we can find difference of
    arithmetic progression using  following formula. Example, 2, 4, 6, 10, diff = (10-2)/4 = 2.
    The assumption in formula is that the difference is an integer.

    Binary search for the missing number using above calculated diff
*/