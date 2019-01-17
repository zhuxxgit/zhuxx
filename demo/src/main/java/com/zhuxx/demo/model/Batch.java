package com.zhuxx.demo.model;


import java.util.Date;

public class Batch {
    private int batch_id;
    private int cus_id;
    private String number;
    private Date createtime;
    private String note;

    public int getBatch_id() {
        return batch_id;
    }

    public int getCus_id() {
        return cus_id;
    }

    public String getNumber() {
        return number;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public String getNote() {
        return note;
    }

    public void setBatch_id(int batch_id) {
        this.batch_id = batch_id;
    }

    public void setCus_id(int cus_id) {
        this.cus_id = cus_id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
