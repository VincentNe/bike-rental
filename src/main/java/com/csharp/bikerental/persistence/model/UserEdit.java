package com.csharp.bikerental.persistence.model;

public class UserEdit {
    private int UserId;
    private String UserName;
    private String UserPhoneNo;
    private String NFCID;


    public UserEdit(int userId, String userName, String userPhoneNo, String NFCID) {
        this.UserId = userId;
        this.UserName = userName;
        this.UserPhoneNo = userPhoneNo;
        this.NFCID = NFCID;
    }

    public UserEdit() {
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserPhoneNo() {
        return UserPhoneNo;
    }

    public void setUserPhoneNo(String userPhoneNo) {
        UserPhoneNo = userPhoneNo;
    }

    public String getNFCID() {
        return NFCID;
    }

    public void setNFCID(String NFCID) {
        this.NFCID = NFCID;
    }

    public UserEditSaver Saveto(){
        UserEditSaver saver = new UserEditSaver(this.UserId,this.UserName,this.UserPhoneNo,this.NFCID);
        return  saver;
    }

    public void undoSave(UserEditSaver undosaver){
        this.UserId = undosaver.getUserId();
        this.UserName = undosaver.getUserName();
        this.UserPhoneNo = undosaver.getUserPhoneNo();
        this.NFCID = undosaver.getNFCID();

    }

    @Override
    public String toString() {
        return "UserEdit{" +
                "UserId='" + UserId + '\'' +
                ", UserName='" + UserName + '\'' +
                ", UserPhoneNo='" + UserPhoneNo + '\'' +
                ", NFCID='" + NFCID + '\'' +
                '}';
    }

    public void printInfo(){
        System.out.println("ID: "+ this.UserId);
        System.out.println("Name: "+ this.UserName);
        System.out.println("Phone Number: "+ this.UserPhoneNo);
        System.out.println("NFCID: "+ this.NFCID);

    }
}
