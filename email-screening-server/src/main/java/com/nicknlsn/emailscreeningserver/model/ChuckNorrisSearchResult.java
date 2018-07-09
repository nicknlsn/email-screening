package com.nicknlsn.emailscreeningserver.model;

import java.util.List;

public class ChuckNorrisSearchResult {
    private List<ChuckNorrisJoke> result;
    private Long total;

    public ChuckNorrisSearchResult() {
    }

    public List<ChuckNorrisJoke> getResult() {
        return result;
    }

    public void setResult(List<ChuckNorrisJoke> result) {
        this.result = result;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
