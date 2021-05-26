# Supplementary Specification (FURPS+)

## Functionality

_Specifies functionalities that:_
- _are common across several US/UC;_
- _are not related to US/UC, namely: Audit, Reporting and Security._

### _Authentication_
- All those who wish to use the application must be authenticated with a password holding ten alphanumeric characters, generated automatically by the System.

________
## Usability 

_Evaluates the **user interface**. It has several subcategories,
among them: error prevention; interface aesthetics and design; help and
documentation; consistency and standards._

### _Interface Asthetics and Design_
- The user interface must be simple, intuitive and consistent.

______
## Reliability
_Refers to the integrity, compliance and interoperability of the software. The requirements to be considered are: frequency and severity of failure, possibility of recovery, possibility of prediction, accuracy, average time between failures._

### _Accuracy_

- To make the predictions, the NHS contract defines that a linear regression algorithm should be used.

- The NHS required that both simple linear and multiple linear regression algorithms should be evaluated to select the best model.

- At least two sorting algorithms should be evaluated.

### _Frequency and Severity of Failure_
- The system should not fail more than 5 days in one year. Whenever the system fails, there should be no data loss.
______

## Performance
_Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability._

### _Start-up Time_

- The system should start up in less than 10 seconds.

### _Throughput_
- The complexity analysis must be accompanied by the observation of the execution time of the
  algorithms for inputs of variable size in order to observe the asymptotic behaviour.

### _Response Time_
- Any interface between a user and the system shall have a maximum response time of 3 seconds.
_______

## Supportability

_The supportability requirements gathers several characteristics, such as:
testability, adaptability, maintainability, compatibility,
configurability, installability, scalability and more._ 

### _Adaptability_

- The system should be developed having in mind the need to easily support other kinds of tests.

- The application should run on all platforms for which there exists a Java Virtual Machine.

### _Configurability_

- The ordering algorithm to be used by the application must be defined through a configuration
file. 

- The application must allow ordering the clients by TIN and by
  name.

- The brute-force algorithm to be used by the application must be defined through a configuration file.

### _Testability_

- Implement unit tests for all methods except methods that implement Input/Output operations. 
  
### _Localizability_

- The application must support the English language only.
________
## +

### Design Constraints

_Specifies or constraints the system design process. Examples may include: programming languages, software process, mandatory standards/patterns, use of development tools, class library, etc._

#### _Software process_

- Adopt best practices for identifying requirements and for OO software analysis and design.

#### _Use of development tools_

- The unit tests should be implemented using the JUnit 4 framework. 

- The JaCoCo plugin should be used to generate the coverage report.

- All the images/figures produced during the software development process should be recorded in SVG format.

- Use Javadoc to generate useful documentation for Java code.


  
### Implementation Constraints

_Specifies or constraints the code or construction of a system
such as: mandatory standards/patterns, implementation languages,
database integrity, resource limits, operating system._

#### _Implementation languages_

- The application must be developed in Java language using the IntelliJ IDE or Netbeans.

- The application graphical interface is to be developed in JavaFX 11.

#### _Mandatory standards/patterns_
- Adopt recognized coding standards (e.g., CamelCase).

- The application should use object serialization to ensure data persistence between two runs of the application 

#### _Resource limits_
- The application will be deployed to a machine with 8GB of RAM.


### Interface Constraints

_Specifies or constraints the features inherent to the interaction of the
system being developed with other external systems._

- The company is also required to generate daily (automatic) reports with all the information demanded by the NHS and should send them to the NHS using their API.

- The application uses an external module that is responsible for doing an automatic validation using test reference values.

- Identifying each sample with a barcodeDomain that is automatically generated using an external API.


### Physical Constraints

_Specifies a limitation or physical requirement regarding the hardware used to house the system, as for example: material, shape, size or weight._

_________

















