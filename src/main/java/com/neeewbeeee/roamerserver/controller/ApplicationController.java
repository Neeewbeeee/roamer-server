package com.neeewbeeee.roamerserver.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neeewbeeee.roamerserver.common.Result;
import com.neeewbeeee.roamerserver.entity.Application;
import com.neeewbeeee.roamerserver.service.IApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : hongbo
 * @create 2022-05-15-19:19
 **/

@RestController
@RequestMapping("/applications")
public class ApplicationController {
    @Autowired
    IApplicationService applicationService;

    /**
     * 新建一个应用实例
     * @param application
     * @return
     */
    @PostMapping
    public Result<?> save(@RequestBody Application application) {
        applicationService.save(application);
        return Result.success();
    }


    /**
     * 更新应用的相关信息  （如发布时间、开放状态、分享链接）
     *
     * @param application
     * @return
     */
    @PutMapping
    public Result<?> update(@RequestBody Application application) {
        if (applicationService.updateById(application)) {
            return Result.success();
        } else {
            return Result.error("-1", "更新失败");
        }
    }


    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        if (applicationService.removeById(id)) {
            return Result.success();
        } else {
            return Result.error("-1", "删除失败");
        }
    }

    /**
     * 根据id查找一个应用实例
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<?> getOne(@PathVariable Long id){
        Application res = applicationService.getById(id);
        if(res == null){
            return Result.error("-1","id不存在");
        }
        return Result.success(res);
    }

    /**
     * 查询应用实例列表
     * @param pageNum
     * @param pageSize
     * @param type  开放类型 0 活跃中 1 未开放 2 已结束
     * @return
     */
    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "0") Integer type) {
        LambdaQueryWrapper<Application> wrapper = Wrappers.<Application>lambdaQuery();
        if (type != null) {
            wrapper.eq(Application::getType, type);
        }
        Page<Application> applicationPage = applicationService.page(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(applicationPage);
    }
}
