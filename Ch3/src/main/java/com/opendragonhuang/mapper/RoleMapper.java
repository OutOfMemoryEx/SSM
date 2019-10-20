package com.opendragonhuang.mapper;

import com.opendragonhuang.model.Role;

import java.util.List;

public interface RoleMapper {
    int insertRole(Role role);
    int updateRole(Role role);
    int deleteRole(Long id);
    Role findRole(Long id);
    List<Role> findRoles(String roleName);
}
