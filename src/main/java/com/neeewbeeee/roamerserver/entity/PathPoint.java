package com.neeewbeeee.roamerserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author : hongbo
 * @create 2022-05-24-17:03
 **/
@TableName("path_point")
@Data
public class PathPoint {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer pathId;
    private Integer pointId;
    private Integer num;
}
