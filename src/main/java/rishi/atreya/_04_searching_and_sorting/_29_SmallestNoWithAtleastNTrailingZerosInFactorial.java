package rishi.atreya._04_searching_and_sorting;

// Smallest number with at least n trailing zeroes in factorial
public class _29_SmallestNoWithAtleastNTrailingZerosInFactorial {

    static int findNum(int n){
        // If n equal to 1, return 5. since 5! = 120.
        if (n==1) return 5;
        int low = 0;
        int high = 5 * n;
        while (low < high){ // Binary Search.
            int mid = (low + high) >> 1;
            if (check(mid, n)) {// Checking if mid's factorial  contains n trailing zeroes.
                high = mid;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }

    static boolean check(int p, int n){
        int temp = p, count = 0, f = 5;
        while (f <= temp){
            count += temp / f;
            f = f * 5;
        }
        return (count >= n);
    }

    public static void main (String[] args){
        int n = 6;
        System.out.println(findNum(n));
    }
}
