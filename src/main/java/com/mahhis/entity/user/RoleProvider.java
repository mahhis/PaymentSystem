package com.mahhis.entity.user;

import java.util.HashMap;
import java.util.Map;

public class RoleProvider {

    private static RoleProvider instance;

    private final Map<Integer, Role> roles;

    private RoleProvider(){
        roles = new HashMap<>();
        roles.put(Role.ADMIN.getRoleId(), Role.ADMIN);
        roles.put(Role.USER.getRoleId(), Role.USER);
    }

    public static Role getRole(int roleId){
        if (instance == null){
            instance = new RoleProvider();
        }
        return instance.roles.get(roleId);
    }


}