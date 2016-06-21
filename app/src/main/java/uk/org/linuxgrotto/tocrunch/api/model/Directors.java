package uk.org.linuxgrotto.tocrunch.api.model;

import java.util.ArrayList;
import java.util.List;

public class Directors {

    protected List<Director> director;

    protected int count;

    public List<Director> getDirector() {
        if (director == null) {
            director = new ArrayList<Director>();
        }
        return this.director;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int value) {
        this.count = value;
    }

}
