package app;

import java.util.Arrays;

public class BruteForceAlgorithm {

    public BruteForceAlgorithm() {

    }

    /**
     * Calculate the maximum subsequence of a sequence
     * @param seq the sequence
     * @return the maximum subsequence
     */
    public int[] maximumSubsequence(int[] seq){
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
