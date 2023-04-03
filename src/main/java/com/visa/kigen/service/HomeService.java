package com.visa.kigen.service;

import java.util.List;

import com.visa.kigen.model.HomeModel;
public interface HomeService {
	public List<HomeModel> selectAll(HomeModel homeModel);
}
