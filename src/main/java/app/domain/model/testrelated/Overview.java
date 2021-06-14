package app.domain.model.testrelated;

import app.domain.model.users.Client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Overview {

    private Integer numberOfClients;

    private List<Client> clientList;

    private List<Test> testList;

    public Overview(Date initialDate, Date endDate, List<Test> testList){
        this.testList=testList;
        this.clientList=getAssociatedClients();
        this.numberOfClients=clientList.size();
    }

    private List<Client> getAssociatedClients(){
        List<Client> clientList = new ArrayList();
        for (Test t: testList) {
            if (!clientList.contains(t.getCl())) {
                clientList.add(t.getCl());
            }
        }
        return clientList;
    }

    public Integer getNumberOfClients() {
        return numberOfClients;
    }
}
