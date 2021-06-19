package app.domain.model.testrelated;

import app.controller.App;
import app.interfaces.SubsequenceWithMaximumSum;
import app.domain.model.users.Client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    private static int[] sequence;

    private List<String> dates;

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
        getSequenceAux();
    }

    public void getNumberOfTestsProcessed(){

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
            if (t.getStateOfTest() == samplesCollected) {
                testWaitingForResults.add(t);
            }
        }
    }

    private void getTestsWaitingForDiagnosis(){
        testsWaitingForDiagnosis = new ArrayList();
        for (Test t: testList) {
            if (t.getStateOfTest() == samplesAnalyzed) {
                testsWaitingForDiagnosis.add(t);
            }
        }
    }

    public Integer getNumberOfClients() {
        return numberOfClients;
    }

    public static int[] getSequence(){
        return sequence;
    }

    public List<String> getDates() {
        return dates;
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        dates= new ArrayList<>();
        Date date1 = new Date(initialDate.getTime());
        Date date2 ;

        do {

            int aux = 0;

            date2 = new Date(date1.getTime());
            date2.setMinutes(date2.getMinutes() + 30);

            if(date2.getDay()!=0) {
                for (Test t : testList) {
                    if (t.getSamplesAddDate() != null) {
                        if (t.getSamplesAddDate().after(date1) && t.getSamplesAddDate().before(date2)) {
                            aux++;
                        }
                    }
                }

                sequenceTestWaitingForResults.add(aux);
                dates.add(String.format("%s - %s", dateFormat.format(date1), dateFormat.format(date2)));
                date2.setMinutes(date2.getMinutes() + 1);
                date1 = new Date(date2.getTime());

                if (date1.getHours() >= 20) {
                    date1.setDate(date1.getDate() + 1);
                    date1.setHours(8);
                }

            } else {
                date1.setDate(date1.getDate() + 1);
            }
        }while (date1.before(endDate));
    }

    public void getSequenceTestWaitingForDiagnosis()  {
        Date date1 = new Date(initialDate.getTime());
        Date date2;
        do {
            int aux = 0;
            date2 = new Date(date1.getTime());
            date2.setMinutes(date2.getMinutes() + 30);
            if(date2.getDay()!=0) {
                
                for (Test t : testList) {
                    if (t.getLabValidationDate() != null) {
                        if (t.getLabValidationDate().after(date1) && t.getLabValidationDate().before(date2)) {
                            aux++;
                        }
                    }
                }
                sequenceTestWaitingForDiagnosis.add(aux);
                date2.setMinutes(date2.getMinutes() + 1);
                date1 = new Date(date2.getTime());

                if (date1.getHours() >= 20) {
                    date1.setDate(date1.getDate() + 1);
                    date1.setHours(8);
                }
            } else {
                date1.setDate(date1.getDate() + 1);
            }

        }while (date1.before(endDate));
    }

    public void getSequenceAux(){
        this.sequence = new int[sequenceTestWaitingForResults.size()];
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
        return subMaxSum.getSubsequenceWithMaximumSum(sequence);
    }
}
