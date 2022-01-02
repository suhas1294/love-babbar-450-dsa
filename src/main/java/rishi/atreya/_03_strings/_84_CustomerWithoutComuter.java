package rishi.atreya._03_strings;

public class _84_CustomerWithoutComuter {
    static int MAX_CHAR = 26;

    // n is number of computers in cafe. 'seq' is given sequence of customer entry, exit events
    static int runCustomerSimulation(int n, char []seq){
        char[] seen = new char[MAX_CHAR];
        int res = 0;
        int occupied = 0; // To keep track of occupied computers

        for (char c : seq) {
            // Find index of current character in seen[0...25]
            int ind = c - 'A';
            // If First occurrence of 'seq[i]'
            if (seen[ind] == 0) {
                seen[ind] = 1; // set the current character as seen
                // If number of occupied computers is less than
                // n, then assign a computer to new customer
                if (occupied < n) {
                    occupied++;
                    seen[ind] = 2; // Set the current character as occupying a computer
                } else { // Else this customer cannot get a computer, increment result
                    res++;
                }
            } else { // If this is second occurrence of 'seq[i]'
                // Decrement occupied only if this customer was using a computer
                if (seen[ind] == 2) occupied--;
                seen[ind] = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(runCustomerSimulation(2, "ABBAJJKZKZ".toCharArray()));
        System.out.println(runCustomerSimulation(3, "GACCBDDBAGEE".toCharArray()));
        System.out.println(runCustomerSimulation(3, "GACCBGDDBAEE".toCharArray()));
        System.out.println(runCustomerSimulation(1, "ABCBCA".toCharArray()));
        System.out.println(runCustomerSimulation(1, "ABCBCADEED".toCharArray()));
    }
}

/**
 * // seen[i] = 0, indicates that customer 'i' is not in cafe
 * // seen[1] = 1, indicates that customer 'i' is in cafe but computer is not assigned yet.
 * // seen[2] = 2, indicates that customer 'i' is in cafe and has occupied a computer.
 */