package com.brightstarschool.schoolmanagementsystem.service.interfaces;

import com.brightstarschool.schoolmanagementsystem.dto.*;

import java.util.List;

public interface RoleService {
    String addRole(RoleSaveDTO roleSaveDTO);
    List<RoleDTO> getAllRoles();

    String updateRole(long id, RoleUpdateDTO roleUpdateDTO);

    boolean deleteRole(long id);
}
