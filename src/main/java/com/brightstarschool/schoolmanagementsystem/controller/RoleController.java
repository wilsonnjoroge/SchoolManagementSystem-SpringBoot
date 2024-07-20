package com.brightstarschool.schoolmanagementsystem.controller;


import com.brightstarschool.schoolmanagementsystem.dto.RoleSaveDTO;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping(path = "/add-role")
    public ResponseEntity<String> createRole(@RequestBody RoleSaveDTO roleSaveDTO) {
        String response = roleService.addRole(roleSaveDTO);
        return ResponseEntity.ok(response);
    }
}
