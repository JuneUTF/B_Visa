package com.visa.kigen.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.visa.kigen.model.DeleteModel;
@Repository
@Mapper
public interface DeleteMapper {	
	 List<DeleteModel> selectuser(DeleteModel deleteModel);
	int  delete(DeleteModel deleteModel);
    
 }
