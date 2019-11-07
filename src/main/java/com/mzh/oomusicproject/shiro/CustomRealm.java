package com.mzh.oomusicproject.shiro;

import com.mzh.oomusicproject.domain.user.User;
import com.mzh.oomusicproject.service.UserService;
import com.mzh.oomusicproject.utils.MD5;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //查询角色
        Set<String> roleSet = new HashSet<>();
        roleSet = userService.getRole(username);
        info.setRoles(roleSet);
        System.out.println("该用户拥有的角色是："+roleSet);
        //查询权限
        Set<String> permissionsSet = new HashSet<>();
        permissionsSet = userService.getPermission(username);
        info.setStringPermissions(permissionsSet);
        System.out.println("该用户拥有的权限是："+permissionsSet);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("-------身份认证方法--------");
        String userName = (String) authenticationToken.getPrincipal();
        String userPwd = new String((char[]) authenticationToken.getCredentials());
        //根据用户名从数据库获取密码
        User user= userService.getUser(userName,userPwd);

        String pwd = MD5.MD5Util(userName,userPwd);

        String password =user.getPassword();
        if (userName == null) {
            throw new AccountException("用户名不正确");
        } else if (!pwd.equals(password )) {
            throw new AccountException("密码不正确");
        }
        return new SimpleAuthenticationInfo(userName, password, ByteSource.Util.bytes(userName + "salt"),getName());
    }
}
