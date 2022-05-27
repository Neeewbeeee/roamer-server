package com.neeewbeeee.roamerserver.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neeewbeeee.roamerserver.common.Result;
import com.neeewbeeee.roamerserver.entity.Path;
import com.neeewbeeee.roamerserver.entity.Point;
import com.neeewbeeee.roamerserver.mapper.PathMapper;
import com.neeewbeeee.roamerserver.service.IPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : hongbo
 * @create 2022-05-23-22:31
 **/

@RestController
@RequestMapping("/paths")
public class PathController {
    @Autowired
    IPathService pathService;

    @Autowired
    PathMapper pathMapper;


    /**
     * 创建一条路线
     * @param path
     * @return
     */
    @PostMapping
    public Result<?> save(@RequestBody Path path) {
        if(pathService.insertPath(path) == 1) {
            return Result.success();
        }else{
            return Result.error("-1", "创建失败");
        }
    }

    /**
     * 更新path信息
     * @param path
     * @return
     */
    @PutMapping
    public Result<?> update(@RequestBody Path path) {
        if (pathService.updatePath(path)) {
            return Result.success();
        } else {
            return Result.error("-1", "更新失败");
        }
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        if (pathService.removeById(id)) {
            return Result.success();
        } else {
            return Result.error("-1", "删除失败");
        }
    }

    /**
     * 获取一条path的详细信息
     * @param pathId
     * @return
     */
    @GetMapping("/{pathId}")
    public Result<?> getOne(@PathVariable Integer pathId) {
        Path path = pathService.getOnePath(pathId);
        return Result.success(path);
    }

    @GetMapping("/list/{pathId}")
    public Result<?> getPointList(@PathVariable Integer pathId) {
        List<Point> points = pathService.getPointList(pathId);
        return Result.success(points);
    }


    /**
     * 获取简要path信息列表
     * @param pageNum
     * @param pageSize
     * @param modelId
     * @return
     */
    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") Integer modelId) {
        LambdaQueryWrapper<Path> wrapper = Wrappers.<Path>lambdaQuery();
        if (modelId != null) {
            wrapper.eq(Path::getModelId, modelId);
        }
        Page<Path> pathPage = pathService.page(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(pathPage);
    }
}
