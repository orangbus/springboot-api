package com.orangbus.video.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.orangbus.video.bean.UserLogin;
import com.orangbus.video.dao.UsersDao;
import com.orangbus.video.empty.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class Login {

  @Autowired private UsersDao usersDao;

  /** 登录 */
  @GetMapping("/login")
  public String login() {
    return "login/index";
  }

  @PostMapping("/user/login")
  public String login(
      @RequestParam String username,
      @RequestParam String password,
      HttpSession session,
      UserLogin user,
      RedirectAttributes redirectAttributes) {
    // 简单空判断
    if (username == null || password == null) {
      redirectAttributes.addAttribute("msg", "请输入用户名和密码");
      return "redirect:login/index";
    }

//    QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
//    queryWrapper.eq("name", username);
//    queryWrapper.eq("password", password);
//    Users user = usersDao.selectOne(queryWrapper);
    if (user == null) {
      redirectAttributes.addFlashAttribute("msg", "用户名或密码不正确");
      return "redirect:/login";
    }
    session.setAttribute("user", user);
    redirectAttributes.addFlashAttribute("user", user);
    return "redirect:/user";
  }

  /** 注册 */
  @GetMapping("register")
  public String register() {
    return "login/register";
  }

  @PostMapping("/user/register")
  public String register(
      @RequestParam String username,
      @RequestParam String password,
      RedirectAttributes redirectAttributes,
      HttpServletRequest request) {
//    if (username == null || password == null) {
//      redirectAttributes.addFlashAttribute("msg", "请输入用户名和密码");
//      return "redirect:register";
//    }
    Users user = new Users();
    user.setName(username);
    user.setPassword(password);
    user.setIp(request.getRemoteAddr());
    user.setCreatedAt(new Date());
    user.setUpdatedAt(new Date());

    int count = usersDao.insert(user);
    if (count == 0) {
      redirectAttributes.addFlashAttribute("msg", "注册成功，请登录");
    } else {
      redirectAttributes.addFlashAttribute("msg", "注册成功，请登录");
    }
    return "redirect:/login";
  }

  /**
   * 退出登录
   */
  @GetMapping("/logout")
  public String logout(HttpSession session){
    session.removeAttribute("user");
    return "redirect:/login";
  }

  /** 忘记密码 */
  @GetMapping("/forget")
  public String forget() {

    return "login/forget";
  }
}
