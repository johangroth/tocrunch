package uk.org.linuxgrotto.tocrunch.api.model;


public class Contact {

    protected String name;
    protected String email;
    protected String telephone;
    protected String role;

    protected boolean includeInEmail;

    protected boolean primaryContact;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isIncludeInEmail() {
        return includeInEmail;
    }

    public void setIncludeInEmail(boolean includeInEmail) {
        this.includeInEmail = includeInEmail;
    }

    public boolean isPrimaryContact() {
        return primaryContact;
    }

    public void setPrimaryContact(boolean primaryContact) {
        this.primaryContact = primaryContact;
    }
}
