package com.visa.kigen.model;

import java.io.Serializable;

import lombok.Data;
@Data
public class HomeModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String username;
    private String visa;
    private String remday;
    private int color;
    private String memo;
    private String visanumber;
    private String search;
    private String searchkey;
    private int searchid;
    private String searchuser;
    private String searchvisanumber;
    

    public HomeModel() {
    }
}
