package com.watchers.controller;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.watchers.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController // 화면 전환 위해
@RequestMapping("/list/{page}/*/reply")
public class ReplyController {

    @Autowired
    ReplyService replyService;
/*
    public void reply(HttpSession session, Reply reply){
        if(session.getAttribute("id")!=null){
            //로그인을 함

        }
        else{
            //로그인을 안함
        }
    }
*/
}

