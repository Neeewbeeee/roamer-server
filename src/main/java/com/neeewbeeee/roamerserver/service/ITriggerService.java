package com.neeewbeeee.roamerserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.neeewbeeee.roamerserver.entity.Hud;
import com.neeewbeeee.roamerserver.entity.Trigger;

import java.util.List;

/**
 * @author : hongbo
 * @create 2022-05-24-20:26
 **/
public interface ITriggerService extends IService<Trigger> {
    List<Hud> getHudList(Integer triggerId, Integer type);

    boolean updateHudList(Integer triggerId, List<Hud> hudList, Integer type);
}
