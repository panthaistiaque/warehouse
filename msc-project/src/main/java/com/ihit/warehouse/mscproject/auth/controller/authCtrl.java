package com.ihit.warehouse.mscproject.auth.controller;

import com.ihit.warehouse.mscproject.auth.data.UserData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 1/6/2021.
 */
@Controller
public class authCtrl {
    @GetMapping(value = "/")
    public ModelAndView userList(final ModelAndView model) {
//        return Arrays.asList("Istiaque","Hossain","Pantha");
        model.setViewName("redirect:/user-list");
        return model;
    }

//    @ResponseBody
//    @GetMapping(value = "/home")
//    public List home() {
//        return Arrays.asList("home", "page", "test");
//    }

    @GetMapping("/register")
    public ModelAndView register(final ModelAndView model) {
        model.addObject("userData", new UserData());
        model.setViewName("account/from");
        return model;
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }


}
