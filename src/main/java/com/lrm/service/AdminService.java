package com.lrm.service;

import com.lrm.po.Admin;

public interface  AdminService {

    Admin checkAdmin(String username, String password);
}
