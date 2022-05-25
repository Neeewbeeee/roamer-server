package com.neeewbeeee.roamerserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neeewbeeee.roamerserver.entity.*;
import com.neeewbeeee.roamerserver.mapper.TriggerHudMapper;
import com.neeewbeeee.roamerserver.mapper.TriggerMapper;
import com.neeewbeeee.roamerserver.service.ITriggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : hongbo
 * @create 2022-05-24-20:26
 **/

@Service
public class TriggerServiceImpl extends ServiceImpl<TriggerMapper, Trigger> implements ITriggerService {
    @Autowired
    TriggerMapper triggerMapper;

    @Autowired
    TriggerHudMapper triggerHudMapper;

    @Override
    public List<Hud> getHudList(Integer triggerId, Integer type) {
        List<Hud> list = triggerMapper.selectHudList(triggerId, type);
        return list;
    }

    @Override
    public boolean updateHudList(Integer triggerId, List<Hud> hudList, Integer type){

//      先把所有trigger的中间表记录删除后再重建
        LambdaQueryWrapper<TriggerHud> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(TriggerHud::getTriggerId, triggerId).eq(TriggerHud::getType,type);
        triggerHudMapper.delete(wrapper);

        for (Hud hud : hudList) {
//            triggerHud.setId(null);
            TriggerHud triggerHud = new TriggerHud();
            triggerHud.setHudId(hud.getId());
            triggerHud.setTriggerId(triggerId);
            triggerHud.setType(type);
            if (triggerHudMapper.insert(triggerHud) != 1) {
                return false;
            }
        }
        return true;
    }


}
