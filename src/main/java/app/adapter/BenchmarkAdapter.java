package app.adapter;

import app.interfaces.SubsequenceWithMaximumSum;
import com.isep.mdis.Sum;

public class BenchmarkAdapter implements SubsequenceWithMaximumSum {

    @Override
    public int[] getSubsequenceWithMaximumSum(int[] seq) {
        Sum externalAPI = new Sum();
        return externalAPI.Max(seq);
    }
}
