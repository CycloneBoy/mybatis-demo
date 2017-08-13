package com.cycloneboy.ssm.service;

import com.cycloneboy.ssm.entity.User;

import java.util.Set;

/**
 * Created by CycloneBoy on 2017/8/1.
 */
public interface UserService {

    public User getByUsername(String username);

    public Set<String> getRoles(String username);

    public Set<String> getPermissions(String username);
}
