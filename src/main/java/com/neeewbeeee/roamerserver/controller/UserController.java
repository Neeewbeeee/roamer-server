package com.neeewbeeee.roamerserver.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neeewbeeee.roamerserver.common.Result;
import com.neeewbeeee.roamerserver.entity.User;
import com.neeewbeeee.roamerserver.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : hongbo
 * @create 2022-03-14-9:22
 **/
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserService userService;

    @PostMapping("/login")
    public Result<?> login(@RequestBody User user){
        User res = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUserName, user.getUserName()).eq(User::getPassword, user.getPassword()));
        if(res == null){
            return Result.error("-1","用户名或密码错误");
        }
        return Result.success(res);
    }

    @PostMapping("/register")
    public Result<?> register(@RequestBody User user){
        User res = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUserName,user.getUserName()));
        if(res != null){
            return Result.error("-1","用户名重复");
        }
        if(user.getPassword() == null){
            user.setPassword("123456");
        }
        userService.save(user);
        return Result.success();
    }

    @PostMapping
    public Result<?> save(@RequestBody User user){
        if(user.getPassword() == null){
            user.setPassword("123456");
        }
        userService.save(user);
        return Result.success();
    }

    @PutMapping
    public Result<?> update(@RequestBody User user){
        if(userService.updateById(user)){
            return Result.success();
        }else{
            return Result.error("-1","更新失败");
        }
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id){
        if(userService.removeById(id)){
            return Result.success();
        }else{
            return Result.error("-1","删除失败");
        }
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize ,
                              @RequestParam(defaultValue = "") String search,
                              @RequestParam(defaultValue = "") Integer type){
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery();
        if (StrUtil.isNotBlank(search)) {
            wrapper.like(User::getUserName, search);
        }
//        Page<User> userPage = userMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        Page<User> userPage = userService.page(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(userPage);
    }
}
