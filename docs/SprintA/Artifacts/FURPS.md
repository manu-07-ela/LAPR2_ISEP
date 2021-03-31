# Supplementary Specification (FURPS+)

## Functionality

_Specifies functionalities that:_

- _are common across several US/UC;_
- _are not related to US/UC, namely: Audit, Reporting and Security._



### _Localization_ ###
- The aplication can only support English language." The application must support the English language only."

### _Email_ ###
- When the results are available, the cliente receives a notification via SMS and e-mail."The client receives the notification by SMS and e-mail"

### _Security_ ###
- All users have a password to access the aplication."All those who wish to use the
  application must be authenticated with a password holding seven alphanumeric characters,
  including three capital letters and two digits."
  
### _Workflow_ ###
- Before sending a notification to a client, the system has to check that everything is ready and verified.11th paragraph of the enunciated.
- The system has to have an algorithm that calculates the difference between the number of new tests and the number of tesults available.13th paragraph of enunciated.


## Usability 

_Evaluates the user interface. It has several subcategories,
among them: error prevention; interface aesthetics and design; help and
documentation; consistency and standards._


(fill in here )

## Reliability
_Refers to the integrity, compliance and interoperability of the software. The requirements to be considered are: frequency and severity of failure, possibility of recovery, possibility of prediction, accuracy, average time between failures._


(fill in here )

## Performance
_Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability._


(fill in here )

## Supportability
_The supportability requirements gathers several characteristics, such as:
testability, adaptability, maintainability, compatibility,
configurability, installability, scalability and more._ 



(fill in here )


## +

### Design Constraints

_Specifies or constraints the system design process. Examples may include: programming languages, software process, mandatory standards/patterns, use of development tools, class library, etc._

- The system must be coded in java using Intellij IDE or Netbeans and the graphical interface must be developed in JavaFX 11."The application must be developed in Java language using the IntelliJ IDE or Netbeans. The
application graphical interface is to be developed in JavaFX 11."
  
- The system need to have unit tests for all methods except methods that implement Input or Output Operations , using the JUnit 4 framework."The development team must implement unit tests for all methods except methods that implement
  Input/Output operations. The unit tests should be implemented using the JUnit 4 framework."
  
- All images or figures should be recorded in SVG format."All the images/figures produced during the software development process should be recorded in
  SVG format."


### Implementation Constraints

_Specifies or constraints the code or construction of a system such
such as: mandatory standards/patterns, implementation languages,
database integrity, resource limits, operating system._


(fill in here )


### Interface Constraints
_Specifies or constraints the features inherent to the interaction of the
system being developed with other external systems._


The program has to comunicate with external aplications or API'S."...and identifying each sample with a barcode that is
automatically generated using an external API."

### Physical Constraints

_Specifies a limitation or physical requirement regarding the hardware used to house the system, as for example: material, shape, size or weight._

(fill in here )