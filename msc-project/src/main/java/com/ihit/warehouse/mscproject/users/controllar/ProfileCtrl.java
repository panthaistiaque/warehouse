package com.ihit.warehouse.mscproject.users.controllar;

import com.ihit.warehouse.mscproject.users.DataBind.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by User on 8/14/2021.
 */
@Controller
public class ProfileCtrl {
    @GetMapping("/profile-view")
    public ModelAndView deleteUser(final ModelAndView model, @AuthenticationPrincipal User currentUser) {
        model.addObject("user", currentUser);
        model.addObject("profile", currentUser);
        model.setViewName("users/profile");
        return model;
    }
}
