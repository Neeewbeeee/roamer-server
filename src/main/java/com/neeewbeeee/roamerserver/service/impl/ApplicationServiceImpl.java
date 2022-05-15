package com.neeewbeeee.roamerserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neeewbeeee.roamerserver.entity.Application;
import com.neeewbeeee.roamerserver.mapper.ApplicationMapper;
import com.neeewbeeee.roamerserver.service.IApplicationService;
import org.springframework.stereotype.Service;

/**
 * @author : hongbo
 * @create 2022-05-15-19:18
 **/

@Service
public class ApplicationServiceImpl extends ServiceImpl<ApplicationMapper, Application> implements IApplicationService {
}
