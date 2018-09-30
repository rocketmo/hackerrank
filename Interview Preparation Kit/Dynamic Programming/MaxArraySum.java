import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Solution {

    /**
     * Finds the subset of non-adjacent elements in arr with the max sum
     * @param arr Array of integers
     * @return Max sum from subset
     */
    static int maxSubsetSum(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }

        // stores the max for each subset of arr
        int[] maxSums = new int[arr.length];
        maxSums[0] = arr[0];
        maxSums[1] = Math.max(arr[0], arr[1]);

        // finds the max for all subsets
        for (int i = 2; i < arr.length; i += 1) {
            maxSums[i] = Math.max(Math.max(maxSums[i - 1], maxSums[i - 2] + arr[i]), arr[i]);
        }

        return maxSums[arr.length - 1];
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();
        bufferedWriter.close();

        scanner.close();
    }
}
