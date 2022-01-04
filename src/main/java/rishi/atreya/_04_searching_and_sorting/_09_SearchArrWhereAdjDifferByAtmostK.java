package rishi.atreya._04_searching_and_sorting;

public class _09_SearchArrWhereAdjDifferByAtmostK {
    static int search(int arr[], int targetNo, int k){
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == targetNo) return i;
            // Jump the difference between current array element and x We use
            // max here to make sure that i moves at-least one step ahead.
            i = i + Math.max(1, Math.abs(arr[i] - targetNo) / k);
        }
        System.out.println("number is " + "not present!");
        return -1;
    }

    public static void main(String[] args){
        int arr[] = { 2, 4, 5, 7, 7, 6 };
        int targetNo = 6;
        int k = 2;
        System.out.println("Element " + targetNo +
                " is present at index "
                + search(arr, targetNo, k));
    }
}
