import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class HalloweenSale {

    /**
     * Determines the maximum number of games that can be bought during the sale
     * View problem for more details
     *
     * @param p Initial price of a game
     * @param d Cost reduction after purchasing each game
     * @param m Minimum price for games during the sale
     * @param s Amount of money in wallet
     * @return Maximum number of games that can be bought
     */
    static int howManyGames(int p, int d, int m, int s) {
        int gameCost = p;
        int numGames = 0;

        while(s - gameCost >= 0) {
            numGames += 1;
            s -= gameCost;

            if (gameCost > m) {
                gameCost = (gameCost - d < m) ? m : gameCost - d;
            }
        }

        return numGames;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] pdms = scanner.nextLine().split(" ");
        int p = Integer.parseInt(pdms[0]);
        int d = Integer.parseInt(pdms[1]);
        int m = Integer.parseInt(pdms[2]);
        int s = Integer.parseInt(pdms[3]);

        int answer = howManyGames(p, d, m, s);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();
        bufferedWriter.close();

        scanner.close();
    }
}
