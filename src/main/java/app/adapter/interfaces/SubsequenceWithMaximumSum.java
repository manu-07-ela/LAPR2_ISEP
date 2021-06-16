package app.adapter.interfaces;

/**
 * Interface that will be implemented by the external module adapter responsible for obtaining the Subsequence With Maximum Sum.
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */

public interface SubsequenceWithMaximumSum {

    /**
     * Method that will generate and return the subsequence with maximum sum.
     * @return The subsequence with maximum sum.
     */

    int[] getSubsequenceWithMaximumSum (int[] seq);
}
