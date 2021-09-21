package com.ihit.warehouse.mscproject.order;

import com.ihit.warehouse.mscproject.config.AppProperty;
import com.ihit.warehouse.mscproject.product.ProductService;
import com.ihit.warehouse.mscproject.product.UnitService;
import com.ihit.warehouse.mscproject.receive.Received;
import com.ihit.warehouse.mscproject.receive.ReceivedServcie;
import com.ihit.warehouse.mscproject.suppliers.service.SuppliersService;
import com.ihit.warehouse.mscproject.users.DataBind.User;
import com.ihit.warehouse.mscproject.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by user on 9/7/2021.
 */
@Controller
public class OrderCtrl extends AppProperty {
    @Autowired
    OrderService orderService;
    @Autowired
    SuppliersService suppliersService;
    @Autowired
    ProductService productService;
    @Autowired
    UnitService unitService;
    @Autowired
    ReceivedServcie receivedServcie;

    @GetMapping(value = "/order_form")
    private ModelAndView getBrand(ModelAndView modelAndView) {
        modelAndView.addObject("order", new Order());
        modelAndView.addObject("suppliersList", suppliersService.findAll());
        modelAndView.addObject("productList", productService.getAllActiveProduct(true));
        modelAndView.addObject("unitList", unitService.getAllActiveUnit(true));
        modelAndView.setViewName("order/order_entry_form");
        return modelAndView;
    }

    @GetMapping(value = "/order_list")
    private ModelAndView getOrderList(ModelAndView modelAndView, @ModelAttribute("mess") String s) {
        modelAndView.addObject("list", orderService.getAll());
        if (s != null) {
            modelAndView.addObject("message", s);
        }
        modelAndView.setViewName("order/order_list");
        return modelAndView;
    }

    @PostMapping(value = "/saveOrder")
    private ModelAndView saveOrder(ModelAndView modelAndView, Order order, RedirectAttributes redirect) {
        order = orderService.save(order);
        if(order.getId()>0){
            redirect.addFlashAttribute("mess", "Order created successfully");
        }
        modelAndView.setViewName("redirect:/order_list");
        return modelAndView;
    }

    @ResponseBody
    @PostMapping(value = "/order-details/{id}")
    private Order orderDetails(@PathVariable("id") Integer id) {
        return orderService.getOne(id);
    }

    @GetMapping(value = "/order_edit/{id}")
    private ModelAndView editOrder(ModelAndView modelAndView,@PathVariable("id") Integer id) {
        modelAndView.addObject("order", orderService.getOne(id));
        modelAndView.addObject("suppliersList", suppliersService.findAll());
        modelAndView.addObject("productList", productService.getAllActiveProduct(true));
        modelAndView.addObject("unitList", unitService.getAllActiveUnit(true));
        modelAndView.setViewName("order/order_entry_form");
        return modelAndView;
    }

    @PostMapping(value = "/order-froward/{id}")
    private ModelAndView orderFroward(ModelAndView modelAndView,@PathVariable("id") Integer id,RedirectAttributes redirect) {
        Order order = orderService.orderFroward(id);
        if(order.getStatus().equalsIgnoreCase(Status.FROWARD)){
            redirect.addFlashAttribute("mess", "This order forwarded successfully");
        }
        modelAndView.setViewName("redirect:/order_list");
        return modelAndView;
    }
    @PostMapping(value = "/order-receive/{id}")
    private ModelAndView orderReceive(ModelAndView modelAndView,@PathVariable("id") Integer id,RedirectAttributes redirect) {
        Order order = orderService.orderReceive(id);

        receivedServcie.createNewReceive(order);
        if(order.getStatus().equalsIgnoreCase(Status.SEND)){
            redirect.addFlashAttribute("mess", "This order forwarded successfully");
        }
        modelAndView.setViewName("redirect:/order_list");
        return modelAndView;
    }


    @GetMapping(value = "/order-shipment")
    private ModelAndView editOrder(ModelAndView modelAndView,HttpServletRequest request) {
        Integer token = Integer.valueOf(request.getParameter("tk"));
        String validity = request.getParameter("v");
        Integer orderId = Integer.valueOf(request.getParameter("i"));
        User currentUser = new User();
        currentUser.setFirstName(suppliersService.findById(token).getName());
        modelAndView.addObject("user", currentUser);
        Order order = orderService.orderApproved(orderId,token);
        if(order.getStatus().equalsIgnoreCase(Status.APPROVED)){
            modelAndView.addObject("message", "This order APPROVED successfully");
        }else {
            modelAndView.addObject("message", "Please retry again");
        }
        modelAndView.addObject("list", orderService.getAllBySuppliers(token));
        modelAndView.setViewName("order/order_list");
        return modelAndView;
    }

}
