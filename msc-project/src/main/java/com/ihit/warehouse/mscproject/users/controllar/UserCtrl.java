package com.ihit.warehouse.mscproject.users.controllar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by User on 2/21/2021.
 */
@Controller
public class UserCtrl {
    @GetMapping("/new-user")
    public String newUser() {
        return "users/new_entry_form";
    }

    @GetMapping("/user-list")
    public String userList() {
        return "users/userList";
    }
}
