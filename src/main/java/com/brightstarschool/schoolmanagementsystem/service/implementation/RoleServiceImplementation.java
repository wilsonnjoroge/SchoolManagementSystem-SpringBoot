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

import javax.swing.text.html.parser.Entity;
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
        Optional<Role> roleExists = roleRepository.findByRoleCode(roleSaveDTO.getRoleCode());

        if(roleExists.isPresent())
        {
            return ("Role with id: " + roleSaveDTO.getRoleCode() + " already exists!!");
        }

        Role role = new Role
                (
                    roleSaveDTO.getRoleCode(),
                    roleSaveDTO.getRoleName()
                );

        roleRepository.save(role);

        return ("Role with id: " + roleSaveDTO.getRoleCode() + " saved successfully");
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
                            role.getRoleCode(),
                            role.getRoleName()
                    );
            roleDTOList.add(roleDTO);
        }

        return roleDTOList;
    }

    @Override
    public String updateRole(long roleCode, RoleUpdateDTO roleUpdateDTO) {
        if (roleRepository.existsById(roleCode)) {
            Role role = roleRepository.getById(roleCode);
            role.setRoleCode(roleUpdateDTO.getRoleCode());
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
        if (roleRepository.existsById(id)) {
            roleRepository.deleteById(id);
            System.out.println("\nRole deleted successfully");
            return true;
        } else {
            System.out.println("\nRole Code not found");
            return false;
        }
    }

    @Override
    public Optional<Entity> assignRole(Entity T, long roleCode) {
        return Optional.empty();
    }
}
