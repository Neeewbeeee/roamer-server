package com.neeewbeeee.roamerserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.neeewbeeee.roamerserver.entity.Path;
import com.neeewbeeee.roamerserver.entity.Point;

import java.util.List;

/**
 * @author : hongbo
 * @create 2022-05-23-22:28
 **/
public interface IPathService extends IService<Path> {
    int insertPath(Path path);
    Path getOnePath(Integer pathId);
    List<Point> getPointList(Integer pathId);
    boolean updatePath(Path path);
}
