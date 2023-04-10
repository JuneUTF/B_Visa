package com.visa.kigen.Impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.visa.kigen.mapper.HomeMapper;
import com.visa.kigen.model.HomeModel;
import com.visa.kigen.service.HomeService;
@Service
public class HomeImpl implements HomeService {
 @Resource
  private HomeMapper mapper;

 @Override
 public List<HomeModel> selectAll(HomeModel homeModel){
	 return mapper.selectAll(homeModel);
 }
 @Override
 public List<HomeModel> selectAllAZ(HomeModel homeModel){
	 return mapper.selectAllAZ(homeModel);
 }
 @Override
 public  List<HomeModel> searchuser(HomeModel homeModel){
	 return mapper.searchuser(homeModel);
 }
 @Override
 public  List<HomeModel> searchid(HomeModel homeModel){
	 return mapper.searchid(homeModel);
 }
 @Override
 public  List<HomeModel> selectid(HomeModel homeModel){
	 return mapper.selectAll(homeModel);
 }
 @Override
 public  List<HomeModel> selectAllDaysAZ(HomeModel homeModel){
	 return mapper.selectAllDaysAZ(homeModel);
 }
 @Override
 public  List<HomeModel> selectAllDaysZA(HomeModel homeModel){
	 return mapper.selectAllDaysZA(homeModel);
 }
}
