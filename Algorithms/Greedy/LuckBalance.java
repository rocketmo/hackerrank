import java.util.Comparator;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class LuckBalance {

    /**
     * Determines the maximum luck possible given the inputs
     * View problem for more details
     *
     * @param k Maximum number of important contests that can be lost
     * @param arr 2D array containing each contest's luck balance and important rating
     * @return Maximum possible luck balance after participating in all contests
     */
    static int luckBalance(int k, int[][] contests) {
        int maxLuck = 0;

        // sort from most luck to least luck
        Arrays.sort(contests, new Comparator<int[]>() {
           public int compare(int[] a, int[] b) {
               if (a[0] < b[0]) {
                   return 1;
               } else if (a[0] == b[0]) {
                   return 0;
               }

               return -1;
           }
        });

        for (int i = 0; i < contests.length; i += 1) {
            if (contests[i][1] == 0) {
                maxLuck += contests[i][0];
            } else {
                if (k > 0) {
                    k -= 1;
                    maxLuck += contests[i][0];
                } else {
                    maxLuck -= contests[i][0];
                }
            }
        }

        return maxLuck;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] nk = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();

        scanner.close();
    }
}
