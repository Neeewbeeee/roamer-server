package com.neeewbeeee.roamerserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neeewbeeee.roamerserver.entity.User;
import com.neeewbeeee.roamerserver.mapper.UserMapper;
import com.neeewbeeee.roamerserver.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @author : hongbo
 * @create 2022-03-14-9:25
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
