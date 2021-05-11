package com.lrm.dao;

import com.lrm.po.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  AdminRepository extends JpaRepository<Admin,Long>{

    Admin findByUsernameAndPassword(String username, String password);
}
