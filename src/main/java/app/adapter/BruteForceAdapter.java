package app.adapter;

import app.BruteForceAlgorithm;
import app.interfaces.SubsequenceWithMaximumSum;

public class BruteForceAdapter implements SubsequenceWithMaximumSum {
    /**
     * Method responsible for implementing the brute force algorithm for calculating the maximum subsequence.
     * @param seq the sequence in which you want to obtain the maximum subsequence
     * @return the maximum subsequence
     */
    @Override
    public int[] getSubsequenceWithMaximumSum(int[] seq) {
        BruteForceAlgorithm externalAPI = new BruteForceAlgorithm();
        return externalAPI.MaxSubsequence(seq);
    }
}
