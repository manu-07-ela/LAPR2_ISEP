package app.domain.model.testrelated;

import app.controller.App;
import app.interfaces.SubsequenceWithMaximumSum;
import app.domain.model.users.Client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Overview {

    private Integer numberOfClients;

    private List<Integer> sequenceTestWaitingForResults;

    private List<Integer> sequenceTestWaitingForDiagnosis;

    private List<Client> clientList;

    private List<Test> testList;

    private List<Integer> testWaitingForResults;

    private List<Integer> testsWaitingForDiagnosis;

    private List<Integer> testProcessed;

    private List<Date> intervalDates;

    private Date initialDate;

    private Date endDate;

    private static int[] sequence;

    private static int[] subSequence;

    private String algorithm;

    private SimpleDateFormat formatter;

    private List<Date> dates;

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
        getTestWaitingForResultsDay();
        getTestsWaitingForDiagnosisDay();
        getNumberOfTestsProcessedDay();
        getIntervalDays();
        sequenceTestWaitingForResults = new ArrayList();
        sequenceTestWaitingForDiagnosis = new ArrayList<>();
        getSequenceTestWaitingForResults();
        getSequenceTestValidated();
        getSequenceAux();
        formatter = new SimpleDateFormat("dd/MM/yyyy");

    }

    public void setAlgorithm(String algorithm) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        this.algorithm = algorithm;
        subSequence=getSubsequenceWithMaximumSum(algorithm);
    }

    public void getIntervalDays() throws ParseException {
        dates = new ArrayList<>();

        String date= formatter.format(initialDate);

        Date date1= formatter.parse(date);

        date= formatter.format(endDate);

        Date endDate = formatter.parse(date);

        do {

            if(date1.getDay()!=0) {
                dates.add(date1);
            }
            date1 = new Date(date1.getTime());
            date1.setDate(date1.getDate()+1);

        }while (date1.before(endDate));

        dates.add(endDate);


    }

    public void getNumberOfTestsProcessedDay() throws ParseException {

        String date= formatter.format(initialDate);

        Date date1= formatter.parse(date);

        date= formatter.format(endDate);

        Date endDate = formatter.parse(date);

        testProcessed = new ArrayList();

        do {
            int aux = 0;
            if(date1.getDay()!=0) {
                for (Test t : testList) {
                    if (t.getLabValidationDate() != null) {

                        date= formatter.format(t.getLabValidationDate());

                        Date temp = formatter.parse(date);
                        if (temp.equals(date1)) {
                            aux++;
                        }
                    }
                }
                testProcessed.add(aux);
            }

            date1.setDate(date1.getDate() + 1);

        }while (date1.before(endDate));

        System.out.println(testProcessed.size());
        System.out.println(testProcessed);


    }

    private void getAssociatedClients(){
        clientList = new ArrayList();
        for (Test t: testList) {
            if (!clientList.contains(t.getCl())) {
                clientList.add(t.getCl());
            }
        }
    }

    private void getTestsWaitingForDiagnosisDay() throws ParseException {

        String date= formatter.format(initialDate);

        Date date1= formatter.parse(date);

        date= formatter.format(endDate);

        Date endDate = formatter.parse(date);

        testsWaitingForDiagnosis = new ArrayList();

        do {
            int aux = 0;
            if(date1.getDay()!=0) {
                for (Test t : testList) {

                    if (t.getChemicalAnalysisDate().get(t.getChemicalAnalysisDate().size() - 1) != null) {

                        date= formatter.format(t.getChemicalAnalysisDate().get(t.getChemicalAnalysisDate().size() - 1));

                        Date temp = formatter.parse(date);
                        if (temp.equals(date1)) {
                            aux++;
                        }
                    }
                }

                testsWaitingForDiagnosis.add(aux);
            }

            date1.setDate(date1.getDate() + 1);

        }while (date1.before(endDate));
    }

    private void getTestWaitingForResultsDay() throws ParseException {


        String date= formatter.format(initialDate);

        Date date1= formatter.parse(date);

        date= formatter.format(endDate);

        Date endDate = formatter.parse(date);

        testWaitingForResults = new ArrayList();

        do {
            int aux = 0;

            if(date1.getDay()!=0) {
                for (Test t : testList) {
                    if (t.getSamplesAddDate() != null) {

                        date= formatter.format(t.getSamplesAddDate());

                        Date temp = formatter.parse(date);
                        if (temp.equals(date1)) {
                            aux++;
                        }
                    }
                }
                testWaitingForResults.add(aux);
            }

            date1.setDate(date1.getDate() + 1);

        }while (date1.before(endDate));
    }

    public Integer getNumberOfClients() {
        return numberOfClients;
    }

    public static int[] getSequence(){
        return sequence;
    }

    public List<Date> getDates() {
        return dates;
    }

    public List<String> getAvailableAlgorithms(){
        return availableAlgorithms;
    }

    public List<Integer> getTestProcessed() {
        return testProcessed;
    }

    public List<Integer> getTestsWaitingForDiagnosis() {
        return testsWaitingForDiagnosis;
    }

    public List<Integer> getTestWaitingForResults() {
        return testWaitingForResults;
    }

    public List<Date> getIntervalDates() {
        return intervalDates;
    }

    public void getSequenceTestWaitingForResults()  {
        intervalDates = new ArrayList<>();

        Date date1 = new Date(initialDate.getTime());
        Date date2 ;

        do {

            int aux = 0;

            date2 = new Date(date1.getTime());
            intervalDates.add(date2);
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
        intervalDates.add(endDate);
    }

    public void getSequenceTestValidated()  {


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

    public String[] getPeriodSubSequenceMaxSum(){
        return periodSubSequenceMaxSum(subSequence,sequence);
    }


    public String[] periodSubSequenceMaxSum(int[] subSeq,int[] sequence) {

        String[] period = new String[2];

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        int aux = 0;

        boolean flag = false;

        for (int i = 0; i < sequence.length; i++) {
            if (!flag)
                if (sequence[i] == subSeq[0]) {
                    aux++;
                    String date = formatter.format(intervalDates.get(i));
                    period[0] = date;
                    for (int j = 1; j < subSeq.length; j++) {
                        if (sequence[j] == subSeq[j]) {
                            aux++;
                        }
                    }
                    if (aux == subSeq.length) {
                        String endDate = formatter.format(intervalDates.get(i + aux));
                        period[1] = endDate;
                        flag = true;
                    }
                }
        }

        return period;
    }
}
