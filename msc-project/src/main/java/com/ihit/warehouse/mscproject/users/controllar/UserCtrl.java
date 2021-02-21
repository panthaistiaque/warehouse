package com.ihit.warehouse.mscproject.users.controllar;

import com.ihit.warehouse.mscproject.users.DataBind.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by User on 2/21/2021.
 */
@Controller
public class UserCtrl {
    @GetMapping("/new-user")
    public ModelAndView newUser(final ModelAndView model) {
        model.addObject("user", new User());
        model.setViewName("users/new_entry_form");
        return model;
    }

    @GetMapping("/user-list")
    public String userList() {
        return "users/userList";
    }

    @PostMapping("/saveUser")
    public ModelAndView saveUser(final ModelAndView model, User user) {
        model.setViewName("users/new_entry_form");
        return model;
    }
}
