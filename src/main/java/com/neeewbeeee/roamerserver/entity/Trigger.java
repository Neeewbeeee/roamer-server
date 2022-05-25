package com.neeewbeeee.roamerserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author : hongbo
 * @create 2022-05-24-20:21
 **/

@TableName("ptrigger")
@Data
public class Trigger {
    @TableId(value ="id", type = IdType.AUTO)
    private Integer id;
    private Integer pathId;
    private Integer num;     //触发器所在路径的起点的点号
    private String name;    //触发器名
    private double rate;   //路径百分比
}
