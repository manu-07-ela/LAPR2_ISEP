# US 09 - Specify a Type of Test

## 1. Requirements Engineering

### 1.1. User Story Description

As an administrator, I want to specify a new type of test and its collecting methods.

### 1.2. Customer Specifications and Clarifications 

**From the specifications document:**

>Many Labs performs two types of tests.

**From the client clarifications:**

> **Question:** <br />Does a type of test holds any attribute besides it's name and collecting methods?
>
> [_**Answer:**_](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=7512#p10171) <br />The attributes for a new test type are:
> * Code; 
> * Description;
> * Collecting Method;
> * Set of categories;

> **Question:**<br /> Are the collecting methods stored simpled as a word or a sentence, or does it also must contain it's description, and/or another attributes?
>
> [_**Answer:**_](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=7512#p10171) <br />The administrator introduces a brief description for specifying the collecting method and there exists only one collection method per test type.

> **Question:** <br /> What do you mean by the collecting methods and  what collecting methods  are available?
>
> [_**Answer:**_](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=7752#p10120) <br /> To make a Covid test you need a swab to collect a sample. To make a blood test you need sample tubes and a syringe. 

> **Question:** <br /> Are there any different collecting methods other than the ones currently known? Which ones?
>
> [_**Answer:**_](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=7514#p10172) <br /> Each collecting method is associated with a test type. Whenever a test type is created a collecting method should be defined.


### 1.3. Acceptance Criteria

* **AC1:** The code is not automatically generated and has five alphanumeric characters.
* **AC2:** The description is a string with a maximum of 15 characters.
* **AC3:** The collecting Method is a string with no more than 20 characters.
* **AC4:** Each category should be chosen from a list of categories.

### 1.4. Found out Dependencies

* *Identify here any found out dependency to other US and/or requirements.*

* **Depends on US11** - The categories that the test will have have to be created previously


### 1.5 Input and Output Data

**Input Data:**

* Typed data:
	* code
    * description
	* collecting method
	
* Selected data:
	* parameter category
	
**Output Data:**

* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

**Alternative 1**

![US09_SSD](US09_SSD.svg)

**Other alternatives might exist.**

### 1.7 Other Relevant Remarks

## 2. OO Analysis

### 2.1. Relevant Domain Model Excerpt 

![US09_DM](US09_DM.svg)

### 2.2. Other Remarks

n/a

## 3. Design - User Story Realization 

### 3.1. Rationale

**SSD - Alternative 1 is adopted.**

| Interaction ID | Question: Which class is responsible for...                     | Answer                   | Justification (with patterns)                                                                                             |
|:-------------  |:--------------------------------------------------------------- |:------------------------:|:------------------------------------------------------------------------------------------------------------------------- |
| Step 1  		 | ... interacting with the actor?                                 | CreateTestTypeUI         | Pure Fabrication: there is no justification for assigning this responsibility to any existing class in the Domain Model.  |
|                | ... coordinating the US?                                        | CreateTestTypeController | Controller                                                                                                                |
|                | ... knowing who is responsible for creating test type instances?| Company                  | Creator (R1)                                                                                                              |
|                | ... creates Test Type instance?                                 | TestTypeStore            | HC+LC on the Company. By HC / LC the Company delegates these responsibilities in TestTypeStore.                           |
| Step 2  		 |                                                                 |                          |                                                                                                                           |
| Step 3  		 | ... saving the inputted data?                                   | TestType                 | IE: object created in step 1 has its own data.                                                                            |
| Step 4  		 | ... knowing the parameter categories to show?                   | ParameterCategoryStore   | IE: knows all the categories of parameters.                                                                               |
|                | ... process the data and convert it to dto                      | ParameterCategoryMapper  | Pure Fabrication: there is no justification for assigning this responsibility to any existing class in the Domain Model.  |
| Step 5  		 | ... saving the selected categories?                             | TestType                 | IE: the object created in step 1 contains one or more categories of parameters                                            |
| Step 6  		 |                                                                 |                          |                                                                                                                           |
| Step 7  		 | ... validating all data (local validation)?                     | TestType                 | IE: owns its data.                                                                                                        |
|                | ... validating all data (global validation)?                    | TestTypeStore            | IE: knows all types of tests.                                                                                             |
|                | ... saving the created test type?                               | TestTypeStore            | IE: owns all types of tests.                                                                                              |
| Step 8  		 | ... informing operation success?                                | CreateTestTypeUI         | IE: is responsible for user interactions.                                                                                 |

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

 * Company
 * TestType
 * ParameterCategory

Other software classes (i.e. Pure Fabrication) identified: 

 * CreateTestTypeUI  
 * CreateTestTypeController
 * ParameterCategoryStore  
 * TestTypeStore
 * ParameterCategoryMapper


## 3.2. Sequence Diagram (SD)

**Alternative 1**

![US09_SD](US09_SD.svg)

## 3.3. Class Diagram (CD)

**From alternative 1**

![US09_CD](US09_CD.svg)

# 4. Tests 
*In this section, it is suggested to systematize how the tests were designed to allow a correct measurement of requirements fulfilling.*

**_DO NOT COPY ALL DEVELOPED TESTS HERE_**


**Test 1:** Check that it is not possible to create an instance of the Test Type class with null values.

	@Test(expected = IllegalArgumentException.class)
    public void ensureNullIsNotAllowed(){
        TestType tt = new TestType(null,null,null,null);
    }

**Test 2:** Check that it is not possible to create an instance of the Test Type class with a code invalid - AC1.

	@Test(expected = IllegalArgumentException.class)
    public void ensureCodeMeetsAC1_1(){
        TestType tt = new TestType("1g3d7h","description","method",listPC);
    }

	@Test(expected = IllegalArgumentException.class)
	public void ensureCodeMeetsAC1_2(){
		TestType tt = new TestType("1g3","description","method",listPC);
	}

	@Test(expected = IllegalArgumentException.class)
    public void ensureCodeMeetsAC1_3(){
        TestType tt = new TestType("1.3","description","method",listPC);
    }

**Test 3:** Check that it is not possible to create an instance of the Test Type class with a description invalid - AC2.

    @Test(expected = IllegalArgumentException.class)
    public void ensureDescriptionMeetsAC2(){
        TestType tt = new TestType("1g3d7","descriptionteste","collectingMethodTest",listPC);
    }

    @Test
    public void ensureDescriptionMeetsAC2_1(){
        TestType tt = new TestType("1g354","descriptiontest","collectingsmethod",listPC);
        Assert.assertNotNull(tt);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureBlankDescriptioNotAllowed(){
        TestType tt = new TestType("1g3d7","","collectingMethodTest",listPC);
    }

**Test 4:** Check that it is not possible to create an instance of the Test Type class with a collecting method invalid - AC3.

    @Test(expected = IllegalArgumentException.class)
    public void ensureCollectingMethodMeetsAC3(){
        TestType tt = new TestType("1g354","description","collectingsmethodsteste",listPC);
    }

    @Test
    public void ensureCollectingMethodMeetsAC3_1(){
        TestType tt = new TestType("1g354","description","collectingsmethodstt",listPC);
        Assert.assertNotNull(tt);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureBlankCollectingMethodNotAllowed(){
        TestType tt = new TestType("1g354","description","",listPC);
    }

# 5. Construction (Implementation)
*In this section, it is suggested to provide, if necessary, some evidence that the construction/implementation is in accordance with the previously carried out design. Furthermore, it is recommeded to mention/describe the existence of other relevant (e.g. configuration) files and highlight relevant commits.*

*It is also recommended to organize this content by subsections.*


## Class CreateTestTypeController 

	/**
	* Get a list of objects of type ParameterCategoryDTO
	* @return list with parameterCategoriesDto
	*/
	public List<ParameterCategoryDto> getParameterCategories(){
		List<ParameterCategory> listParameterCategories = pcStore.getParameterCategoryList();
		return pcMapper.toDto(listParameterCategories);
	}

	/**
	* New test type.
	* @param code The test type code.
	* @param description The description of the test type.
	* @param collectingMethod The test type collecting method.
	* @param listOfParameterCategoriesDto List of parameter categories that the test type has associated.
	* @return false if the test type already exists or is null. Otherwise, it returns true.
	*/
	public boolean createTestType(String code, String description, String collectingMethod, List<ParameterCategoryDto> listOfParameterCategoriesDto){
		List<ParameterCategory> listOfParameterCategories = new ArrayList();
		for ( ParameterCategoryDto pcDto : listOfParameterCategoriesDto){
		listOfParameterCategories.add(pcStore.getParameterCategoryByCode(pcDto.getCode()));
		}
		this.tt=ttStore.createTestType(code,description,collectingMethod,listOfParameterCategories);
		return this.ttStore.validateTestType(tt);
	}

    /**
     * Save the type of test case it is in a valid state.
     * @return true if the test type was saved. Otherwise, false.
     */
    public boolean saveTestType() {
        return this.ttStore.saveTestType(tt);
    }


## Class Company

	/**
	* Get the instance of ParameterCategoryStore.
	* @return the instance of ParameterCategoryStore.
	*/
	public ParameterCategoryStore getParameterCategoryStore(){
		return parameterCategoryStore;
	}

	 /**
     * Get the instance of TestTypeStore.
     * @return the instance of TestTypeStore.
     */
    public TestTypeStore getTestTypeStore(){
        return testTypeStore;
    }

## Class TestTypeStore

	/**
     * New test type.
     * @param code The test type code.
     * @param description The description of the test type.
     * @param collectingMethod  The test type collecting method.
     * @param listOfParameterCategories List of parameter categories that the test type has associated.
     * @return The test type.
     */
    public TestType createTestType(String code, String description, String collectingMethod, List<ParameterCategory> listOfParameterCategories){
        return new TestType(code,description,collectingMethod,listOfParameterCategories);
    }

    /**
     * Global validation of a test type.
     * @param testType Test Type that we intend to validate.
     * @return false if the test type already exists or is null. Otherwise, it returns true.
     */
    public boolean validateTestType(TestType testType) {
        if (testType == null)
            return false;
        return !this.testTypeList.contains(testType);
    }



# 6. Integration and Demo 

*In this section, it is suggested to describe the efforts made to integrate this functionality with the other features of the system.*


# 7. Observations

*In this section, it is suggested to present a critical perspective on the developed work, pointing, for example, to other alternatives and or future related work.*

* In the future, the user story will be developed with a graphical interface, making the user experience more appealing.




