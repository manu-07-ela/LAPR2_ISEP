package app.adapter;

import app.interfaces.SubsequenceWithMaximumSum;
import com.isep.mdis.Sum;

public class BenchmarkAdapter implements SubsequenceWithMaximumSum {
    /**
     * Method responsible for implementing the benchmark algorithm for calculating the maximum subsequence.
     * @param seq the sequence in which you want to obtain the maximum subsequence
     * @return the maximum subsequence
     */
    @Override
    public int[] getSubsequenceWithMaximumSum(int[] seq) {
        Sum externalAPI = new Sum();
        return externalAPI.Max(seq);
    }
}
