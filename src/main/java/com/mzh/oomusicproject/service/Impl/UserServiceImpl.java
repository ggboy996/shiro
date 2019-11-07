package com.mzh.oomusicproject.service.Impl;

import com.mzh.oomusicproject.domain.user.User;
import com.mzh.oomusicproject.mapper.UserMapper;
import com.mzh.oomusicproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUser(String username, String password) {
        User user = userMapper.getUser(username,password);
        return user;
    }

    @Override
    public Set<String> getRole(String username) {
        Set<String> role = userMapper.getUserRole(username);
        return role;
    }

    @Override
    public Set<String> getPermission(String username) {
        Set<String> permission = userMapper.getUserPermission(username);
        return permission;
    }
}
