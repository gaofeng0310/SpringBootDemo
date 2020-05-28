package com.xnpool.gaogtest.request;

public class BaseRequest {
    Integer page;
    Integer size;

    public int getPage() {
        if(page == null){
            return 1;
        }
        return page;
    }

    public int getSize() {
        if(size==null){
            return 10;
        }
        return size;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
