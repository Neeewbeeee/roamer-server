package com.neeewbeeee.roamerserver.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neeewbeeee.roamerserver.common.Result;
import com.neeewbeeee.roamerserver.entity.Application;
import com.neeewbeeee.roamerserver.entity.Model;
import com.neeewbeeee.roamerserver.service.IModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : hongbo
 * @create 2022-05-15-20:24
 **/

@RestController
@RequestMapping("/models")
public class ModelController {
    @Autowired
    IModelService modelService;

    /**
     * 新建一个模型实例
     * @param model
     * @return
     */
    @PostMapping
    public Result<?> save(@RequestBody Model model) {
        modelService.save(model);
        return Result.success();
    }


    @PutMapping
    public Result<?> update(@RequestBody Model model) {
        if (modelService.updateById(model)) {
            return Result.success();
        } else {
            return Result.error("-1", "更新失败");
        }
    }


    /**
     * 根据id查找一个模型实例
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<?> getOne(@PathVariable Long id){
        Model res = modelService.getById(id);
        if(res == null){
            return Result.error("-1","id不存在");
        }
        return Result.success(res);
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        if (modelService.removeById(id)) {
            return Result.success();
        } else {
            return Result.error("-1", "删除失败");
        }
    }

    /**
     * 查询该应用下的所有模型实例列表
     * @param pageNum
     * @param pageSize
     * @param appId
     * @return
     */
    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "10") Integer appId) {
        LambdaQueryWrapper<Model> wrapper = Wrappers.<Model>lambdaQuery();
        if (appId != null) {
            wrapper.eq(Model::getAppId, appId);
        }
        Page<Model> applicationPage = modelService.page(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(applicationPage);
    }
}
