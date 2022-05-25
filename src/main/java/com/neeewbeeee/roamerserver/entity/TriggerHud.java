package com.neeewbeeee.roamerserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author : hongbo
 * @create 2022-05-24-21:33
 **/
@TableName("trigger_hud")
@Data
public class TriggerHud {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer triggerId;
    private Integer hudId;
    private Integer type;
}
