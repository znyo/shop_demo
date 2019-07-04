package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qf.enity.BackUser;
import com.qf.enity.UserRoleTable;
import com.qf.mapper.BackUserMapper;
import com.qf.mapper.UserRoleMapper;
import com.qf.service.IBackUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class BackUserImpl implements IBackUserService {

    @Autowired
    private BackUserMapper backUserMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
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

    @Override
    @Transactional
    public int updateUserRoles(Integer uid, Integer[] rid) {
        //根据用户id删除用户和角色的所有关系
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("uid", uid);
        userRoleMapper.delete(queryWrapper);

        //将当前的用户和角色关系进行保存
        for (Integer roleid : rid) {
            UserRoleTable userRoleTable = new UserRoleTable(uid, roleid);
            userRoleMapper.insert(userRoleTable);
        }

        return 1;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BackUser backUser = backUserMapper.queryByUserName(username);
        return backUser;
    }

  /*  @Override
    public BackUser login(String username, String password) {
        BackUser backUser = backUserMapper.queryByUserName(username);

        if(backUser != null && backUser.getPassword().equals(password)){
            //登录成功
            return backUser;
        }
        return null;
    }*/
}
