package app;

import java.util.Arrays;

public class BruteForceAlgorithm {

    public static int[] BruteForceAlgorithm(int[] seq) {
        int maxSubArraySum = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;

        for (int i = 0; i < seq.length; i++) {

            int sumEndingHere = 0;

            for (int j = i; j < seq.length; j++) {
                sumEndingHere += seq[j];

                if (sumEndingHere > maxSubArraySum) {
                    maxSubArraySum = sumEndingHere;
                    start = i;
                    end = j + 1;
                }
            }
        }
        return Arrays.copyOfRange(seq, start, end);
    }
}
