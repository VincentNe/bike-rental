package com.csharp.bikerental.persistence.model;


public class UserEditSaver {
    private int UserId;
    private String UserName;
    private String UserPhoneNo;
    private String NFCID;

    public UserEditSaver(int userId, String userName, String userPhoneNo, String NFCID) {
        UserId = userId;
        UserName = userName;
        UserPhoneNo = userPhoneNo;
        this.NFCID = NFCID;
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

    @Override
    public String toString() {
        return "UserEditSaver{" +
                "UserId='" + UserId + '\'' +
                ", UserName='" + UserName + '\'' +
                ", UserPhoneNo='" + UserPhoneNo + '\'' +
                ", NFCID='" + NFCID + '\'' +
                '}';
    }
}
