package app.domain.model.attributes;

import org.apache.commons.lang3.StringUtils;

public class Address {
    private String address;

    public String getAddress() {
        return address;
    }

    public Address(String address) {
        if (isValidAddress(address)) throw new IllegalArgumentException("ERROR: Address can not be blank");
        this.address = address;
    }

    private boolean isValidAddress(String address){
        return StringUtils.isBlank(address);
    }
}
