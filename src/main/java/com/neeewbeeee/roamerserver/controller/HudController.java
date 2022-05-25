package com.neeewbeeee.roamerserver.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neeewbeeee.roamerserver.common.Result;
import com.neeewbeeee.roamerserver.entity.Hud;
import com.neeewbeeee.roamerserver.entity.Model;
import com.neeewbeeee.roamerserver.service.IHudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : hongbo
 * @create 2022-05-23-22:31
 **/

@RestController
@RequestMapping("/huds")
public class HudController {
    @Autowired
    IHudService hudService;


    @PostMapping
    public Result<?> save(@RequestBody Hud hud) {
        if(hudService.save(hud)){
            return Result.success();
        }else{
           return Result.error("-1", "创建Hud失败");
        }
    }


    @PutMapping
    public Result<?> update(@RequestBody Hud hud) {
        if (hudService.updateById(hud)) {
            return Result.success();
        } else {
            return Result.error("-1", "更新失败");
        }
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        if (hudService.removeById(id)) {
            return Result.success();
        } else {
            return Result.error("-1", "删除失败");
        }
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") Integer modelId) {
        LambdaQueryWrapper<Hud> wrapper = Wrappers.<Hud>lambdaQuery();
        if (modelId != null) {
            wrapper.eq(Hud::getModelId, modelId);
        }
        Page<Hud> pathPage = hudService.page(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(pathPage);
    }
}
