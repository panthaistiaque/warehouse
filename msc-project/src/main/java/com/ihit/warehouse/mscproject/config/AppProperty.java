package com.ihit.warehouse.mscproject.config;

import com.ihit.warehouse.mscproject.users.DataBind.User;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
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
    public User user;
    @ModelAttribute
    public void addCommonObjects(Model model, HttpServletRequest request, HttpServletResponse resp, HttpSession httpSession) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            Object principal = authentication.getPrincipal();
            if (principal != null ) {
                user = ((User) principal);
                if (user != null) {
                    model.addAttribute("user", user);
                }
            }
        }


    }
}
