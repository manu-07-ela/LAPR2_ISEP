package app;

import java.util.Arrays;

public class BruteForceAlgorithm {

    public BruteForceAlgorithm() {

    }

    public int[] MaxSubsequence(int[] seq){
        int maxSubArraySum = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;

        for (int i = 0; i < seq.length; i++) {

            int sum = 0;

            for (int j = i; j < seq.length; j++) {
                sum += seq[j];

                if (sum > maxSubArraySum) {
                    maxSubArraySum = sum;
                    start = i;
                    end = j;
                }
            }
        }
        return Arrays.copyOfRange(seq, start, end+1);
    }
}
