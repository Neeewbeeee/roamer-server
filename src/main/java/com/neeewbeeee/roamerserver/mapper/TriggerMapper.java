package com.neeewbeeee.roamerserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neeewbeeee.roamerserver.entity.Hud;
import com.neeewbeeee.roamerserver.entity.Path;
import com.neeewbeeee.roamerserver.entity.Trigger;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : hongbo
 * @create 2022-05-24-20:25
 **/

@Mapper
public interface TriggerMapper extends BaseMapper<Trigger> {
    List<Hud> selectHudList(@Param("id") Integer triggerId, @Param("type") Integer type);
}
