package com.visa.kigen.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.visa.kigen.model.HomeModel;
@Repository
@Mapper
public interface HomeMapper {
	List<HomeModel> selectAll(HomeModel homeModel);
	List<HomeModel> searchuser(HomeModel homeModel);
	List<HomeModel> searchid(HomeModel homeModel);
}
