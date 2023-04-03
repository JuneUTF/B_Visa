package com.visa.kigen.service;

import java.util.List;

import com.visa.kigen.model.DeleteModel;

public interface DeleteService {

    public int delete(DeleteModel deleteModel);
    public List<DeleteModel> selectuser(DeleteModel deleteModel);

}
