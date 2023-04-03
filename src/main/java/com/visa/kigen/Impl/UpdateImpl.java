package com.visa.kigen.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.visa.kigen.mapper.UpdateMapper;
import com.visa.kigen.model.UpdateModel;
import com.visa.kigen.service.UpdateService;


@Service
public class UpdateImpl implements UpdateService {

    @Resource
    private UpdateMapper mapper;

    /**
     * 新規作成
     *
     * @param user
     */

    @Override
    public List<UpdateModel> selectuser(UpdateModel updateModel){
        return mapper.selectuser(updateModel);
    }

    @Override
    public int updateuser(UpdateModel updateModel){
        return mapper.updateuser(updateModel);
    }
}