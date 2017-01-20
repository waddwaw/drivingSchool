package com.yoflying.drivingschool.coachStudents.model;

/**
 * Created by arvin on 2017/1/20.
 */
public class StudentModel {

    private String dsName;
    private String myCoach;
    private long myCoachId;
    private long myId;
    private String announcement;
    private String level;
    private String phone;
    private String comments;
    private String dsLogo;
    private String course;

    public String getDsName() {
        return dsName;
    }

    public void setDsName(String dsName) {
        this.dsName = dsName;
    }

    public String getMyCoach() {
        return myCoach;
    }

    public void setMyCoach(String myCoach) {
        this.myCoach = myCoach;
    }

    public long getMyCoachId() {
        return myCoachId;
    }

    public void setMyCoachId(long myCoachId) {
        this.myCoachId = myCoachId;
    }

    public long getMyId() {
        return myId;
    }

    public void setMyId(long myId) {
        this.myId = myId;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDsLogo() {
        return dsLogo;
    }

    public void setDsLogo(String dsLogo) {
        this.dsLogo = dsLogo;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
