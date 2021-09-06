package com.ihit.warehouse.mscproject.config;

import com.ihit.warehouse.mscproject.users.DataBind.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by user on 9/6/2021.
 */
public class AppProperty {
    @ModelAttribute
    public void addCommonObjects(Model model, HttpServletRequest request, HttpServletResponse resp, HttpSession httpSession) {


        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal != null) {
            User user = ((User) principal);
            if (user != null) {
                model.addAttribute("user", user);
            }
        }

    }
}
