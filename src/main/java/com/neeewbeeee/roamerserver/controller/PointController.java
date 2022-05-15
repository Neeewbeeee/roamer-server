package com.neeewbeeee.roamerserver.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neeewbeeee.roamerserver.common.Result;
import com.neeewbeeee.roamerserver.entity.Model;
import com.neeewbeeee.roamerserver.entity.Point;
import com.neeewbeeee.roamerserver.service.IModelService;
import com.neeewbeeee.roamerserver.service.IPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : hongbo
 * @create 2022-05-15-20:52
 **/


@RestController
@RequestMapping("/points")
public class PointController {
    @Autowired
    IModelService modelService;
    @Autowired
    IPointService pointService;

    /**
     * 新建一个点
     * @param point
     * @return
     */
    @PostMapping
    public Result<?> save(@RequestBody Point point) {
        pointService.save(point);
        return Result.success();
    }


    /**
     * 更新模型和终点的绑定
     * @param pointId
     * @param modelId
     * @return
     */
    @PutMapping
    public Result<?> update(@RequestParam Integer pointId, @RequestParam Integer modelId) {
        Model model = new Model();
        model.setId(modelId);
        model.setDestinationId(pointId);
        if (modelService.updateById(model)) {
            return Result.success();
        } else {
            return Result.error("-1", "更新失败");
        }
    }


    /**
     * 查找模型对应的终点
     * @param modelId
     * @return
     */
    @GetMapping("/{modelId}")
    public Result<?> getOne(@PathVariable Long modelId){
        Model model = modelService.getById(modelId);
        Integer id = model.getDestinationId();
        Point res = pointService.getById(id);
        if(res == null){
            return Result.error("-1","id不存在");
        }
        return Result.success(res);
    }


    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        if (pointService.removeById(id)) {
            return Result.success();
        } else {
            return Result.error("-1", "删除失败");
        }
    }

    /**
     * 查询终点列表
     * @param pageNum
     * @param pageSize
     * @param appId  应用id
     * @return
     */
    @GetMapping("/des")
    public Result<?> findPageDesPoint(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "10") Integer appId) {
        LambdaQueryWrapper<Point> wrapper = Wrappers.<Point>lambdaQuery();
        if (appId != null) {
            wrapper.eq(Point::getAppId, appId);
        }
        wrapper.eq(Point::getType, 0);
        Page<Point> applicationPage = pointService.page(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(applicationPage);
    }
}
