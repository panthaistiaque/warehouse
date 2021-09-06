package com.ihit.warehouse.mscproject.suppliers.controller;

import com.ihit.warehouse.mscproject.suppliers.model.Suppliers;
import com.ihit.warehouse.mscproject.suppliers.service.SuppliersService;
import com.ihit.warehouse.mscproject.systemAdmin.DataBind.ActiviteyTrack;
import com.ihit.warehouse.mscproject.systemAdmin.Service.ActiviteyTrackService;
import com.ihit.warehouse.mscproject.users.DataBind.User;
import com.ihit.warehouse.mscproject.util.DateUtil;
import com.ihit.warehouse.mscproject.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

/**
 * Created by User on 2/21/2021.
 */
@Controller
public class SuppliersCtrl {
    @Autowired
    SuppliersService suppliersService;
    @Autowired
    ActiviteyTrackService activiteyTrackService;

    @GetMapping("/new-supplier")
    public ModelAndView newSupplier( final  ModelAndView modelAndView, @AuthenticationPrincipal User currentUser) {
        modelAndView.addObject("suppliers", new Suppliers());
        modelAndView.addObject("user", currentUser);
        modelAndView.setViewName( "supplier/suppliers_entry_form");
        return modelAndView;
    }

    @GetMapping("/supplier-list")
    public ModelAndView supplierList(  final  ModelAndView modelAndView, @AuthenticationPrincipal User currentUser) {
        modelAndView.addObject("suppliersList", suppliersService.findAll());
        modelAndView.addObject("user", currentUser);
        modelAndView.setViewName(  "supplier/suppliers_list");
        return modelAndView;
    }

    @PostMapping("/saveSuppliers")
    public ModelAndView saveUser(final ModelAndView model, Suppliers suppliers, @AuthenticationPrincipal User currentUser, HttpServletRequest request, HttpSession session) {
        //--------------------------------------
        String s = Status.NOTIFICATION_MESSAGE.SUPPLIERS_INSERT;
        if(suppliers.getId()!=null){
            s = Status.NOTIFICATION_MESSAGE.SUPPLIERS_UPDATE;
        }

        ActiviteyTrack track = new ActiviteyTrack();
        track.setUser(currentUser.getId());
        track.setType(Status.NOTIFICATION_TYPE.USER_NOTIFICATION);
        track.setCode(HttpStatus.OK.value());
        track.setUrl(request.getRequestURI());
        track.setSession(session.getId());
        track.setMessage(s);
        track.setCreatedOn(DateUtil.currentDateTime());
        activiteyTrackService.save(track);
        ///---------------------------------------
        suppliersService.save(suppliers);
        model.setViewName("redirect:/supplier-list");
        return model;
    }

    @GetMapping("/editSuppliers/{id}")
    public ModelAndView editUser(final ModelAndView model, @PathVariable("id") Integer id, @AuthenticationPrincipal User currentUser) {
        model.addObject("suppliers", suppliersService.findById(id));
        model.addObject("user", currentUser);
        model.setViewName( "supplier/suppliers_entry_form");
        return model;
    }

    @PostMapping("/deleteSuppliers/{id}")
    public ModelAndView DeleteSuppliers(final ModelAndView model, @PathVariable("id") Integer id, @AuthenticationPrincipal User currentUser, HttpServletRequest request, HttpSession session) {
        suppliersService.deleteById(id);
        //--------------------------------------
        ActiviteyTrack track = new ActiviteyTrack();
        track.setUser(currentUser.getId());
        track.setType(Status.NOTIFICATION_TYPE.USER_NOTIFICATION);
        track.setCode(HttpStatus.OK.value());
        track.setUrl(request.getRequestURI());
        track.setSession(session.getId());
        track.setMessage(Status.NOTIFICATION_MESSAGE.SUPPLIERS_DELETE);
        track.setCreatedOn(DateUtil.currentDateTime());
        activiteyTrackService.save(track);
        ///---------------------------------------
        model.setViewName("redirect:/supplier-list");
        return model;
    }
}
