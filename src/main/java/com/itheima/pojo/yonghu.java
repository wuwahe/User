package com.itheima.pojo;

public class yonghu {
    private long id;
    private String uesrr;
    private String passwd;

    public yonghu() {
    }

    public yonghu(long id, String userr, String passwd) {
        this.id = id;
        this.uesrr = userr;
        this.passwd = passwd;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUesrr() {
        return uesrr;
    }

    public void setUesrr(String uesrr) {
        this.uesrr = uesrr;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
