# US 15 - I want to validate the work done by the clinical chemistry technologist and specialist doctor.

## 1. Requirements Engineering

*In this section, it is suggested to capture the requirement description and specifications as provided by the client as well as any further clarification on it. It is also suggested to capture the requirements acceptance criteria and existing dependencies to other requirements. At last, identfy the involved input and output data and depicted an Actor-System interaction in order to fulfill the requirement.*


### 1.1. User Story Description

*As a laboratory coordinator, I want to validate the work done by the clinical chemistry technologist and specialist doctor.*

### 1.2. Customer Specifications and Clarifications 

*Insert here any related specification and/or clarification provided by the client together with **your interpretation**. When possible, provide a link to such specifications/clarifications.*

**From the specifications document:**

> To facilitate and simplify the validation work performed by the specialist doctor, the application
uses an external module that is responsible for doing an automatic validation using test reference
values.
> 
> After the specialist doctor has completed the diagnosis, the results of the clinical analyses and the
report become available in the system and must be validated by the laboratory coordinator. To
validate the work done, the laboratory coordinator checks the chemical test/result and associated
diagnosis made and confirms that everything was done correctly.
> 
> Many Labs performs two types of tests. Each test is characterized by an internal code, an NHS
code, a description that identifies the sample collection method, the date and time when the samples
were collected, the date and time of the chemical analysis, the date and time of the diagnosis made
by the specialist doctor, the date and time when the laboratory coordinator validated the test, and the
test type (whether it is blood test or Covid test).
> 
> Once the laboratory coordinator
confirms that everything was done correctly, the client receives a notification alerting that the
results are already available in the central application and informing that he/she must access the
application to view those results. The client receives the notification by SMS and e-mail.
> 
> 

**From the client clarifications:**

> **Question:** Should the laboratory coordinator validate the test results one by one or should he do only one validation of all of them?
>
> [**Awnser:**](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8180) The coordinator can validate all or a subset of test results. The system does not show client personal information but shows all dates (test registration date, chemical analysys date and diagnosis date).

> **Question:** Regarding the process of validating a certain test/result, what validation states should be considered by the laboratory coordinator?
> For example, can "Valid" or "Invalid" be accepted as a confirmation for the chemical test/result and its diagnosis?
>
> [**Awnser:**](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8251) Only Valid state. The system shows all tests ready to validate (tests that already have the test registration date, the chemical analysys date and the diagnosis date registered in the system) and the laboratory coordinator selects one or more tests to mark as validated.

> **Question:** : When the laboratory coordinator wants to validate a test does all the tests available show up for him or does he search using a code that identifies a specific test?
>
> [**Awnser:**](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8177) The system shows all tests ready to validate (tests that already have the test registration date, the chemical analysys date and the diagnosis date registered in the system) and the laboratory coordinator selects one or more tests to mark as validated.

> **Question:** What should happen to a test if either the test report or the results are invalid? Should we prompt for a redo of either process or simply erase the test?
>
> [**Awnser:**](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8177) The laboratory coordinator only sees the test dates of tests that already have all dates registered in the system (test registration date, the chemical analysys date and the diagnosis date). 
> **The objective of this user story is only for the laboratory coordinator to be aware of the work developed in the chemical laboratory and to mark the job as done.**

> **Question:** Can the Specialist Doctor edit a report after the Laboratory Coordinator has already approved the report?
> 
> [**Awnser:**](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8268) No.

> **Question:** How should the laboratory coordinator choose the test to operate on, from a list of all the tests with a result and report or by inputting the code unique to a specific test?
>
> [**Awnser:**](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8264) From a list of all tests that have a test registration date, a chemical analysis date and a diagnosis date.

> **Question:** What information does the laboratory coordinator needs to be able do validate a test? We got from the description that it's suposed to show all dates. Should the system provide any more information?
>
> [**Awnser:**](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8270) Only the dates. Moreover, the system should record the validation date.

> **Question:** Does the laboratory coordinator choose which client's results to validate?
>
> [**Awnser:**](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8256) The laboratory coordinator chooses a set of tests he wants to validate.

> **Question:** Does the notification sent to client informing them that they have their results on the central application get sent automatically after the laboratory coordinator confirms the clinical chemistry technologist and specialist doctor's work?
>
> [**Awnser:**](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8256) From the Project Description: "Once the laboratory coordinator confirms that everything was done correctly, the client receives a notification alerting that the results are already available in the central application and informing that he/she must access the application to view those results."

> **Question:** After validation do we need to have the time and date of the validation?
>
> [**Awnser:**](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8408) Yes, the system should record the date (DD/MM/YYYY) and time (HH:MM) when the validation was made.
Moreover, in this US, when the system shows to the laboratory coordinator all the dates (test registration date, chemical analysis date and diagnosis date), the system should show the date (DD/MM/YYYY) and the time (HH:MM).

> **Question:** About the US 15, in the clarification says that the program just validates dates, but in the statement of work, referues the use of a external model that validate the reference values of the parameters.
>
> [**Awnser:**](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8505) Where did you saw that the program just validates dates? In the acceptance criteria of US 15 we get: "The system does not show client personal information but shows all dates (test registration date, chemical analysys date and diagnosis date)".

> **Question:** What's the Criteria to the validation of the test? We only receive dates but what do we have to do to check if everything is "ok" to validate?
>
> [**Awnser:**](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8538) The lab coordinator only checks the dates (date and time) and validates a subset of tests that he selects. The lab coordinador does not check any other information.
From a previous post: "The system shows all tests ready to validate (tests that already have the test registration date, the chemical analysis date and the diagnosis date registered in the system) and the laboratory coordinator selects one or more tests to mark as validated".

> **Question:** After we validate, we send the email saying they can check the app for the results. But what happens to the test ifself? Does it stay within the system or is deleted?
>
> [**Awnser:**](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8538) The tests should not be eliminated.

> **Question:**
>
> [**Awnser:**]()

### 1.3. Acceptance Criteria

*Insert here the client acceptance criteria.*

* **AC1:** The lab coordinator only checks the dates (date and time) and validates a subset of tests that he selects.
* **AC2:** The lab coordinador does not check any other information.
* **AC3:** The system shows all tests ready to validate (tests that already have the test registration date, the chemical analysis date and the diagnosis date registered in the system).
* **AC4:** The laboratory coordinator selects one or more tests to mark as validated.

### 1.4. Found out Dependencies

*Identify here any found out dependency to other US and/or requirements.*

* *There is a dependency to US4 - See the date when the test was registered.*
* *There is a dependency to US12 - See the date when the Chemical Analysis was performed.*
* *There is a dependency to US14 - See the date when the Diagnosis was made.*


### 1.5 Input and Output Data

*Identity here the data to be inputted by the system actor as well as the output data that the system have/needs to present in order to properly support the actor actions. Regarding the inputted data, it is suggested to distinguish between typed data and selected data (e.g. from a list)*

**Input Data:**

* Selected data:
  Test results

**Output Data:**
* (In)Success of the operation


### 1.6. System Sequence Diagram (SSD)

*Insert here a SSD depicting the envisioned Actor-System interactions and throughout which data is inputted and outputted to fulfill the requirement. All interactions must be numbered.*

![US15-SSD](US15_SSD.svg)


### 1.7 Other Relevant Remarks

*Use this section to capture other relevant information that is related with this US such as (i) special requirements ; (ii) data and/or technology variations; (iii) how often this US is held.* 

* The objective of this user story is only for the laboratory coordinator to be aware of the work developed in the chemical laboratory and to mark the job as done.

## 2. OO Analysis

### 2.1. Relevant Domain Model Excerpt 
*In this section, it is suggested to present an excerpt of the domain model that is seen as relevant to fulfill this requirement.* 

![US15_DM](US15_DM.svg)

### 2.2. Other Remarks

*Use this section to capture some aditional notes/remarks that must be taken into consideration into the design activity. In some case, it might be usefull to add other analysis artifacts (e.g. activity or state diagrams).* 



## 3. Design - User Story Realization 

### 3.1. Rationale

**The rationale grounds on the SSD interactions and the identified input/output data.**

| Interaction ID | Question: Which class is responsible for... | Answer  | Justification (with patterns)  |
|:-------------  |:--------------------- |:------------|:---------------------------- |
| Step 1  		 | ... interacting with the actor?                                 | ValidateWorkUI                | **Pure Fabrication**: There is no justification for assigning this responsibility to any existing class in the Domain Model.                                                                           |
|                | ... coordinating the US?                                        | ValidateWorkController        | **Controller**                                                                                                                                                                                         |
| Step 2  		 | ... know the existing tests that are waiting for the Lab Coordinator Validation? | TestStore    | **IE**: Knows all the tests.                                                                                                                                                                           |
|                | ... knows TestStore?                                            | Company                       | **IE**: The company knows the TestStore to which it is delegating some tasks.                                                                                                                          |
|                | ... transfer domain data in DTO?                                | TestMapper                    | **DTO**: So that the UI does not have direct access to objects in the domain it is better to choose to use a DTO.                                                                                      |
| Step 3         | ... instantiating a Lab Coordinator Validation?                 | Test                          | **Creator (R1)**                                                                                                                                                                                       | 
| Step 4         | ... showing the Dates                                           | ValidateWorkUI                | **Pure Fabrication**: There is no justification for assigning this responsibility to any existing class in the Domain Model.
| Step 5         | ... validate Dates                                              | LabCoordinatorValidation      | **IE**: Owns its data.|
| Step 6  		 | ... knows Client Data?                                          | Client                        | **IE**: Owns its data.
|        		 | ... recording the Validation Date?                              | LabCoordinatorValidation      | **IE**: Owns its data.|
|                | ... notify the client by email                                  | EmailResult                   | **IE** and **Pure Fabrication**: has all the required information and means to send the email (IE)                                                                                                                                                 |
|                | ... notify the client by SMS                                    | SMSResult                     | **IE** and **Pure Fabrication**: has all the required information and means to send the email (IE)
| Step 7  		 | ... informing operation success?                                | CreateMedicalReportUI         | **IE**: Is responsible for user interactions.                                                                                                                                                          |

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

 * Company
 * Test

Other software classes (i.e. Pure Fabrication) identified: 

 * ValidateWorkUI  
 * ValidateWorkController
 * TestStore
 * TestMapper
 * TestDto
 * DateDTO
 * DateMapper
 * RegistrationDateDto
 * ChemicalAnalysisDto
 * DiagnosisDto
 * EmailResult
 * SMSResult
 * LabCoordinatorValidation
 * Client

## 3.2. Sequence Diagram (SD)

*In this section, it is suggested to present an UML dynamic view stating the sequence of domain related software objects' interactions that allows to fulfill the requirement.* 

![US15-SD](US15_SD.svg)

## 3.3. Class Diagram (CD)

*In this section, it is suggested to present an UML static view representing the main domain related software classes that are involved in fulfilling the requirement as well as and their relations, attributes and methods.*

![US15-CD](US15_CD.svg)

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





