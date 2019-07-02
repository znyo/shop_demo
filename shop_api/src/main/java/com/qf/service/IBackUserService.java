package com.qf.service;

import com.qf.enity.BackUser;

import java.util.List;

public interface IBackUserService {
    public List<BackUser> getList();
    public int toInsert(BackUser backUser);
    public int todelete(int id);
}
