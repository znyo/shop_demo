package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.enity.Role;
import com.qf.service.IRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Reference
    private IRoleService roleService;

    @RequestMapping("/torolelist")
    public String rolelist(Model model){
        List<Role> list = roleService.getList();
        model.addAttribute("list",list);
        return "rolelist";
    }
    @RequestMapping("/insert")
    public String insert(Role role){
        int insert = roleService.insert(role);
        return "redirect:/role/torolelist";
    }
    /*查询所有角色*/
    @RequestMapping("/roleajax")
    @ResponseBody
    public List<Role> roleajax(Integer uid){
        System.out.println(uid);
        List<Role> roles = roleService.roleListByUid(uid);
        return roles;
    }
    /**
     * 修改角色拥有的权限
     * @return
     */
    @RequestMapping("/updatePower")
    @ResponseBody
    public String updatePower(Integer rid, @RequestParam("pids[]") Integer[] pids){
        for (int i = 0; i <pids.length ; i++) {
            System.out.println(pids[i]);
        }
        roleService.updateRolePowers(rid, pids);
        return "succ";
    }

}
