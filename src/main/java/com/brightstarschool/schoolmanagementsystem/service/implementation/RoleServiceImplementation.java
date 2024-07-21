package com.brightstarschool.schoolmanagementsystem.service.implementation;

import com.brightstarschool.schoolmanagementsystem.dto.RoleDTO;
import com.brightstarschool.schoolmanagementsystem.dto.RoleSaveDTO;
import com.brightstarschool.schoolmanagementsystem.dto.RoleUpdateDTO;
import com.brightstarschool.schoolmanagementsystem.dto.StudentDTO;
import com.brightstarschool.schoolmanagementsystem.entity.Role;
import com.brightstarschool.schoolmanagementsystem.entity.Student;
import com.brightstarschool.schoolmanagementsystem.repository.RoleRepository;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<Role> getRole = roleRepository.findAll();
        List<RoleDTO> roleDTOList = new ArrayList<>();

        for(Role role : getRole)
        {
            RoleDTO roleDTO = new RoleDTO
                    (
                            role.getId(),
                            role.getRoleId(),
                            role.getRoleName()
                    );
            roleDTOList.add(roleDTO);
        }

        return roleDTOList;
    }

    @Override
    public String updateRole(long id, RoleUpdateDTO roleUpdateDTO) {
        if (roleRepository.existsById(id)) {
            Role role = roleRepository.getById(id);
            role.setRoleId(roleUpdateDTO.getRoleId());
            role.setRoleName(roleUpdateDTO.getRoleName());

            roleRepository.save(role);
            System.out.println("\nRole details updated Successfully");
            return "Role details updated Successfully";
        }else {
            System.out.println("\nRole ID not Found");
            return "Role ID not Found";
        }
    }

    @Override
    public boolean deleteRole(long id) {
        return false;
    }
}
