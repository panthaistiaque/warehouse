package com.ihit.warehouse.mscproject.receive;

import com.ihit.warehouse.mscproject.config.AppProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
}
