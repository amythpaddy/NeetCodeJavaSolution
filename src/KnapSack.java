import java.util.Arrays;

public class KnapSack {
    public static void main(String[] args) {
        System.out.println(new KnapsackProblem().Knapsack(new int[]{60, 100, 120}, 3, new int[]{10, 20, 30}, 3, 70));
    }

    static class KnapsackProblem {
        static int[][] dp;

        static int Knapsack(int profits[], int profitsLength, int weights[], int weightsLength, int capacity) {
            if (dp == null) {
                dp = new int[profitsLength][weightsLength];
                for (int i = 0; i < profitsLength; i++) {
                    for (int j = 0; j < weightsLength; j++) {
                        dp[i][j] = -1;
                    }
                }
            }
            if (weightsLength == 0 || capacity == 0)
                return 0;
            if (dp[profitsLength - 1][weightsLength - 1] != -1) {
                return dp[profitsLength - 1][weightsLength - 1];
            }
            if (weights[weightsLength - 1] > capacity) {
                dp[profitsLength - 1][weightsLength - 1] = Knapsack(profits, profitsLength - 1, weights, weightsLength - 1, capacity);
            } else {
                dp[profitsLength - 1][weightsLength - 1] = Math.max(profits[profitsLength - 1] + Knapsack(profits, profitsLength - 1, weights, weightsLength - 1, capacity - weights[weightsLength - 1]),
                        Knapsack(profits, profitsLength - 1, weights, weightsLength - 1, capacity));
            }
            // write your code here
            return dp[profitsLength - 1][weightsLength - 1];
        }
    }
}
