package rishi.atreya._03_strings;

public class _74_MinSwapsForBracetBalancing {
    static long swapCount(String s){
        char[] chars = s.toCharArray();
        // stores total number of Left and Right brackets encountered
        int countLeft = 0, countRight = 0;
        // swap stores the number of swaps required
        // imbalance maintains the number of imbalance pair
        int swap = 0 , imbalance = 0;

        for(int i =0; i< chars.length; i++){
            if(chars[i] == '['){
                countLeft++; // increment count of Left bracket
                if(imbalance > 0){
                    swap += imbalance; // last swap count + total no imbalanced brackets
                    imbalance--; // imbalance solved, so decrement
                }
            } else if(chars[i] == ']' ){
                countRight++; // increment count of Right bracket
                // imbalance is reset to current difference between Left and Right brackets
                imbalance = (countRight-countLeft);
            }
        }
        return swap;
    }

    public static void main(String[] args) {
        String s = "[]][][";
        System.out.println(swapCount(s) );

        s = "[[][]]";
        System.out.println(swapCount(s) );
    }
}
