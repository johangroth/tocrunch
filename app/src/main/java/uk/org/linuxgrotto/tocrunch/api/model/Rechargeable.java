package uk.org.linuxgrotto.tocrunch.api.model;


public class Rechargeable {


    protected String value;
    protected Long customerId;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long value) {
        this.customerId = value;
    }

}
