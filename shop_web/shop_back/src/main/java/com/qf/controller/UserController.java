package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.enity.BackUser;
import com.qf.service.IBackUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/buser")
public class UserController {

    @Reference
    private IBackUserService backUserService;

    @RequestMapping("/userlist")
    public String getList(Model model){
        List<BackUser> userlist = backUserService.getList();
        System.out.println(userlist);
        model.addAttribute("list",userlist);
        return "buserlist";
    }
    @RequestMapping("/insert")
    public String insert(BackUser backUser){
        int i = backUserService.toInsert(backUser);
        return "redirect:/buser/userlist";
    }
    @RequestMapping("/delete")
    public String delete(int id){
        System.out.println(id);
        int i = backUserService.todelete(id);
        return "redirect:/buser/userlist";

    }
    /**
     * 修改职工的所属角色
     *
     */

    @RequestMapping("/updaterole")
    public String updateUserRole(Integer uid, Integer[] rid){

  System.out.println("操作的用户：" + uid + "  添加的角色：" + Arrays.toString(rid));
        backUserService.updateUserRoles(uid, rid);

        return "redirect:/buser/userlist";
    }

}
