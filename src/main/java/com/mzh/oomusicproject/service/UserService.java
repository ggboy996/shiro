package com.mzh.oomusicproject.service;

import com.mzh.oomusicproject.domain.user.User;

import java.util.Set;

public interface UserService {
    User getUser(String username, String password);

    Set<String> getRole(String username);

    Set<String> getPermission(String username);
}
