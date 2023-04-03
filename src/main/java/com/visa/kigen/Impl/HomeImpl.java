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
}
