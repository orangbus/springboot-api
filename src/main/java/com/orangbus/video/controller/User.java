package com.orangbus.video.controller;

import com.orangbus.video.dao.UsersDao;
import com.orangbus.video.empty.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class User {
    @Autowired
    private UsersDao usersDao;

    @GetMapping("user")
    public String index(Model model, HttpServletRequest request){
        Users user = usersDao.selectById(1);
        model.addAttribute("apikey","njdsjdisnfudsnfdisnfdisniufdsndfnsfdsfd");
        model.addAttribute("user",user);
        return "user/index";
    }

}
