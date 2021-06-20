# US 1 -  I want to access the application to view the results of the tests I have performed.

## 1. Requirements Engineering

### 1.1. User Story Description

*As a client, I want to access the application to view the results of the tests I have performed.*

### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**

>Once the laboratory coordinator confirms that everything was done correctly, the client receives a notification alerting that the
results are already available in the central application and informing that he/she must access the
application to view those results. 

**From the client clarifications:**

> **Question:** In US01 which date should be used to arrange the tests in order? The date the test is done or the validation date?
> 
> [**Awnser:**](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8787) The test registration date.

> **Question:** What are the data to show the customer? and in what way do we have to show? do you have any examples you can give us?
>
> [**Awnser:**](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=9038) I want to access the application to view the results of the tests I have performed. This includes the report made by the specialist doctor.
The client tests must be shown ordered from the most recent to the oldest one. The test results are shown only after the client has selected a test.

> **Question:** My group is assuming that the client only wants to see the validated tests. Do you want to see tests in other states and if that's the case say the state of the test and show only the information available for that state?
>
> [**Awnser:**](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=9162) The client should only see tests that have already been validated.


### 1.3. Acceptance Criteria

*Insert here the client acceptance criteria.*

* **AC1:** The client only see tests that have already been validated.
* **AC2:** The client tests must be shown ordered from the most recent to the oldest one. 
* **AC3:** The tests are ordered by registration date.
* **AC4:** The test results are shown only after the client has selected a test.

### 1.4. Found out Dependencies

*Identify here any found out dependency to other US and/or requirements.*
*US03 - the client has to be registered.
*US04 - the test performed was registered by the receptionist.
*US15 - all the tests the client were validated by the Lab Coordinator

### 1.5 Input and Output Data


**Input Data:**

* Typed data:


* Selected data:
    * Test

**Output Data:**

* List of existing tests in the Validate state
* Test Result Informations   
* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)


![US1_SSD](US1_SSD.svg)

## 2. OO Analysis

### 2.1. Relevant Domain Model Excerpt  

![US1_MD](US1_MD.svg)


## 3. Design - User Story Realization 

### 3.1. Rationale

**The rationale grounds on the SSD interactions and the identified input/output data.**

| Interaction ID | Question: Which class is responsible for...                     | Answer                        | Justification (with patterns)                                                                                                                                                                          |
|:-------------  |:--------------------------------------------------------------- |:-----------------------------:|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| Step 1  		 | ... interacting with the actor?                                 | ViewResultsUI                 | **Pure Fabrication**: There is no justification for assigning this responsibility to any existing class in the Domain Model.                                                                           |
|                | ... coordinating the US?                                        | ViewResultsController         | **Controller**                                                                                                                                                                                         |
|                | ... knows the user using the system?                            | UserSession                   | **IE**: cf. user management component documentation.                                                                                                                                                   |
| Step 2  		 | ... knowing the tests that have already been validated?         | TestStore                     | **IE**: Knows all the tests.                                                                                                                                                                           |
|                | ... knowing the TestStore?                                      | Company                       | **IE**: The company knows the TestStore to which it is delegating some tasks.                                                                                                                          |
|                | ... transferring business data in DTO?                          | TestMapper                    | **DTO**: In order for the UI not to have direct access to business objects, it is best to choose to use a DTO.                                                                                         |
| Step 3  		 |                                                                 |                               |                                                                                                                                                                                                        |
| Step 4  		 | ... knowing the test results and its diagnosis?                 | Test                          | **IE**: Owns its data.                                                                                                                                                                                 |
|                | ... transferring business data in DTO?                          | TestResultsMapper             | **DTO**: In order for the UI not to have direct access to business objects, it is best to choose to use a DTO.                                                                                         |
|         		 | ... shows successfully test results?                            | ViewResultsUI                 | **IE**: Is responsible for user interactions.                                                                                                                                                          |

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

 * Company
 * Test

Other software classes (i.e. Pure Fabrication) identified: 

 * ViewResultsUI
 * ViewResultsController
 * TestStore  
 * TestMapper
 * TestResultsMapper

## 3.2. Sequence Diagram (SD)
 

![US1_SD](US1_SD.svg)

## 3.3. Class Diagram (CD)


![US1_CD](US1_CD.svg)

# 4. Tests 

*In this section, it is suggested to systematize how the tests were designed to allow a correct measurement of requirements fulfilling.* 

* Test test


    @Test
    public void getTestParameterList() {
    List<TestParameter> listaDeParametros = new ArrayList<>();
    ParameterCategory pc = new ParameterCategory("12A4D","Covid-19");
    List<ParameterCategory> listPC = new ArrayList();
    listPC.add(pc);
    Parameter p = new Parameter("HB000","test","method", pc);
    Parameter p2 = new Parameter("PLT00","test","method", pc);
    TestParameterDTO temDto2 = new TestParameterDTO("frefrfe","PLT00");
    List<TestParameterDTO> listaDeParametrosDTO = new ArrayList<>();
    listaDeParametrosDTO.add(temDto2);
    TestParameter tpm1 = new TestParameter(p);
    TestParameter tpm2 = new TestParameter(p2);
    // listaDeParametros.add(tpm1);
    listaDeParametros.add(tpm2);
    Client la = new Client("Rita","1231231231231231","1231231231","26/11/2002","1231231231","12345678900","rita@gmail.com","Avenida da República");
    TestType tt = new TestType("12345","test","collecting",listPC,"ExternalModule3API");
    NhsCode nhs = new NhsCode("123456789012");
    List<TestType> ttlist = new ArrayList<>();
    ttlist.add(tt);
    ClinicalAnalysisLaboratory lab = new ClinicalAnalysisLaboratory("Chemical","1234","12312312312","1231231231","12345",ttlist);
    app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(la,nhs,tt,listaDeParametros,lab,"123123123123");
    
            Assert.assertEquals(listaDeParametros,test.getTestParameterList());
        }


    @Test
    public void getDescription(){
    Company company = new Company("Many Labs");
    ParameterCategory pc1 = new ParameterCategory("HM000","Hemogram");
    Parameter p1 = new Parameter("HB000","HB","Hemoglobin",pc1);
    List<ParameterCategory> list=new ArrayList();
    list.add(pc1);
    Client client = new Client("Rita","1231231231231231","1231231231","26/11/2002","1231231231","12345678900","rita@gmail.com","Avenida da República");
    NhsCode nhs = new NhsCode("123456789012");
    TestType tt = new TestType("BL000","blood","syringe",list,"ExternalModule2API");
    RefValue rv = new RefValue("mg",10,20);
    TestParameterResult tpr = new TestParameterResult(rv,"15","mg");
    TestParameter tp = new TestParameter(p1,tpr);
    List<TestParameter> tpList = new ArrayList<>();
    tpList.add(tp);
    List<TestType> ttlist = new ArrayList<>();
    ttlist.add(tt);
    ClinicalAnalysisLaboratory lab = new ClinicalAnalysisLaboratory("Chemical","1234","12312312312","1231231231","12345",ttlist);
    app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"123123123123");
    
    
    
            String description = test.getDescription();
            String description2 = "syringe";
            Assert.assertEquals(description2,description);
        }


    @Test
    public void getInternalCode(){
    Company company = new Company("Many Labs");
    ParameterCategory pc1 = new ParameterCategory("HM000","Hemogram");
    Parameter p1 = new Parameter("HB000","HB","Hemoglobin",pc1);
    List<ParameterCategory> list=new ArrayList();
    list.add(pc1);
    Client client = new Client("Rita","1231231231231231","1231231231","26/11/2002","1231231231","12345678900","rita@gmail.com","Avenida da República");
    NhsCode nhs = new NhsCode("123456789012");
    TestType tt = new TestType("BL000","blood","syringe",list,"ExternalModule2API");
    RefValue rv = new RefValue("mg",10,20);
    TestParameterResult tpr = new TestParameterResult(rv,"15","mg");
    TestParameter tp = new TestParameter(p1,tpr);
    List<TestParameter> tpList = new ArrayList<>();
    tpList.add(tp);
    List<TestType> ttlist = new ArrayList<>();
    ttlist.add(tt);
    ClinicalAnalysisLaboratory lab = new ClinicalAnalysisLaboratory("Chemical","1234","12312312312","1231231231","12345",ttlist);
    app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"123123123123");
    
    
    
            String internalcode = test.getInternalCode();
            String Internal = "123123123123";
            Assert.assertEquals(internalcode,Internal);
        }

    @Test
    public void getMedicalReport(){
    Company company = new Company("Many Labs");
    ParameterCategory pc1 = new ParameterCategory("HM000","Hemogram");
    Parameter p1 = new Parameter("HB000","HB","Hemoglobin",pc1);
    List<ParameterCategory> list=new ArrayList();
    list.add(pc1);
    Client client = new Client("Rita","1231231231231231","1231231231","26/11/2002","1231231231","12345678900","rita@gmail.com","Avenida da República");
    NhsCode nhs = new NhsCode("123456789012");
    TestType tt = new TestType("BL000","blood","syringe",list,"ExternalModule2API");
    RefValue rv = new RefValue("mg",10,20);
    TestParameterResult tpr = new TestParameterResult(rv,"15","mg");
    TestParameter tp = new TestParameter(p1,tpr);
    List<TestParameter> tpList = new ArrayList<>();
    tpList.add(tp);
    List<TestType> ttlist = new ArrayList<>();
    ttlist.add(tt);
    ClinicalAnalysisLaboratory lab = new ClinicalAnalysisLaboratory("Chemical","1234","12312312312","1231231231","12345",ttlist);
    app.domain.model.testrelated.Test test = new app.domain.model.testrelated.Test(client,nhs,tt,tpList,lab,"123123123123");
    
    
    
            MedicalReport description = test.getMedicalReport();
            MedicalReport medicalReport = null;
            Assert.assertEquals(medicalReport,description);
        }
# 5. Construction (Implementation)

*In this section, it is suggested to provide, if necessary, some evidence that the construction/implementation is in accordance with the previously carried out design. Furthermore, it is recommeded to mention/describe the existence of other relevant (e.g. configuration) files and highlight relevant commits.*
    

* Class ViewResultsController


    package app.controller;
    
    import app.domain.model.Company;
    import app.domain.model.testrelated.Test;
    import app.domain.model.users.Client;
    import app.domain.store.ClientStore;
    import app.domain.store.TestStore;
    import app.mappers.*;
    import app.mappers.dto.ClientDTO;
    import app.mappers.dto.TestDTO;
    import app.mappers.dto.TestResultDto;
    import auth.domain.model.Email;
    import java.util.List;
    
    public class ViewResultsController {
    /**
    * Represents an instance of app.
    */
    private App app;
    /**
    * Represents a instance of company
    */
    private Company company;
    /**
    * Represents an instance of the test store.
    */
    private TestStore tStore;
    /**
    * Represents an instance of the test mapper.
    */
    private TestMapper tmapper;
    /**
    * Represents an instance of Client Store
    */
    private ClientStore clstore;
    /**
    * Represents an instance of Client Mapper
    */
    private ClientMapper clMapper;
    /**
    * Represents an instance of TestParameter Mapper
    */
    private TestResultsMapper trMapper;
    
        /**
         * Initialize the instance variables
         */
        public ViewResultsController() {
            this(App.getInstance().getCompany());
        }
    
        /**
         * Initialize the instance variables
         * @param company the company
         */
        public ViewResultsController(Company company) {
            this.app = App.getInstance();
            this.company = app.getCompany();
            this.tStore = company.getTestStore();
            this.clstore = company.getClientStore();
            this.clMapper = new ClientMapper();
            this.tmapper = new TestMapper();
            this.trMapper = new TestResultsMapper();
        }
    
        /**
         * Get the list of test associated with the client
         * @param cl the client
         * @return the list of the tests
         */
        public List<TestDTO> getTestList(ClientDTO cl){
            List<Test> listTest = tStore.getTestListAssociatedWithClient(cl);
            listTest = tStore.orderClientTestsByRegistrationDate(listTest);
            return tmapper.toDto(listTest);
        }
    
        /**
         * Get the user of the system
         * @return the user of the system
         */
        public ClientDTO getUserSession(){
            Email empemail= app.getCurrentUserSession().getUserId();
            Client cl = clstore.getClientByEmail(empemail.toString());
            return clMapper.toDto(cl);
        }
    
        /**
         * Get the test selected by the user
         * @param selectedTest the selected test
         * @return the test that has the same internal code that the test received
         */
        public TestResultDto showTestResults(TestDTO selectedTest){
            Test t =tStore.getTestByInternalCode(selectedTest.getInternalCode());
            return trMapper.toDTO(t);
        }
    }


# 6. Integration and Demo 

*In this section, it is suggested to describe the efforts made to integrate this functionality with the other features of the system.

* To test this user storie, we need to create tests to view its results.

# 7. Observations

*In this section, it is suggested to present a critical perspective on the developed work, pointing, for example, to other alternatives and or future related work.*





