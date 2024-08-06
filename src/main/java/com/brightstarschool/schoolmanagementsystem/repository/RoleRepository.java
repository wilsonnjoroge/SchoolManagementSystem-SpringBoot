package com.brightstarschool.schoolmanagementsystem.repository;

import com.brightstarschool.schoolmanagementsystem.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.parser.Entity;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleCode(long roleCode);

}
