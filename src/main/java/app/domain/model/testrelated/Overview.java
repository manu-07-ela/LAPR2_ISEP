package app.domain.model.testrelated;

import app.domain.model.users.Client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Overview {

    private Integer numberOfClients;

    private Integer numberOfTestWaitingForResults;

    private Integer numberOfTestsWaitingForDiagnosis;

    private Integer totalNumberOfTestsProcessed;

    private List<Client> clientList;

    private List<Test> testList;

    private List<Test> testWaitingForResults;

    private List<Test> testsWaitingForDiagnosis;

    public Overview(Date initialDate, Date endDate, List<Test> testList){
        this.testList=testList;
        getAssociatedClients();
        if(testsWaitingForDiagnosis==null){
            this.numberOfClients=0;
        } else {
            this.numberOfClients=clientList.size();
        }
        getTestWaitingForResults();
        if(testsWaitingForDiagnosis==null){
            this.numberOfTestWaitingForResults=0;
        } else {
            this.numberOfTestWaitingForResults=testWaitingForResults.size();
        }
        getTestsWaitingForDiagnosis();
        if(testsWaitingForDiagnosis==null){
            this.numberOfTestsWaitingForDiagnosis=0;
        } else {
            this.numberOfTestsWaitingForDiagnosis=testsWaitingForDiagnosis.size();
        }
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
            if (t.getStateOfTest().equals("SamplesCollected")) {
                testWaitingForResults.add(t);
            }
        }
    }

    private void getTestsWaitingForDiagnosis(){
        testsWaitingForDiagnosis = new ArrayList();
        for (Test t: testList) {
            if (t.getStateOfTest().equals("SamplesAnalyzed")) {
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
}
