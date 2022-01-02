package rishi.atreya._03_strings;

public class _73_NumberOfFlipsToMakeBinaryAlternate {
    public static int minFlipToMakeStringAlternate(String str){
        //  return minimum of following two
        //  1) flips when alternate string starts with 0
        //  2) flips when alternate string starts with 1
        return Math.min(
                getFlipWithStartingCharcter(str, '0'),
                getFlipWithStartingCharcter(str, '1')
        );
    }

    //  Utility method to get minimum flips when
    //  alternate string starts with expected char
    public static int getFlipWithStartingCharcter(String str, char expected){
        int flipCount = 0;
        for (int i = 0; i < str.length(); i++){
            //  if current character is not expected, increase flip count
            if (str.charAt(i) != expected) flipCount++;
            //  flip expected character each time
            expected = flip(expected);
        }
        return flipCount;
    }

    public static char flip(char ch){
        return (ch == '0') ? '1' : '0';
    }

    public static void main(String[] args) {
        String str = "0001010111";
        System.out.println(minFlipToMakeStringAlternate(str));
    }
}
