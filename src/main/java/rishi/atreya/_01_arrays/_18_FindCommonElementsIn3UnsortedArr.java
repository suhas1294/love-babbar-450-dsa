package rishi.atreya._01_arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class _18_FindCommonElementsIn3UnsortedArr {
    ArrayList<Integer> commonElements(int A[], int B[], int C[]){
        Set<Integer> ABCIntersection = new HashSet<>();
        Set<Integer> BIntersectionA = new HashSet<>();
        int n1 = A.length, n2 = B.length, n3 = C.length;

        if(A.length > 0 && B.length > 0 && C.length > 0){
            Set<Integer> AUnique = new HashSet<>();
            for(int i = 0; i < n1; i++)
                AUnique.add(A[i]);
            for(int i = 0; i < n2;i ++)
                if(AUnique.contains(B[i])) BIntersectionA.add(B[i]);
            for(int i = 0; i< n3; i++)
                if(BIntersectionA.contains(C[i])) ABCIntersection.add(C[i]);
        }
        ArrayList<Integer> setToListResult= new ArrayList<>(ABCIntersection);
        Collections.sort(setToListResult);
        return setToListResult;
    }
    public static void main(String[] args) {

    }
}
