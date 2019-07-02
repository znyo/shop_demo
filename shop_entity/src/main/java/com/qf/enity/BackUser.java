package com.qf.enity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BackUser implements Serializable {

    @TableId(type = IdType.AUTO)
    private  Integer id;
    private String username;
    private String password;
    private String name;
    private Integer sex;
    private Date createtime;
    private Integer status;
}
