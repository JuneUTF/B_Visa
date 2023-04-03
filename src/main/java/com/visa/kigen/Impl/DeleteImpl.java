package com.visa.kigen.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.visa.kigen.mapper.DeleteMapper;
import com.visa.kigen.model.DeleteModel;
import com.visa.kigen.service.DeleteService;


@Service
public class DeleteImpl implements DeleteService {

    @Resource
    private DeleteMapper mapper;

    /**
     * 新規作成
     *
     * @param user
     */


    @Override
    public int delete(DeleteModel deleteModel){
        return mapper.delete(deleteModel);
    }
    @Override
    public List<DeleteModel> selectuser(DeleteModel deleteModel){
        return mapper.selectuser(deleteModel);
    }
}