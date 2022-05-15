package com.neeewbeeee.roamerserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author : hongbo
 * @create 2022-05-15-20:02
 **/

@TableName("model")
@Data
public class Model {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer appId;
    private Integer destinationId; //终点ID
    private Integer num; // 第几个模型，ID
    private String image; //缩略图
    private String file; //模型文件
    private Long fileSize; //模型的文件大小
    private String name;  // 模型名称
    private String location; //模型所处地理位置

    private double longitude;  //经度
    private double latitude;  // 纬度
    private double height;  // 高程
    private double scaling; // 缩放比例
    private double yaw;   //航向角
    private double pitch; // 俯仰角
    private double roll; // 翻滚角

    private Date time;  //模型本地时间
    private Integer antialiasing; //是否开启抗锯齿
    private Integer highperformance; //是否开启高性能渲染模式
    private Integer precision; //渲染精度 高精度 0 或中精度 1
    private Integer buffer;  // 是否使用16位深度缓冲区


}
