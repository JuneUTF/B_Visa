package com.visa.kigen.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.visa.kigen.model.UpdateModel;
@Repository
@Mapper
public interface UpdateMapper {	

     List<UpdateModel> selectuser(UpdateModel updateModel);
	int  updateuser(UpdateModel updateModel);
    
 }
