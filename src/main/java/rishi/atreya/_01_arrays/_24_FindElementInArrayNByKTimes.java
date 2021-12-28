package rishi.atreya._01_arrays;

class _24_Element {
    int value;
    int count;
    public _24_Element(){this.count = 0;}
}

public class _24_FindElementInArrayNByKTimes {
    static void moreThanNdK(int arr[], int arr_len, int k) {
        if (k < 2) return; // k must be greater than 1 to get some output
        _24_Element[] temp = new _24_Element[k - 1];
        for (int i = 0; i < k - 1; i++) temp[i] = new _24_Element();

        for (int i = 0; i < arr_len; i++) {
            int j;
            //If arr[i] is already present in the element count array, then increment its count
            for (j = 0; j < k - 1; j++){
                if (temp[j].value == arr[i]) {
                    temp[j].count += 1;
                    break;
                }
            }
            // If arr[i] is not present in temp[]
            if (j == k - 1) {
                int l;
                // If there is position available in temp[], then place arr[i] i
                // the first available position and set count as 1
                for (l = 0; l < k - 1; l++){
                    if (temp[l].count == 0){
                        temp[l].value = arr[i];
                        temp[l].count = 1;
                        break;
                    }
                }
                // If all the position in the temp[] are filled, then decrease count of every element by 1
                if (l == k - 1)
                    for (l = 0; l < k-1; l++)
                        temp[l].count -= 1;
            }
        }

        //Step 3: Check actual counts of potential candidates in temp[]
        for (int i = 0; i < k - 1; i++){
            int actualCount = 0;
            for (int j = 0; j < arr_len; j++)
                if (arr[j] == temp[i].value)
                    actualCount++;

            if (actualCount > arr_len / k) // If actual count is more than n/k, then print it
                System.out.print("Number:" +  temp[i].value + " Count:" +  actualCount +"\n");
        }
    }

    public static void main(String[] args) {
        int[] arr1 = { 3, 1, 2, 2, 1, 2, 3, 3};
        int n = arr1.length;
        int k = 4;
        moreThanNdK(arr1, n, k);
    }
}
