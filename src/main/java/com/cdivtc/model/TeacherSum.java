package com.cdivtc.model;

import java.io.Serializable;

public class TeacherSum implements Serializable {
    private String tName;
    private Integer zks;
    private Integer sk;
    private Integer zb;

    public TeacherSum() {
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public Integer getZks() {
        return zks;
    }

    public void setZks(Integer zks) {
        this.zks = zks;
    }

    public Integer getSk() {
        return sk;
    }

    public void setSk(Integer sk) {
        this.sk = sk;
    }

    public Integer getZb() {
        return zb;
    }

    public void setZb(Integer zb) {
        this.zb = zb;
    }

    @Override
    public String toString() {
        return "TeacherSum{" +
                "tName='" + tName + '\'' +
                ", zks=" + zks +
                ", sk=" + sk +
                ", zb=" + zb +
                '}';
    }
}
