
package com.qianya.util;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private long totals;
    private int pages;
    private int page;
    private int size;
    private List<T> rows;
    private Map<String, Object> otherInfo;

    public PageResult() {
    }

    public PageResult(long totals, int pages, int page, int size, List<T> rows, Map<String, Object> otherInfo) {
        this.totals = totals;
        this.pages = pages;
        this.page = page;
        this.size = size;
        this.rows = rows;
        this.otherInfo = otherInfo;
    }

    public long getTotals() {
        return this.totals;
    }

    public void setTotals(long totals) {
        this.totals = totals;
    }

    public int getPages() {
        return this.pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<T> getRows() {
        return this.rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Map<String, Object> getOtherInfo() {
        return this.otherInfo;
    }

    public void setOtherInfo(Map<String, Object> otherInfo) {
        this.otherInfo = otherInfo;
    }
}
