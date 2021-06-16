package app.adapter;

import app.BruteForceAlgorithm;
import app.adapter.interfaces.SubsequenceWithMaximumSum;

public class BruteForceAdapter implements SubsequenceWithMaximumSum {

    @Override
    public int[] getSubsequenceWithMaximumSum(int[] seq) {
        BruteForceAlgorithm externalAPI = new BruteForceAlgorithm();
        return externalAPI.MaxSubsequence(seq);
    }
}
