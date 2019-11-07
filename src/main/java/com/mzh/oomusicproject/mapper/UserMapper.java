package com.mzh.oomusicproject.mapper;

import com.mzh.oomusicproject.domain.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

@Mapper
public interface UserMapper {

    @Select("select * from t_user where username = #{username}")
    User getUser(@Param("username")String username, @Param("password")String password);

    @Select("SELECT r.role_name FROM t_role r  WHERE  r.id IN\n" +
            "(SELECT ur.role_id from t_user_role ur where ur.user_id in \n" +
            "(SELECT u.id from t_user u where u.username = #{username}))")
    Set<String> getUserRole(@Param("username")String username);

    @Select("SELECT p.permission_name FROM t_permission p where p.id in \n" +
            "(SELECT distinct rp.permission_id FROM t_role_permission rp  WHERE  rp.role_id IN\n" +
            "(SELECT ur.role_id from t_user_role ur where ur.user_id in \n" +
            "(SELECT u.id from t_user u where u.username = #{username})))")
    Set<String> getUserPermission(@Param("username")String username);
}
