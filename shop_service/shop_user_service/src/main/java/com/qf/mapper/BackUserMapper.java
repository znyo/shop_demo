package com.qf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.enity.BackUser;
import org.springframework.stereotype.Repository;


@Repository
public interface BackUserMapper extends BaseMapper<BackUser> {
    BackUser queryByUserName(String username);
}
