package com.cycloneboy.ssm.dao;

import com.cycloneboy.ssm.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * Created by CycloneBoy on 2017/8/1.
 */
public interface UserDao {

    @Select("select * from t_user where username=#{username}")
    public User getByUsername(String username);

    @Select("select r.rolename from t_user u ,t_role t where u.role_id = r.id and u.username=#{username} ")
    public Set<String> getRoles(String username);

    @Select("select p.permissionname from t_user u ,t_role r,t_permission p where u.role_id=r.id and p.role_id =r.id " +
            "and u.username=#{username}")
    public Set<String> getPermissions(String username);
}
