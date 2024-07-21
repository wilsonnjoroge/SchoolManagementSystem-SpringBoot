package com.brightstarschool.schoolmanagementsystem.controller;


import com.brightstarschool.schoolmanagementsystem.dto.RoleDTO;
import com.brightstarschool.schoolmanagementsystem.dto.RoleSaveDTO;
import com.brightstarschool.schoolmanagementsystem.dto.RoleUpdateDTO;
import com.brightstarschool.schoolmanagementsystem.entity.Role;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/roles")
public class RoleController {
    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping(path = "/add-role")
    public ResponseEntity<String> createRole(@RequestBody RoleSaveDTO roleSaveDTO) {
        String response = roleService.addRole(roleSaveDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/get-all-roles")
    public ResponseEntity<List<RoleDTO>> getAllRoles() {
        List<RoleDTO> roles = roleService.getAllRoles();
        return ResponseEntity.ok(roles);
    }

    @PutMapping(path = "/update-role/{id}")
    public ResponseEntity<String> updateRole(@PathVariable long id, @RequestBody RoleUpdateDTO roleUpdateDTO)
    {
        String response = roleService.updateRole(id, roleUpdateDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/delete-role/{id}")
    public String deleteRole(@PathVariable("id") long id) {
        boolean deleteRole = roleService.deleteRole(id);
        if (deleteRole) {
            return "Role deleted successfully";
        } else {
            return "Role ID not found";
        }
    }
}
