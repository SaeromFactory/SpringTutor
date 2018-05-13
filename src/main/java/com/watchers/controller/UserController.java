package com.watchers.controller;


import java.util.Map;

import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.watchers.model.CommonResponse;
import com.watchers.model.Users;
import com.watchers.service.UserService;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@RequestMapping("users")
@RestController
public class UserController {

    @Autowired
    private SqlSession sql;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public CommonResponse login(@ModelAttribute Users user, HttpSession session) {
        session.setAttribute("user", user);
        return userService.login(user);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addUser(Map<String, Object> user) {
        userService.addUser(user);
        return "성공";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(Map<String, Object> user) {
        // DB에 있는거 확인 ?

        if (user.get("id").equals(user.containsKey("id"))) {
            return "redirect:/";
            // 초기 화면으로 이동
        }
        return "redirect:login";
    }

    @RequestMapping(value = "/logout")
    public String logout(@ModelAttribute Users user, HttpSession session) {
        String page = "redirect:/";
        session.removeAttribute("user");
        return page;
    }

    @RequestMapping(value="/find/pw", method = RequestMethod.POST)
    public String find_pw(Users user, RedirectAttributes redirectater){
        String getid = user.getId();
        int rst = userService.getByID(getid);
        if(rst ==0){
          return "아이디가 없습니다";
        }else if(rst==1){
            return "아이디가 존재합니다";
            // 이메일로 전송 ?
        }
        return "알 수 없는 요청입니다.";
    }

}
