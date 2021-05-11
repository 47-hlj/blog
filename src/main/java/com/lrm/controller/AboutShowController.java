package com.lrm.controller;

import com.lrm.dao.UserRepository;
import com.lrm.po.User;
import com.lrm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AboutShowController {
    @Autowired
    private UserService userService;

    @GetMapping("/about/{id}")
    public String about(@PathVariable Long id, Model model) {
        model.addAttribute("owner", userService.getUser(id));
        return "about";
    }
    @GetMapping("/about/{id}/input")
    public String aboutInput(@PathVariable Long id,Model model){
        model.addAttribute("owner",userService.getUser(id));
        return "user/introduce-input";
    }

    @PostMapping("/about/{id}/save")
    public  String aboutSave(@ModelAttribute User user, @PathVariable Long id, RedirectAttributes attributes){
        //System.out.println("user="+user);填入的信息已经传了过来了
        User u;
        u = userService.setUserAbout(id, user);
        System.out.println("user="+user);
        if (u == null ) {
            attributes.addFlashAttribute("message", "操作失败");
        } else {
            attributes.addFlashAttribute("message", "操作成功");
        }
        return "redirect:/about/{id}";
    }
}
