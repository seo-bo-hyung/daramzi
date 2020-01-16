package com.happy.controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.happy.exception.IdPasswordNotMatchingException;
import com.happy.service.UserService;
import com.happy.util.AuthInfo;
import com.happy.util.LoginCommand;

@Controller
public class LoginController {

    @Resource(name="userService")
    private UserService userSer;
 
    @RequestMapping(value="/login")
    public ModelAndView loginSuccess(@Valid LoginCommand loginCommand, BindingResult bindingResult,
                                    HttpSession session, HttpServletResponse response) throws Exception {
 
        if(bindingResult.hasErrors()) {
            ModelAndView mv = new ModelAndView("user/login/loginForm");
            return mv;
        }
        
        try {
            AuthInfo authInfo = userSer.loginAuth(loginCommand);
            session.setAttribute("authInfo", authInfo);
            Cookie rememberCookie = new Cookie("REMEMBER", loginCommand.getId());
            rememberCookie.setPath("/");
            System.out.println("리멤버 아이디 확인 : " + loginCommand.isRememberId());
            System.out.println("리멤버 쿠키값 확인1 : " + rememberCookie);
            
            if(loginCommand.isRememberId()) {
                rememberCookie.setMaxAge(60*60*24*7);
            } else {
                rememberCookie.setMaxAge(0);
            }
            response.addCookie(rememberCookie);
            
        } catch (IdPasswordNotMatchingException e) {
            bindingResult.rejectValue("pw", "notMatch", "아이디와 비밀번호가 맞지않습니다.");
            ModelAndView mv = new ModelAndView("user/login/loginForm");
            return mv;
        }
        
        ModelAndView mv = new ModelAndView("redirect:/");
        return mv;
    }
    
    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.invalidate();
        ModelAndView mv = new ModelAndView("redirect:/");
        return mv;
    }
}