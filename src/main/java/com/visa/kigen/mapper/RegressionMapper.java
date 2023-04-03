package com.visa.kigen.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.visa.kigen.model.RegressionModel;


	@Repository
	@Mapper
public interface RegressionMapper {	
		int  insert(RegressionModel regressioneModel);
	    
 }
