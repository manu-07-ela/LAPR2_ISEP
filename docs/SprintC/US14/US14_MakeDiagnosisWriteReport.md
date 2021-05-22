# US 14 - Make the diagnosis and write a report 

## 1. Requirements Engineering

### 1.1. User Story Description

As a specialist doctor, I intend to make the diagnosis and write a report for a given test.

### 1.2. Customer Specifications and Clarifications 

**From the specifications document:**

>After completing the chemical analysis, the results of all chemical analyses are analysed by a
specialist doctor who makes a diagnosis and writes a report that afterwards will be delivered to the
client.

**From the client clarifications:**

> **Question:**<br /> Is there a limit of characters for the report and the diagnosis that will be made by the Specialist Doctor?
>
> [_**Answer:**_](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8182#p10891) <br /> Yes, the report is free text and should have no more than 400 words.

> **Question:**<br /> What characterizes a diagnosis?
>
> [_**Answer:**_](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8292#p10897) <br /> The report contains the diagnosis.

> **Question:**<br /> Can the Specialist Doctor edit a report once it has already been written?
>
> [_**Answer:**_](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8268#p10898) <br /> No.

> **Question:**<br /> Should the specialist doctor choose from a list of tests?
>
> [_**Answer:**_](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8250#p10889) <br /> The system shows all tests ready to make the diagnosis and the Specialist Doctor selects one test.

> **Question:**<br /> What fields should the specialist doctor report have?
>
> [_**Answer:**_](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8178#p10705) <br />

### 1.3. Acceptance Criteria

* **AC1:** The report is free text and should have no more than 400 words.

### 1.4. Found out Dependencies

* There is a dependency to "US12 Record the results of a given test" because the results of the chemical analysis have to be in the system for the specialist doctor to be able to make a diagnosis.

### 1.5 Input and Output Data

**Input Data:**

* Typed data:
	* Medical Report
	
* Selected data:
	* Test

**Output Data:**

* List of existing tests in the Samples Analyzed state
* List of parameters tests
* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

**Alternative 1**

![US14_SSD](US14_SSD.svg)

**Other alternatives might exist.**

### 1.7 Other Relevant Remarks

* The test goes to the Diagnosis made status after the conclusion of the medical report.

## 2. OO Analysis

### 2.1. Relevant Domain Model Excerpt 

![US14_MD](US14_MD.svg)

### 2.2. Other Remarks

n/a

## 3. Design - User Story Realization 

### 3.1. Rationale

**SSD - Alternative 1 is adopted.**

| Interaction ID | Question: Which class is responsible for...                     | Answer                        | Justification (with patterns)                                                                                                                                                                          |
|:-------------  |:--------------------------------------------------------------- |:-----------------------------:|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| Step 1  		 | ... interacting with the actor?                                 | CreateMedicalReportUI         | **Pure Fabrication**: there is no justification for assigning this responsibility to any existing class in the Domain Model.                                                                           |
|                | ... coordinating the US?                                        | CreateMedicalReportController | **Controller**                                                                                                                                                                                         |
| Step 2  		 | ... know the existing tests?                                    | TestStore                     | **IE**:                                                                                                                                                                                                |
|                | ... knows TestStore?                                            | Company                       | **IE**:                                                                                                                                                                                                |
|                | ... transfer domain data in DTO?                                | TestDto                       | **DTO**:                                                                                                                                                                                               |
| Step 3  		 |                                                                 |                               |                                                                                                                                                                                                        |
| Step 4  		 | ... knowing the test parameters?                                | Test                          | **IE**:                                                                                                                                                                                                |
|                | ... process the data and convert it to dto                      |                               |                                                                                                                                                                                                        |
| Step 5  		 | ... saving the inputted data?                                   |                               |                                                                                                                                                                                                        |
| 		         | ... instantiating a new Medical Report?                         |                               | **Creator (R1)** and **HC+LC**: By the application of the Creator (R1) it would be the "Company". But, by applying HC + LC to the "Company", this delegates that responsibility to the ""              |
|        		 | ... validating all data (local validation)?                     |                               | IE: owns its data.                                                                                                                                                                                     |
| Step 6  		 |                                                                 |                               |                                                                                                                                                                                                        |
| Step 7  		 | ... validating all data (global validation)?                    |                               | IE: owns its data.                                                                                                                                                                                     |
| Step 8  		 | ... informing operation success?                                | CreateMedicalReportUI         | IE: is responsible for user interactions.                                                                                                                                                              |

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

 * Company
 * Test

Other software classes (i.e. Pure Fabrication) identified: 

 * CreateMedicalReportUI
 * CreateMedicalReportController
 * TestStore
 * TestDto

## 3.2. Sequence Diagram (SD)

**Alternative 1**

![US14_SD](US14_SD.svg)

## 3.3. Class Diagram (CD)

**From alternative 1**

![US14_CD](US14_CD.svg)

# 4. Tests

# 5. Construction (Implementation)

# 6. Integration and Demo 

# 7. Observations







