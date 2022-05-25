package com.neeewbeeee.roamerserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neeewbeeee.roamerserver.entity.Path;
import com.neeewbeeee.roamerserver.entity.PathPoint;
import com.neeewbeeee.roamerserver.entity.Point;
import com.neeewbeeee.roamerserver.mapper.PathMapper;
import com.neeewbeeee.roamerserver.mapper.PathPointMapper;
import com.neeewbeeee.roamerserver.service.IPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : hongbo
 * @create 2022-05-23-22:29
 **/
@Service
public class PathServiceImpl extends ServiceImpl<PathMapper, Path> implements IPathService {
    @Autowired
    PathMapper pathMapper;
    @Autowired
    PathPointMapper pathPointMapper;

    @Override
    public int insertPath(Path path) {
        List<Point> pointList = path.getPoints();
        if (pathMapper.insert(path) != 1) {
            return 0;
        }
        Integer pathId = path.getId();
        for (Point point : pointList) {
            PathPoint pathPoint = new PathPoint();
            pathPoint.setPathId(pathId);
            pathPoint.setPointId(point.getId());
            pathPoint.setNum(point.getNum());
            if (pathPointMapper.insert(pathPoint) != 1) {
                return 0;
            }
        }
        return 1;
    }

    @Override
    public Path getOnePath(Integer pathId) {
        return pathMapper.selectOnePath(pathId);
    }

    @Override
    public List<Point> getPointList(Integer pathId) {
        return pathMapper.selectPointList(pathId);
    }

    @Override
    public boolean updatePath(Path path) {
        pathMapper.updateById(path);
//      先把所有路线的中间表记录删除后再重建
        LambdaQueryWrapper<PathPoint> wrapper = Wrappers.lambdaQuery();
        Integer pathId = path.getId();
        wrapper.eq(PathPoint::getPathId, pathId);
        pathPointMapper.delete(wrapper);
        List<Point> pointList = path.getPoints();
        for (Point point : pointList) {
            PathPoint pathPoint = new PathPoint();
            pathPoint.setPathId(pathId);
            pathPoint.setPointId(point.getId());
            pathPoint.setNum(point.getNum());
            if (pathPointMapper.insert(pathPoint) != 1) {
                return false;
            }
        }

        return true;
    }


}
