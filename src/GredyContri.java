import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.Math;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class GreedyContri {
    static int N = 0;
    static int C = 0;
    static int optimal;
    static int canContribute;
    static int[] contribution;
    static int[] surplus;
    static int currentIndex = -1;
    static int totalContribution = 0;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        contribution = new int[N];
        surplus = new int[N];
        C = in.nextInt();
        optimal = C / N;
        canContribute = N;
        for (int i = 0; i < N; i++) {
            currentIndex = i + 1;
            ;
            int B = in.nextInt();
            if (B >= optimal) {
                surplus[i] = Math.min(B - optimal, C - totalContribution);
                contribution[i] = Math.min(optimal, C - totalContribution);
                totalContribution += contribution[i];
            } else {
                contribution[i] = B;
                surplus[i] = 0;
                totalContribution += contribution[i];
                int prevOptimal = optimal;
                updateOptimal(B);
                updateSurplus(prevOptimal, optimal);
            }
        }

        if (totalContribution != C)
            System.out.println("IMPOSSIBLE");
        else
            for (int c : contribution)
                System.out.println(c);
        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");


    }

    static int updateOptimal(int B) {

        int temp = optimal;
        if (canContribute > 1) {
            optimal = optimal + Math.divideExact((optimal - B), --canContribute);
        }
        return temp;
    }

    static void updateSurplus(int prevOptimal, int currOptimal) {
        if (canContribute > 0) {
            int increasedVal = currOptimal - prevOptimal;
            for (int i = 0; i < currentIndex; i++) {
                if (surplus[i] >= increasedVal) {
                    surplus[i] = surplus[i] - increasedVal;
                    contribution[i] = contribution[i] + increasedVal;
                } else {
                    if (surplus[i] > 0) {
                        contribution[i] = contribution[i] + surplus[i];
                        updateOptimal(surplus[i]);
                        surplus[i] = 0;
                        updateSurplus(currOptimal, optimal);
                    }
                }
            }
        }
    }
}