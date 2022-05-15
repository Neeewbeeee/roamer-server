package com.neeewbeeee.roamerserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : hongbo
 * @create 2022-03-14-9:21
 **/
@TableName("user")
@Data
public class User implements Serializable {
    @TableId(value ="id", type = IdType.AUTO)
    private Integer id;
    private String userName;
    private String password;
    private Integer type;  // 0 公司 1 社会组织 2 个人
    private String phoneNumber;
    private String email;
}
