package com.neeewbeeee.roamerserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neeewbeeee.roamerserver.entity.Point;
import com.neeewbeeee.roamerserver.mapper.PointMapper;
import com.neeewbeeee.roamerserver.service.IPointService;
import org.springframework.stereotype.Service;

/**
 * @author : hongbo
 * @create 2022-05-15-20:50
 **/
@Service
public class PointServiceImpl extends ServiceImpl<PointMapper, Point> implements IPointService {
}
