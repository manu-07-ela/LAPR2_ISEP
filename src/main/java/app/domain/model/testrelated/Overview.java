package app.domain.model.testrelated;

import app.controller.App;
import app.interfaces.SubsequenceWithMaximumSum;
import app.domain.model.users.Client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static app.domain.model.testrelated.Test.StateOfTest.*;

public class Overview {

    private Integer numberOfClients;

    private Integer numberOfTestWaitingForResults;

    private Integer numberOfTestsWaitingForDiagnosis;

    private Integer totalNumberOfTestsProcessed;

    private List<Integer> sequenceTestWaitingForResults;

    private List<Integer> sequenceTestWaitingForDiagnosis;

    private List<Client> clientList;

    private List<Test> testList;

    private List<Test> testWaitingForResults;

    private List<Test> testsWaitingForDiagnosis;

    private Date initialDate;

    private Date endDate;

    private int[] sequence;

    /**
     *
     */
    private List<String> availableAlgorithms = new ArrayList(Arrays.asList("Benchmark", "BruteForce"));


    public Overview(Date initialDate, Date endDate, List<Test> testList) throws ParseException {
        this.initialDate=initialDate;
        this.endDate=endDate;
        this.testList=testList;
        getAssociatedClients();
        this.numberOfClients=clientList.size();
        getTestWaitingForResults();
        this.numberOfTestWaitingForResults=testWaitingForResults.size();
        getTestsWaitingForDiagnosis();
        this.numberOfTestsWaitingForDiagnosis=testsWaitingForDiagnosis.size();
        this.totalNumberOfTestsProcessed=testList.size();
        sequenceTestWaitingForResults = new ArrayList();
        sequenceTestWaitingForDiagnosis = new ArrayList<>();
        getSequenceTestWaitingForResults();
        getSequenceTestWaitingForDiagnosis();
        getSequence();
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

    public void getSequenceTestWaitingForResults()  {
        Date date1 = initialDate;
        Date date2 = date1;
        do {
            int aux = 0;
            date2.setMinutes(date2.getMinutes() + 30);
            for (Test t : testList) {
                if (t.getSamplesAddDate().after(date1) && t.getSamplesAddDate().before(date2)) {
                    aux++;
                }
            }
            sequenceTestWaitingForResults.add(aux);
            date2.setMinutes(date2.getMinutes() + 1);
            date1 = date2;
        }while (date2.before(endDate));
    }

    public void getSequenceTestWaitingForDiagnosis()  {
        Date date1 = initialDate;
        Date date2 = date1;
        do {
            int aux = 0;
            date2.setMinutes(date2.getMinutes() + 30);
            for (Test t : testList) {
                if (t.getChemicalAnalysisDate().get((t.getChemicalAnalysisDate().size())-1).after(date1) && t.getChemicalAnalysisDate().get((t.getChemicalAnalysisDate().size())-1).before(date2)) {
                    aux++;
                }
            }
            sequenceTestWaitingForDiagnosis.add(aux);
            date2.setMinutes(date2.getMinutes() + 1);
            date1 = date2;
        }while (date2.before(endDate));
    }

    public void getSequence(){
        sequence = new int[sequenceTestWaitingForResults.size()];
        for (int i=0;i<sequence.length;i++){
            sequence[i]=sequenceTestWaitingForResults.get(i)-sequenceTestWaitingForDiagnosis.get(i);
        }
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
