package com.visa.kigen.Impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.visa.kigen.mapper.RegressionMapper;
import com.visa.kigen.model.RegressionModel;
import com.visa.kigen.service.RegressionService;
@Service
public class RegressionImpl implements RegressionService {
	@Resource
	private RegressionMapper mapper;
	
	@Override
	public int insert(RegressionModel regressionModel) {
		return mapper.insert(regressionModel);
	}
}
