package com.neeewbeeee.roamerserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author : hongbo
 * @create 2022-05-15-19:09
 **/

@TableName("application")
@Data
public class Application {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private String name;
    private String description;
    private Date releaseTime;
    private Integer view;
    private Integer type;  // 开放类型 0 活跃中 1 未开放 2 已结束
    private String link;
    private String image;
}
