import java.util.Arrays;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class GreedyContri2 {
    static int N = 0;
    static int C = 0;
    static int[] contribution;
    static int[] budget;
    static int totalContribution = 0;
    static int collection = 0;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        C = in.nextInt();
        budget = new int[N];
        contribution = new int[N];
        for (int i = 0; i < N; i++) {
            int B = in.nextInt();
            budget[i] = B;
            totalContribution += B;
        }

        if (totalContribution < C)
            System.out.println("IMPOSSIBLE");
        else {
            while (collection != C) {
                for (int i = 0; i < budget.length; i++) {
                    if (budget[i] > 0 && collection != C) {
                        budget[i]--;
                        contribution[i]++;
                        collection++;
                    }
                }
            }
            Arrays.sort(contribution);
            for (int c : contribution)
                System.out.println(c);

        }
        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");


    }
}