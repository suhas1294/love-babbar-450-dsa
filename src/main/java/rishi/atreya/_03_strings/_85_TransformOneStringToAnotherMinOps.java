package rishi.atreya._03_strings;

public class _85_TransformOneStringToAnotherMinOps {
    public static int minOps(String str1, String targetStr){
        if(str1.length() != targetStr.length()) return -1;
        int i, j, res = 0;
        int count [] = new int [256];

        // count characters in A, subtract count for every character in B
        for(i = 0; i < str1.length(); i++){
            count[str1.charAt(i)]++;
            count[targetStr.charAt(i)]--;
        }

        // Check if all counts become 0
        for(i = 0; i < 256; i++)
            if(count[i] != 0) {
                return -1;
            }

        i = str1.length() - 1;
        j = targetStr.length() - 1;

        while(i >= 0){
            // If there is a mismatch, then keep incrementing result 'res'
            // until B[j] is not found in A[0..i]
            if(str1.charAt(i) != targetStr.charAt(j)) {
                res++;
            }else {
                j--;
            }
            i--;
        }
        return res;
    }

    public static void main(String[] args)
    {
        String A = "EACBD";
        String B = "EABCD";

        System.out.println("Minimum number of "
                + "operations required is "
                + minOps(A, B));
    }
}
