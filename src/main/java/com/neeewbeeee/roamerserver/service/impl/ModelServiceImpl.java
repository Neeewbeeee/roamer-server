package com.neeewbeeee.roamerserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neeewbeeee.roamerserver.entity.Model;
import com.neeewbeeee.roamerserver.mapper.ModelMapper;
import com.neeewbeeee.roamerserver.service.IModelService;
import org.springframework.stereotype.Service;

/**
 * @author : hongbo
 * @create 2022-05-15-20:23
 **/

@Service
public class ModelServiceImpl extends ServiceImpl<ModelMapper, Model> implements IModelService {
}
