package com.ihit.warehouse.mscproject.users.controllar;

import com.ihit.warehouse.mscproject.config.AppProperty;
import com.ihit.warehouse.mscproject.users.DataBind.User;
import com.ihit.warehouse.mscproject.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by User on 2/21/2021.
 */
@Controller
public class UserCtrl extends AppProperty {
    @Autowired
    UserService userService;
    @GetMapping("/new-user")
    public ModelAndView newUser(final ModelAndView model) {
        model.addObject("newuser", new User());
        model.setViewName("users/new_entry_form");
        return model;
    }

    @GetMapping("/editUser/{id}")
    public ModelAndView editUser(final ModelAndView model,@PathVariable("id") Integer id) {
        User user = userService.getOne(id);
        model.addObject("newuser", user);
        model.setViewName("users/new_entry_form");
        return model;
    }

    @GetMapping("/user-list")
    public ModelAndView userList(final ModelAndView model) {
        model.addObject("list", userService.findAll());
        model.setViewName("users/userList");
        return model;
    }

    @PostMapping("/saveUser")
    public ModelAndView saveUser(final ModelAndView model, User user) {
        userService.save(user);
        model.setViewName("redirect:/user-list");
        return model;
    }
    @PostMapping("/deleteUser/{id}")
    public ModelAndView deleteUser(final ModelAndView model,@PathVariable("id") Integer id) {
        userService.deleteById(id);
        model.setViewName("redirect:/user-list");
        return model;
    }
}
