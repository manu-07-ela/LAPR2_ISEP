# Supplementary Specification (FURPS+)

## Functionality

_Specifies functionalities that:_

- _are common across several US/UC;_
- _are not related to US/UC, namely: Audit, Reporting and Security._



### _Localization_ ###
- The aplication can only support English language." The application must support the English language only."

### _Email_ ###
- When the results are available, the client receives a notification via SMS and e-mail."The client receives the notification by SMS and e-mail"

### _Help_ ###
- All algorithms implemented should be documented in the annexes of user manual."The time
  complexity analysis of the algorithms should be properly documented in the application user
  manual (in the annexes) that must be delivered with the application."

### _Printing_ ###
- At the same time that the client receives a notification about his test results, this information becomes available for the medical lab technicians, the clinical chemistry technologist, the specialist doctor, and the laboratory
  coordinator.

### _Security_ ###
- All users have a password to access the aplication."All those who wish to use the
  application must be authenticated with a password holding seven alphanumeric characters,
  including three capital letters and two digits."
  
### _Workflow_ ###
- Before sending a notification to a client, the system has to check that everything is ready and verified.11th paragraph of the enunciated.
- The system has to have an algorithm that calculates the difference between the number of new tests, and the number of results available.13th paragraph of enunciated.

## Usability 

_Evaluates the user interface. It has several subcategories,
among them: error prevention; interface aesthetics and design; help and
documentation; consistency and standards._

- The system will instruct the user to enter the data correctly, and it will display a message if the user has entered the data incorrectly.
- We must use Javadoc to generate documentation for Java code. "use Javadoc to generate useful documentation for Java code."

## Reliability
_Refers to the integrity, compliance and interoperability of the software. The requirements to be considered are: frequency and severity of failure, possibility of recovery, possibility of prediction, accuracy, average time between failures._


(fill in here )

## Performance
_Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability._
- "The complexity analysis must be accompanied by the observation of the execution time of the
algorithms for inputs of variable size in order to observe the asymptotic behaviour."

(fill in here )

## Supportability
_The supportability requirements gathers several characteristics, such as:
testability, adaptability, maintainability, compatibility,
configurability, installability, scalability and more._ 
- The aplication must support another types of test besides Covid-19 and Blood Tests.
- The aplication must order clients by TIF and name.
### Testability
- The system need to have unit tests for all methods except methods that implement Input or Output Operations , using the JUnit 4 framework."The development team must implement unit tests for all methods except methods that implement
    Input/Output operations. The unit tests should be implemented using the JUnit 4 framework."

### Configurability
- Some algorithms must be defined through a the configuration file, for example, the algorithm to order the clients by TIF and by name."The ordering algorithm to be used by the application must be defined through a configuration
  file."
  
## +

### Design Constraints

_Specifies or constraints the system design process. Examples may include: programming languages, software process, mandatory standards/patterns, use of development tools, class library, etc._

- The system must be coded in java using Intellij IDE or Netbeans.
  
- All images or figures should be recorded in SVG format."All the images/figures produced during the software development process should be recorded in
  SVG format."
  



### Implementation Constraints

_Specifies or constraints the code or construction of a system
such as: mandatory standards/patterns, implementation languages,
database integrity, resource limits, operating system._

- The system must be coded in java adopting the best practices of OO software analysis and design."During system development, the team must: (i) adopt best practices for identifying requirements
  and for OO software analysis and design","The application should use object serialization to ensure data persistence between two runs of the
  application."


### Interface Constraints
_Specifies or constraints the features inherent to the interaction of the
system being developed with other external systems._

-"The application graphical interface is to be developed in JavaFX 11."

- The program has to comunicate with API'S."...and identifying each sample with a barcode that is
automatically generated using an external API."
- The program communicates with an external module to validate the work performed by specialist doctor."To facilitate and simplify the validation work performed by the specialist doctor, the application
  uses an external module that is responsible for doing an automatic validation using test reference
  values."
- The program has to send automatic daily reports with all the information required by the NHS using the NHS API.
### Physical Constraints

_Specifies a limitation or physical requirement regarding the hardware used to house the system, as for example: material, shape, size or weight._

(fill in here )