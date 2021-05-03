package app.domain.store;

import app.domain.model.ParameterCategory;
import app.domain.model.TestType;

import java.util.ArrayList;
import java.util.List;

/**
 * The different types of tests that exist in a company.
 */
public class TestTypeStore {

    /**
     * List containing all types of tests that exist in a company.
     */
    List<TestType> testTypeList = new ArrayList();

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

    /**
     * Adds a new test type to the List.
     * @param testType
     */
    public void addTestType(TestType testType) {
        testTypeList.add(testType);
    }

    /**
     * Save the type of test case it is in a valid state
     * @param testType The type of test we intend to save
     * @return true if the test type was saved. Otherwise, false.
     */
    public boolean saveParameterCategory(TestType testType) {
        if (!validateTestType(testType))
            return false;
        return this.testTypeList.add(testType);
    }
}
