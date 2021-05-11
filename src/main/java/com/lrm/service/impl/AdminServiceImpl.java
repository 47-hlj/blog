package com.lrm.service.impl;

import com.lrm.dao.AdminRepository;
import com.lrm.po.Admin;
import com.lrm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin checkAdmin(String username, String password) {
        Admin admin = adminRepository.findByUsernameAndPassword(username, password);
        return admin;
    }
}
