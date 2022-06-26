package com.mahhis.entity.user;

public enum Role {
    USER(1),
    ADMIN(2);

    final int roleId;

    Role(int roleId){
        this.roleId = roleId;
    }

    public int getRoleId() {
        return roleId;
    }

    @Override
    public String toString() {
        return super.toString().charAt(0) + super.toString().substring(1).toLowerCase();
    }
}
