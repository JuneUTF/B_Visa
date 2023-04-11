package com.visa.kigen.service;

import java.util.List;

import com.visa.kigen.model.HomeModel;
public interface HomeService {
	public List<HomeModel> selectAll(HomeModel homeModel);
	public List<HomeModel> selectAllAZ(HomeModel homeModel);
	public List<HomeModel> searchuser(HomeModel homeModel);
	public List<HomeModel> searchid(HomeModel homeModel);
	public List<HomeModel> selectid(HomeModel homeModel);
	List<HomeModel> selectAllDaysAZ (HomeModel homeModel);
	List<HomeModel> selectAllDaysZA (HomeModel homeModel);
	List<HomeModel> searchvisanumber (HomeModel homeModel);

}
