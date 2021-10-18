package com.ihit.warehouse.mscproject.receive;

import com.ihit.warehouse.mscproject.config.AppProperty;
import com.ihit.warehouse.mscproject.order.Order;
import com.ihit.warehouse.mscproject.users.DataBind.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by User on 9/22/2021.
 */
@Controller
public class ReceiveCtrl extends AppProperty {
    @Autowired
    ReceivedService receivedService;

    @GetMapping(value = "/receive_list")
    public ModelAndView getReceiveList(ModelAndView modelAndView){
        modelAndView.addObject("list", receivedService.getAll());
        modelAndView.setViewName("receive/receive_list");
        return modelAndView;
    }

    @ResponseBody
    @PostMapping(value = "/receive-details/{id}")
    private Received receiveDetail(@PathVariable("id") Integer id) {
        return receivedService.getById(id);
    }
}
