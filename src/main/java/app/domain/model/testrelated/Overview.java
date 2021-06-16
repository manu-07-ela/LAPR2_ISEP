package app.domain.model.testrelated;

import app.controller.App;
import app.interfaces.SubsequenceWithMaximumSum;
import app.domain.model.users.Client;

import java.util.*;

import static app.domain.model.testrelated.Test.StateOfTest.*;

public class Overview {

    private Integer numberOfClients;

    private Integer numberOfTestWaitingForResults;

    private Integer numberOfTestsWaitingForDiagnosis;

    private Integer totalNumberOfTestsProcessed;

    private List<Client> clientList;

    private List<Test> testList;

    private List<Test> testWaitingForResults;

    private List<Test> testsWaitingForDiagnosis;

    /**
     *
     */
    private List<String> availableAlgorithms = new ArrayList(Arrays.asList("Benchmark", "BruteForce"));


    public Overview(Date initialDate, Date endDate, List<Test> testList){
        this.testList=testList;
        getAssociatedClients();
        this.numberOfClients=clientList.size();
        getTestWaitingForResults();
        this.numberOfTestWaitingForResults=testWaitingForResults.size();
        getTestsWaitingForDiagnosis();
        this.numberOfTestsWaitingForDiagnosis=testsWaitingForDiagnosis.size();
        this.totalNumberOfTestsProcessed=testList.size();
    }

    private void getAssociatedClients(){
        clientList = new ArrayList();
        for (Test t: testList) {
            if (!clientList.contains(t.getCl())) {
                clientList.add(t.getCl());
            }
        }
    }

    private void getTestWaitingForResults(){
        testWaitingForResults = new ArrayList();
        for (Test t: testList) {
            if (t.getStateOfTest() == SamplesCollected) {
                testWaitingForResults.add(t);
            }
        }
    }

    private void getTestsWaitingForDiagnosis(){
        testsWaitingForDiagnosis = new ArrayList();
        for (Test t: testList) {
            if (t.getStateOfTest() == SamplesAnalyzed) {
                testsWaitingForDiagnosis.add(t);
            }
        }
    }

    public Integer getNumberOfClients() {
        return numberOfClients;
    }

    public Integer getNumberOfTestWaitingForResults(){
        return numberOfTestWaitingForResults;
    }

    public Integer getNumberOfTestsWaitingForDiagnosis() {
        return numberOfTestsWaitingForDiagnosis;
    }

    public Integer getTotalNumberOfTestsProcessed() {
        return totalNumberOfTestsProcessed;
    }

    public List<String> getAvailableAlgorithms(){
        return availableAlgorithms;
    }

    /**
     *
     * @param algorithm
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public int[] getSubsequenceWithMaximumSum(String algorithm) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Properties props = App.getInstance().getProps();
        String classAux = props.getProperty(String.format("Controller.%sAdapter.Class",algorithm));
        Class<?> oClass = Class.forName(classAux);
        SubsequenceWithMaximumSum subMaxSum = (SubsequenceWithMaximumSum) oClass.newInstance();
        return subMaxSum.getSubsequenceWithMaximumSum( new int[]{29, -32, -9, -25, 44, 12, -61, 51, -9, 44, 74, 4});
    }
}
