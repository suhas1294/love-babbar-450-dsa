package rishi.atreya._03_strings;

// ref: https://www.programiz.com/dsa/rabin-karp-algorithm
public class _63_RabinKarpAlgo {

    public final static int d = 10;
    static void search(String pattern, String txt, int q) {
        int m = pattern.length();
        int n = txt.length();
        int i, j;
        int p = 0;
        int t = 0;
        int h = 1;

        for (i = 0; i < m - 1; i++)
            h = (h * d) % q;

        // Calculate hash value for pattern and text
        for (i = 0; i < m; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        // Find the match
        for (i = 0; i <= n - m; i++) {
            if (p == t) {
                for (j = 0; j < m; j++) {
                    if (txt.charAt(i + j) != pattern.charAt(j)) break;
                }
                if (j == m) System.out.println("Pattern found at pos: " + (i + 1));
            }

            if (i < n - m) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + m)) % q;
                if (t < 0) t = (t + q);
            }

        }
    }

    public static void main(String[] args) {
        String txt = "ABCCDDAEFG";
        String pattern = "CDD";
        int q = 13;
        search(pattern, txt, q);
    }
}

/**
 * Input:  txt[] =  "AABAACAADAABAABA"
 *         pat[] =  "AABA"
 * Output: Pattern found at index 0
 *         Pattern found at index 9
 *         Pattern found at index 12
 */