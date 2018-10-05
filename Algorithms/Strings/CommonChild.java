import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class CommonChild {

    /**
     * Determines the length of the longest common child that can be
     * formed from the two given strings
     *
     * @param s1 String #1
     * @param s2 String #2
     * @return Length of the longest common child of s1 and s2
     */
    static int commonChild(String s1, String s2) {
        int len = s1.length();
        int[][] children = new int[len][len];

        for (int i = 0; i < len; i += 1) {
            for (int j = 0; j < len; j += 1) {
                int p1 = (i > 0) ? children[i - 1][j] : 0;
                int p2 = (j > 0) ? children[i][j - 1] : 0;
                int pmax = (i > 0 && j > 0) ? children[i - 1][j - 1] : 0;

                children[i][j] = (s1.charAt(i) == s2.charAt(j)) ? pmax + 1 : Math.max(p1, p2);
            }
        }

        return children[len - 1][len - 1];
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();

        scanner.close();
    }
}
