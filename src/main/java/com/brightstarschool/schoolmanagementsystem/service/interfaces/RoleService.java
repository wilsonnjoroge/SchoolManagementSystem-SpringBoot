package com.brightstarschool.schoolmanagementsystem.service.interfaces;

import com.brightstarschool.schoolmanagementsystem.dto.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

public interface RoleService {
    String addRole(RoleSaveDTO roleSaveDTO);
    List<RoleDTO> getAllRoles();

    String updateRole(long id, RoleUpdateDTO roleUpdateDTO);

    boolean deleteRole(long id);

    Optional<Entity> assignRole(Entity T, long roleCode);
}
