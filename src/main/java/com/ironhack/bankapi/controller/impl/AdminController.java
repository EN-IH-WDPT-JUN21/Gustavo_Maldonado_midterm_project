package com.ironhack.bankapi.controller.impl;

import com.ironhack.bankapi.controller.dto.AdminDTO;
import com.ironhack.bankapi.dao.users.Admin;
import com.ironhack.bankapi.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ironhack.bankapi.utils.PasswordUtil.encryptedPassword;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminRepository adminRepository;

    @PostMapping("/new")
    public Admin store(@RequestBody AdminDTO adminDTO) {
        Admin admin = new Admin(adminDTO.getUsername(), encryptedPassword(adminDTO.getPassword()));
        return adminRepository.save(admin);
    }
}
