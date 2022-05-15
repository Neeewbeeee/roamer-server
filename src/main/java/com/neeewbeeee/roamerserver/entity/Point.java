package com.neeewbeeee.roamerserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author : hongbo
 * @create 2022-05-15-19:03
 **/

@TableName("point")
@Data
public class Point {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer appId;
    private Integer type; //0 终点 1 中间点
    private String name;
    private String location;
    private double longitude;
    private double latitude;
    private double height;
    private double x;
    private double y;
    private double z;
}
