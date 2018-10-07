import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class SpecialPalindromeAgain {

    /**
     * Finds the number of special palindromes in the given string, view problem for details
     *
     * @param n Length of string, s
     * @param s A string
     * @return The number of special palindrome substrings in s
     */
    static long substrCount(int n, String s) {
        long count = 0;

        for (int i = 0; i < n; i += 1){
            char first = s.charAt(i);
            int numOtherChars = 1;
            count += 1;

            for (int j = i + 1; j < n; j += 1) {
                char next = s.charAt(j);

                if (first == next) {
                    if (numOtherChars == 1) {
                        count += 1;
                    } else if ((j - i + 1) % 2 == 1) {
                        char mid = s.charAt(i + ((j - i) / 2));
                        if (next != mid) {
                            count += 1;
                            break;
                        }
                    }
                } else if (numOtherChars > 1) {
                    break;
                } else {
                    numOtherChars += 1;
                }
            }
        }

        return count;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();
        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
