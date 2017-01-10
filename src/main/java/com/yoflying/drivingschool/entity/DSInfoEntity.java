package com.yoflying.drivingschool.entity;

/**
 * Created by liqiang on 17/1/10.
 */
public class DSInfoEntity {

    private String dsName;
    private String address;
    private String dsLogo;
    private int studentTotal;
    private int coachTotal;

    public String getDsName() {
        return dsName;
    }

    public void setDsName(String dsName) {
        this.dsName = dsName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDsLogo() {
        return dsLogo;
    }

    public void setDsLogo(String dsLogo) {
        this.dsLogo = dsLogo;
    }

    public int getStudentTotal() {
        return studentTotal;
    }

    public void setStudentTotal(int studentTotal) {
        this.studentTotal = studentTotal;
    }

    public int getCoachTotal() {
        return coachTotal;
    }

    public void setCoachTotal(int coachTotal) {
        this.coachTotal = coachTotal;
    }
}
