package com.visa.kigen.model;

import java.io.Serializable;

import lombok.Data;
@Data
public class RegressionModel implements Serializable {
 private static final long serialVersionUID = 1L;
    private int id;
    private String username;
    private String password;
    private String visa;
    private String visanumber;
    private String memo;

    public RegressionModel() {
    }
}