package com.ihit.warehouse.mscproject.config;

import com.ihit.warehouse.mscproject.users.DataBind.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by User on 8/31/2021.
 */
@Controller
public class ShelfCtrl {
@Autowired
    ShelfService shelfService;

    @PostMapping(value = "/shelf")
    @ResponseBody
    public List getShelf(){
        return shelfService.getAll();
    }

    @GetMapping("/home")
    public ModelAndView deleteUser(final ModelAndView model, @AuthenticationPrincipal User currentUser) {
        model.addObject("user", currentUser);
        model.setViewName("dashboard/home");
        return model;
    }
}
