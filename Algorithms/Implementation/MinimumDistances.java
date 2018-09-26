import java.util.HashMap;
import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class MinimumDistances {

    /**
     * Given an array of integers, finds the shortest distance between any two matching elements.
     * If there aren't any matching elements, return -1.
     * @param a Array of integers
     * @return Minimum distance between any two matching elements, or -1 if no matching elements exist
     */
    static int minimumDistances(int[] a) {
        // stores minimum distance
        int dist = -1;

        // stores values in a and the index that they were found at
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();

        for (int i = 0; i < a.length; i += 1) {
            if (h.containsKey(a[i])) {
                int currDist = i - h.get(a[i]);
                dist = (dist == -1 || currDist < dist) ? currDist : dist;
            }

            h.put(a[i], i);
        }

        return dist;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = minimumDistances(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();

        scanner.close();
    }
}
