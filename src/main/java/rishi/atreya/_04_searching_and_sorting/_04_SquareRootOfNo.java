package rishi.atreya._04_searching_and_sorting;

public class _04_SquareRootOfNo {
    // credits: https://medium.com/edureka/java-sqrt-method-59354a700571
    public static int sqrt2(int A){
        if (A == 0) return 0;
        if (A == 1) return 1;
        double t;
        double squareroot = A / 2;

        do {
            t = squareroot;
            squareroot = (t + (A / t)) / 2;
        }while ((t - squareroot) != 0);

        return (int)Math.floor(squareroot);
    }

    // using binary search  recursive way
    public static int sqrt(int A, int start, int end, int ans){
        if (A == 0 || A == 1) return A;
        int mid = (start + end)/2;
        if (start >= end) return ans;
        if (mid * mid == A) return mid;
        if (mid * mid < A) {
            ans = mid; // additional step in binary search to store intermediate ans
            return sqrt(A, mid+1, end, ans);
        }else {
            return sqrt(A, start, mid-1, ans);
        }
    }
}
