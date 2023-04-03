package com.visa.kigen.model;
import java.io.Serializable;

import lombok.Data;

@Data
public class UpdateModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String username;
    private String visa;
    private String remday;
    private String daylocal;
    private String memo;

    public UpdateModel() {
    }
}
