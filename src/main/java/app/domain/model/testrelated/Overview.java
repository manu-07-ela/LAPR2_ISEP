package app.domain.model.testrelated;

import app.domain.model.users.Client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public Overview(Date initialDate, Date endDate, List<Test> testList){
        this.testList=testList;
        getAssociatedClients();
        this.numberOfClients=clientList.size();
        getTestWaitingForResults();
        this.numberOfTestWaitingForResults=testWaitingForResults.size();
        getTestsWaitingForDiagnosis();
        this.numberOfTestsWaitingForDiagnosis=testsWaitingForDiagnosis.size();
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
}
