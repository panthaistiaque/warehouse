package com.ihit.warehouse.mscproject.receive;

import com.ihit.warehouse.mscproject.config.AppProperty;
import com.ihit.warehouse.mscproject.order.Order;
import com.ihit.warehouse.mscproject.users.DataBind.User;
import com.ihit.warehouse.mscproject.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.Map;

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

    @PostMapping(value = "/saveReceive")
    private ModelAndView saveReceiveConfirm(ModelAndView modelAndView, RedirectAttributes redirect, @RequestBody Received req) {
        req.setStatus(Status.RECEIVE_STATUS.APPROVED);
        req.setApprovedDate(new Date());
        receivedService.receivedConfirm(req);
        modelAndView.setViewName("redirect:/receive_list");
        return modelAndView;
    }

    @PostMapping(value = "/receive-delete/{id}")
    private ModelAndView receiveDelete(ModelAndView modelAndView,@PathVariable("id") Integer id) {
        receivedService.receiveDelete(id);
        modelAndView.setViewName("redirect:/brand_list");
        return modelAndView;
    }
}
