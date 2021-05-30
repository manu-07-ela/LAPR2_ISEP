package app.domain.model.attributes;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * Represents a National Healthcare Service code of a test
 * @author José Pessoa <1201007@isep.ipp.pt>
 */
public class NhsCode {

        /**
         * The National Healthcare Service code of a test
         */
        private String code;

        /**
         * Create a National Healthcare Service code instance receiving a National Healthcare Service code by parameter
         * @param code the SOC code of an employee
         */
        public NhsCode(String code) {
            nhscodeValidation(code);
            this.code = code;
        }

        /**
         * Copy builder of National Healthcare Service code
         * @param code the National Healthcare Service code
         */
        public NhsCode(NhsCode code){
            this.code = code.getCode();
        }
        /**
         * Get the National Healthcare Service code of a test
         * @return the National Healthcare Service code
         */
        public String getCode() {
            return code;
        }

        /**
         * Checks if the business rules applied to the National Healthcare Service code are respected
         * @param nhscode the National Healthcare Service code
         */
        private void nhscodeValidation(String nhscode) {
            if (!StringUtils.isNumeric(nhscode))
                throw new IllegalArgumentException("National Healthcare Service code is numeric only.");
            if (nhscode.length() != 12) {
                throw new IllegalArgumentException("The National Healthcare Service code must have 12 digits");
            }
        }

        /**
         * Compare the National Healthcare Service code with other object received
         * @param other Object we want to compare with the National Healthcare Service code
         * @return true if the received object represents another National Healthcare Service code equivalent to the National Healthcare Service code. Otherwise, it returns false.
         */
        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            if (other == null || getClass() != other.getClass()) return false;
            app.domain.model.attributes.NhsCode nhsCode1 = (app.domain.model.attributes.NhsCode) other;
            return Objects.equals(code, nhsCode1.code);
        }
}
