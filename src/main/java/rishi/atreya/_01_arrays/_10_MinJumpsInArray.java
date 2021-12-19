package rishi.atreya._01_arrays;

// Credits : https://discuss.geeksforgeeks.org/comment/b9489e962cbc6f2277ed96843427a5b4
public class _10_MinJumpsInArray {
    static int minJumps(int arr[]){
        int n = arr.length;
        int curMaxPos = 0, nextMaxPos = 0, jumpCnt = 0;
        for(int i=0; i<n; i++){
            if(i > curMaxPos) return -1; // break if current max is lesser than the index visited
            nextMaxPos = Integer.max(nextMaxPos,i+arr[i]); // update next max at every reachable step
            if(i == curMaxPos){
                curMaxPos = nextMaxPos; // update current max at the max index reached
                nextMaxPos = i; // reset the next max to current index
                if(i<n-1) jumpCnt++; // increment jumps if we are not at the last step
            }
        }
        return jumpCnt;
    }
    public static void main(String[] args) {
        //int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}; // expected 3
        //int[] arr = {1, 4, 3, 2, 6, 7}; // expected 2
        //int[] arr = {1, 2, 0, 0, 0, 5}; // expected -1
        int[] arr = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1}; // expected 4
        System.out.println(minJumps(arr));
    }
}
