package com.neeewbeeee.roamerserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neeewbeeee.roamerserver.entity.Path;
import com.neeewbeeee.roamerserver.entity.Point;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : hongbo
 * @create 2022-05-23-22:26
 **/
@Mapper
public interface PathMapper extends BaseMapper<Path> {
    Path selectOnePath(@Param("id") Integer pathId);
    List<Point> selectPointList(@Param("id") Integer pathId);
}
