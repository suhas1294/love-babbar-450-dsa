package rishi.atreya._04_searching_and_sorting;
import java.util.Scanner;
// question: https://www.spoj.com/problems/PRATA/
// This is one of the standard problem of binary search.
// Similar Question:Book Allocation Problem (GFG) , Aggressive cow (spoj), Prata and roti (spoj)

public class _118_PrataRotiPrata {

    static boolean isPossible(int p, int[] cook, int n, int mid){
        int cnt = 0;
        for(int i=0;i<n;i++){
            int c = 0; //for each cook count the pratas
            int time = mid;
            int perpratas = cook[i]; // time taken to cook each pratas by ith cook
            while(time > 0){
                time = time - perpratas;
                if( time >= 0){
                    c += 1;
                    perpratas  += cook[i];
                }
            }
            cnt += c;
            if(cnt >= p) return true;
        }

        return false;
    }

    static int minTime(int p, int[] cook, int n){
        int s = 0, e = 10000007;
        int mid,ans=-1;
        while(s<=e){
            mid = (s+e)/2;
            if(isPossible(p,cook,n,mid)){
                ans = mid;
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t < 0){
            int p = scanner.nextInt();
            int n = scanner.nextInt();
            int[] cook = new int[n];
            for(int i=0; i<n; i++)
                cook[i] = scanner.nextInt();

            System.out.println(minTime(p,cook,n));
        }
    }
}

// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/discuss/1548622/java-binary-search-solution
// https://github.com/atulrulers/spoj/blob/master/PRATA.cpp