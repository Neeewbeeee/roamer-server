package com.neeewbeeee.roamerserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neeewbeeee.roamerserver.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : hongbo
 * @create 2022-03-14-9:23
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
