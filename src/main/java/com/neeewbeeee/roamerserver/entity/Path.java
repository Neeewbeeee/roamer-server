package com.neeewbeeee.roamerserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

/**
 * @author : hongbo
 * @create 2022-05-23-22:07
 **/

@TableName("path")
@Data
public class Path {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer modelId;
    private String name; // 路径名称
    private String title; //路径显示名
    private String description;  // 路径描述
    private String interpolation; //插值方法

    @TableField(exist = false)
    private List<Point> points;
}
