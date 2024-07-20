package com.brightstarschool.schoolmanagementsystem.service.implementation;

import com.brightstarschool.schoolmanagementsystem.dto.RoleDTO;
import com.brightstarschool.schoolmanagementsystem.dto.RoleSaveDTO;
import com.brightstarschool.schoolmanagementsystem.dto.RoleUpdateDTO;
import com.brightstarschool.schoolmanagementsystem.entity.Role;
import com.brightstarschool.schoolmanagementsystem.repository.RoleRepository;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImplementation implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImplementation(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public String addRole(RoleSaveDTO roleSaveDTO) {
        Optional<Role> roleExists = roleRepository.findByRoleId(roleSaveDTO.getRoleId());

        if(roleExists.isPresent())
        {
            return ("Role with id: " + roleSaveDTO.getRoleId() + " already exists!!");
        }

        Role role = new Role
                (
                    roleSaveDTO.getRoleId(),
                    roleSaveDTO.getRoleName()
                );

        roleRepository.save(role);

        return ("Role with id: " + roleSaveDTO.getRoleId() + " saved successfully");
    }

    @Override
    public List<RoleDTO> getAllRoles() {
        return null;
    }

    @Override
    public String updateRole(long id, RoleUpdateDTO roleUpdateDTO) {
        return null;
    }

    @Override
    public boolean deleteRole(long id) {
        return false;
    }
}
