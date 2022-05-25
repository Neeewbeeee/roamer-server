package com.neeewbeeee.roamerserver.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neeewbeeee.roamerserver.common.Result;
import com.neeewbeeee.roamerserver.entity.*;
import com.neeewbeeee.roamerserver.mapper.TriggerMapper;
import com.neeewbeeee.roamerserver.service.ITriggerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : hongbo
 * @create 2022-05-24-20:28
 **/

@RestController
@RequestMapping("/triggers")
public class TriggerController {
    @Autowired
    ITriggerService triggerService;

    /**
     * 创建一个新的trigger
     * @param trigger
     * @return
     */
    @PostMapping
    public Result<?> save(@RequestBody Trigger trigger) {
        if(triggerService.save(trigger)) {
            return Result.success();
        }else{
            return Result.error("-1","创建保存trigger失败");
        }
    }

    @PutMapping
    public Result<?> update(@RequestBody Trigger trigger) {
        if (triggerService.updateById(trigger)) {
            return Result.success();
        } else {
            return Result.error("-1", "更新失败");
        }
    }

    @GetMapping("/{id}")
    public Result<?> getOne(@PathVariable Long id){
        Trigger trigger = triggerService.getById(id);
        if(trigger == null){
            return Result.error("-1","id不存在");
        }
        return Result.success(trigger);
    }

    @GetMapping("/open/{id}")
    public Result<?> getOpenHudList(@PathVariable Integer id){
        List<Hud> openHudList = triggerService.getHudList(id,0);
        if(openHudList == null){
            return Result.error("-1","id可能不存在");
        }
        return Result.success(openHudList);
    }

    @PutMapping("/open")
    public Result<?> updateOpen(@RequestParam Integer triggerId, @RequestBody List<Hud> openHudList) {
        if (triggerService.updateHudList(triggerId,openHudList,0)) {
            return Result.success();
        } else {
            return Result.error("-1", "更新失败");
        }
    }

    @GetMapping("/close/{id}")
    public Result<?> getCloseHudList(@PathVariable Integer id){
        List<Hud> closeHudList = triggerService.getHudList(id,1);
        if(closeHudList == null){
            return Result.error("-1","id可能不存在");
        }
        return Result.success(closeHudList);
    }

    @PutMapping("/close")
    public Result<?> updateClose(@RequestParam Integer triggerId, @RequestBody List<Hud> closeHudList) {
        if (triggerService.updateHudList(triggerId,closeHudList,1)) {
            return Result.success();
        } else {
            return Result.error("-1", "更新失败");
        }
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        if (triggerService.removeById(id)) {
            return Result.success();
        } else {
            return Result.error("-1", "删除失败");
        }
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                      @RequestParam(defaultValue = "10") Integer pageSize,
                                      @RequestParam Integer pathId) {
        LambdaQueryWrapper<Trigger> wrapper = Wrappers.lambdaQuery();

        wrapper.eq(Trigger::getPathId, pathId);
        Page<Trigger> triggerPage = triggerService.page(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(triggerPage);
    }
}
