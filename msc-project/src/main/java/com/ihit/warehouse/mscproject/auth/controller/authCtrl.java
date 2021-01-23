package com.ihit.warehouse.mscproject.auth.controller;

import com.ihit.warehouse.mscproject.auth.data.UserData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by user on 1/6/2021.
 */
@Controller
public class authCtrl {
    @ResponseBody
    @GetMapping(value = "/")
    public List userList(){
        return Arrays.asList("Istiaque","Hossain","Pantha");
    }
    @ResponseBody
    @GetMapping(value = "/home")
    public List home(){
        return Arrays.asList("home","page","test");
    }
    @GetMapping("/register")
    public ModelAndView register(final ModelAndView model){
        model.addObject("userData", new UserData());
        model.setViewName("account/from");
        return model;
    }
    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

}
