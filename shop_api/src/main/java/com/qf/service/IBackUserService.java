package com.qf.service;

import com.qf.enity.BackUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IBackUserService extends UserDetailsService {
    public List<BackUser> getList();
    public int toInsert(BackUser backUser);
    public int todelete(int id);
    int updateUserRoles(Integer uid, Integer[] rid);

 /*   BackUser login(String username, String password);*/
}
