# Supplementary Specification (FURPS+)

## Functionality

_Specifies functionalities that:_

- _are common across several US/UC;_
- _are not related to US/UC, namely: Audit, Reporting and Security._

### _Auditing_

### _Authentication_

>All those who wish to use the application must be authenticated with a password holding seven alphanumeric characters, including three capital letters and two digits.

### _Communication_

### _Email_

### _Error Management_

### _Help_

>The accuracy of the prediction models should be analysed and
documented in the application user manual (in the annexes) that must be delivered with the
application.

>At least two sorting algorithms should be evaluated and
documented in the application user manual.

>All algorithms implemented should be documented in the annexes of user manual.The time complexity analysis of the algorithms should be properly documented in the application user manual (in the annexes) that must be delivered with the application.

>The complexity analysis must be accompanied by the observation of the execution time of the
algorithms for inputs of variable size in order to observe the asymptotic behaviour.

### _Licensing_

### _Localization_ 

> The application must support the English language only.

### _Printing_

### _Scheduling_

### _Security_
  
### _System Management_
  
### _Workflow_

>Only the specialist doctor is allowed to access all client data.

>At the same time that the client receives a notification about his test results, this information becomes available for the medical lab technicians, the clinical chemistry technologist, the specialist doctor, and the laboratory coordinator.

>Once the laboratory coordinator confirms that everything was done correctly, the client receives a notification alerting that the
results are already available in the central application and informing that he/she must access the
application to view those results.


________
## Usability 

_Evaluates the **user interface**. It has several subcategories,
among them: error prevention; interface aesthetics and design; help and
documentation; consistency and standards._

### _Consistency and Standards_

### _Error Prevention_

### _Help and Documentation_

### _Interface Asthetics and Design_
______
## Reliability
_Refers to the integrity, compliance and interoperability of the software. The requirements to be considered are: frequency and severity of failure, possibility of recovery, possibility of prediction, accuracy, average time between failures._

### _Accuracy_

>To make the predictions, the NHS contract defines that a linear regression algorithm should be used.

>The NHS required that both simple linear and multiple linear regression algorithms should be evaluated to select the best model.

### _Availability_

### _Average Time Between Failures_

### _Frequency and Severity of Failure_

### _Recoverability_
______

## Performance
_Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability._
  
_______

## Supportability

_The supportability requirements gathers several characteristics, such as:
testability, adaptability, maintainability, compatibility,
configurability, installability, scalability and more._ 

### _Adaptability_

>The system should be developed having in mind the need to easily support other kinds of tests.

>The application must allow ordering the clients by TIN and by
name. 

### _Auditability_

### _Compatibility_

### _Configurability_

>The ordering algorithm to be used by the application must be defined through a configuration
file. 

>The brute-force algorithm to be used by the application must be defined through a configuration file.

### _Installability_

### _Localizability_

> The application must support the English language only.

### _Maintainability_

### _Scalability_

### _Testability_

>Implement unit tests for all methods except methods that implement Input/Output operations.

________
## +

### Design Constraints

_Specifies or constraints the system design process. Examples may include: programming languages, software process, mandatory standards/patterns, use of development tools, class library, etc._

>The application must be developed in Java language using the IntelliJ IDE or Netbeans.

>The application graphical interface is to be developed in JavaFX 11.

>The unit tests should be implemented using the JUnit 4 framework. 

>The JaCoCo plugin should be used to generate the coverage report.

>All the images/figures produced during the software development process should be recorded in SVG format.

>Use Javadoc to generate useful documentation for Java code.

>Adopt best practices for identifying requirements and for OO software analysis and design.
  
### Implementation Constraints

_Specifies or constraints the code or construction of a system
such as: mandatory standards/patterns, implementation languages,
database integrity, resource limits, operating system._

>The application must be developed in Java language using the IntelliJ IDE or Netbeans.

>The application graphical interface is to be developed in JavaFX 11.

>Adopt recognized coding standards (e.g., CamelCase).

>The application should use object serialization to ensure data persistence between two runs of the application 
  
### Interface Constraints

_Specifies or constraints the features inherent to the interaction of the
system being developed with other external systems._

>The company is also required to generate daily (automatic) reports with all the information demanded by the NHS and should send them to the NHS using their API.

>The application uses an external module that is responsible for doing an automatic validation using test reference values.

>Identifying each sample with a barcode that is automatically generated using an external API.


### Physical Constraints

_Specifies a limitation or physical requirement regarding the hardware used to house the system, as for example: material, shape, size or weight._


