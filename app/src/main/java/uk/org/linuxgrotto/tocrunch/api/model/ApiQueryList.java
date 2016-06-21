package uk.org.linuxgrotto.tocrunch.api.model;


public class ApiQueryList {

    protected long count;
    protected Integer firstResult;
    protected Integer resultsPerPage;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Integer getFirstResult() {
        return firstResult;
    }

    public void setFirstResult(Integer firstResult) {
        this.firstResult = firstResult;
    }

    public Integer getResultsPerPage() {
        return resultsPerPage;
    }

    public void setResultsPerPage(Integer resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }
}
