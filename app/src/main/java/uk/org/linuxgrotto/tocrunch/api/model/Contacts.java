package uk.org.linuxgrotto.tocrunch.api.model;

import java.util.ArrayList;
import java.util.List;


public class Contacts {

    protected List<Contact> contact;

    protected int count;

    public List<Contact> getContact() {
        if (contact == null) {
            contact = new ArrayList<Contact>();
        }
        return this.contact;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
