package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.enity.BackUser;
import com.qf.mapper.BackUserMapper;
import com.qf.service.IBackUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class BackUserImpl implements IBackUserService {

    @Autowired
    private BackUserMapper backUserMapper;

    @Override
    public List<BackUser> getList() {
        return backUserMapper.selectList(null);
    }

    @Override
    public int toInsert(BackUser backUser) {
        return backUserMapper.insert(backUser);
    }

    @Override
    public int todelete(int id) {
        return backUserMapper.deleteById(id);
    }
}
