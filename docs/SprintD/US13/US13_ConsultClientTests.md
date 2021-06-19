# US 13 - Consult the tests performed by a client


## 1. Requirements Engineering

### 1.1. User Story Description

* As a clinical chemistry technologist, I intend to consult the historical tests
  performed by a particular client and to be able to check tests details/results.

### 1.2. Customer Specifications and Clarifications 

**From the specifications document:**
>In case of a new client, the receptionist registers the client in the application. To register a client, the
receptionist needs the client’s citizen card number, National Healthcare Service (NHS) number,
birth date, sex, Tax Identification number (TIF), phone number, e-mail and name.

**From the client clarifications:**
> **Question:**  Should we show every client already registered when we show the clients' list to the clinical chemistry technologist or should we only show the clients' with a test or more already assigned?
>
> [**Answer:**](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8938#p11754) The system should show only clients that have tests already validated by the lab coordinator.

> **Question:**  From the user story description "As a clinical chemistry technologist, I intend to consult the historical tests performed by a particular client and to be able to check tests details/results". What do you mean by "check tests details/results" ?
>
> [**Answer:**](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=9055) The clinical chemistry technologist should be able to check the historical tests performed by a particular client and see the results obtained in each test. For a given client (that was selected by the clinical chemistry technologist) the application should show all tests performed by the client and, for each parameter, the application should show the parameter value and the parameter reference values. The clinical chemistry technologist should not have access to the report made by the specialist doctor.

> **Question:**  In US13 acceptance criteria, "The application must allow ordering the clients by TIN and by name...". What do you mean by that? Is there a priority in ordering between name and TIN?
>
> [**Answer:**](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=9246#p12176) The user can chose to sort the clients by name OR by TIN.

> **Question:**  In the User Story 13, the Clinical Chemistry Technologist to "choose the target client" needs to type the name (or TIN number)? Or should be a list present with all the client's available and, after that, be possible to select one?
>
> [**Answer:**](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=9181#p12113)  From the requirements introduced in the beginning of Sprint D: "The application must allow ordering the clients by TIN and by name to help the clinical chemistry technologist choose the target client". A sorted list should be presented to the clinical chemistry technologist.

> **Question:** In US13, the Clinical Chemistry Technologist, can select more than one client at once to view its historical test results?
>
> [**Answer:**](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=9178#p12112) No.

> **Question:** Moreover, will all the tests associated with the client be displayed or the clinical chemistry technologist will have also to select the tests he wants to see?
>
> [**Answer:**](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=9178#p12112) After selecting one client, the application should show all the historical test results, of that client, to the Clinical Chemistry Technologist.

> **Question:**  Should the user be the one selecting if the Clients are ordered by Name or TIN, or should it be defined through the configuration file? If it is the user, how should he be able to select it?
>
> [**Answer:**](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=9120#p12103) When using the application, the clinical chemistry technologist should be able to sort the clients by name or TIN. The algorithm that will be used to sort the data should be defined through a configuration file.


> **Question:** From the user story description "As a clinical chemistry technologist, I intend to consult the historical tests performed by a particular client and to be able to check tests details/results". What do you mean by "check tests details/results" ?
>
> [**Answer:**](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=9055#p11905) The clinical chemistry technologist should be able to check the historical tests performed by a particular client and see the results obtained in each test. For a given client (that was selected by the clinical chemistry technologist) the application should show all tests performed by the client and, for each parameter, the application should show the parameter value and the parameter reference values. The clinical chemistry technologist should not have access to the report made by the specialist doctor.

> **Question:** The client's tests, that we have to show on this US, need to have been validated by the lab coordinator or is it enough if they just have results and we can show them before being validated by the lab coordinator?
>
> [**Answer:**](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8945#p11883)  The tests to be presented in US13 are tests that have already been validated by the lab coordinator.

> **Question:** Should we show every client already registered when we show the clients' list to the clinical chemistry technologist or should we only show the clients' with a test or more already assigned?
>
> [**Answer:**](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8938#p11754) The system should show only clients that have tests already validated by the lab coordinator.

### 1.3. Acceptance Criteria

* **AC1:** The application must allow ordering the clients by TIN and by name to help the clinical chemistry technologist choose the target client.
* **AC2:** The ordering algorithm to be used by the application must be defined through a configuration file. 
* **AC3:** At least two sorting algorithms should be available.
* **AC4:** It is only possible to select one client at a time.
* **AC5:** Only validated tests associated with a client should be shown.
* **AC6:** The algorithm used for ordering must be selected by the user.
* **AC7:** The medical report associated with a particular test should not be shown to the user.

### 1.4. Found out Dependencies

* This user story has a dependency with use story 15 since only customers with test already validated by the laboratory coordinator will be shown in user story 13.

### 1.5 Input and Output Data

**Input Data:**

* Selected data:
    * A Client
    * The sorting algorithm
  
**Output Data:**
* A list of clients sorted by the selected algorithm
* A list with the tests performed by a particular client


### 1.6. System Sequence Diagram (SSD)

![US13_SSD](US13_SSD.svg)


### 1.7 Other Relevant Remarks

* Algorithms will be defined by a configuration file.
* This user story will be used whenever the clinical chemistry technologist needs to consult the tests related to a client.

## 2. OO Analysis

### 2.1. Relevant Domain Model Excerpt  

![US13_MD](US13_DM.svg)

### 2.2. Other Remarks

![TestLyfeCycle](TestLifeCycle.svg)

## 3. Design - User Story Realization 

### 3.1. Rationale

**The rationale grounds on the SSD interactions and the identified input/output data.**

| Interaction ID | Question: Which class is responsible for... | Answer  | Justification (with patterns)  |
|:-------------  |:--------------------- |:------------|:---------------------------- |
| Step 1  		 | ... interacting with the actor? | SeeTestsUI|  **Pure Fabrication**: There is no justification for assigning this responsibility to any existing class in the Domain Model.|
|                | ... coordinating the US?                                        | SeeTestsController         | **Controller**                                                                                                                                                                                         |
|        		 | ... knowing all the clients with tests validated in the system? | TestStore |**IE:**: Know all the tests in the system. |
|                | ...knowing the client associated with a test?                   | Test      | **IE:** Owns our on data. |
|                | ... knowing the TestStore?                                      | Company                       | **IE**: The company knows the ClientStore to which it is delegating some tasks.                                                                                                                          |
|                | ... transferring business data in DTO?                           | ClientDto                       | **DTO**: In order for the UI not to have direct access to business objects, it is best to choose to use a DTO.                                                                                         |
| Step 2  		 | ... asking the user the algorithm that he intends to use to order the clients? | SeeTestsUi | **IE**: Is responsible for user interaction.|
| Step 3  		 |				 |    |                            |
| Step 4         |...show the list of client ordered?							 |SeeTestsUI             | **IE**: Is responsible for user interaction.                              |
| Step 5  		 |... know the client associated with a test? | Test | **IE:** The test owns your on data.                              |
| Step 6  		 |... show the test associated with a client? | SeeTestsUI | **IE:** Is responsible for user interaction.                             |              

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

 * Client
 * Test

Other software classes (i.e. Pure Fabrication) identified: 
 * SeeTestsUI  
 * SeeTestsController
 * ClientStore
 * ClientMapper
 * TestMapper 
 * TestStore

## 3.2. Sequence Diagram (SD)

![US13-SD](US13_SD.svg)

### 3.2.1 Partial Sequence Diagram 
* Partial sequence diagram related to the passing of a client, domain object, to an object data transfer type
![SD_ClientMapper_toDto_List](SD_ClientMapper_toDto_List.svg)


* Partial sequence diagram related to the process of picking up customers associated with a particular test validated by the laboratory coordinator
![SD_GetTheClientListWithTestValidated](SD_GetTheClientListWithTestValidated.svg)
## 3.3. Class Diagram (CD)



![US13-CD](US13_CD.svg)

# 4. Tests 
*In this section, it is suggested to systematize how the tests were designed to allow a correct measurement of requirements fulfilling.* 

**_DO NOT COPY ALL DEVELOPED TESTS HERE_**

**Test 1:** Check that it is not possible to create an instance of the Example class with null values. 

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Exemplo instance = new Exemplo(null, null);
	}

*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)

*In this section, it is suggested to provide, if necessary, some evidence that the construction/implementation is in accordance with the previously carried out design. Furthermore, it is recommeded to mention/describe the existence of other relevant (e.g. configuration) files and highlight relevant commits.*

*It is also recommended to organize this content by subsections.* 

# 6. Integration and Demo 

*In this section, it is suggested to describe the efforts made to integrate this functionality with the other features of the system.*


# 7. Observations

*In this section, it is suggested to present a critical perspective on the developed work, pointing, for example, to other alternatives and or future related work.*





