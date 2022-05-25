package com.neeewbeeee.roamerserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author : hongbo
 * @create 2022-05-23-22:38
 **/

@TableName("hud")
@Data
public class Hud {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer modelId;
    private Integer num;
    private String title;
    private String content;
    private double location;
    private String style;
    private Integer radius;
    private Integer transparency;
    private Integer blur;
    private Integer width;
    private String panelColor;
    private String borderColor;
    private Integer titleFontSize;
    private String titleColor;
    private String titleFontFormat;
    private Integer contentFontSize;
    private String contentColor;
    private String contentFontFormat;
}
