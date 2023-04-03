package com.visa.kigen.service;

import java.util.List;

import com.visa.kigen.model.UpdateModel;

public interface UpdateService {

	public List<UpdateModel> selectuser(UpdateModel updateModel);
    public int updateuser(UpdateModel updateModel);

}
