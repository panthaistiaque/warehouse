package com.ihit.warehouse.mscproject.order;

import com.ihit.warehouse.mscproject.config.AppProperty;
import com.ihit.warehouse.mscproject.util.DateUtil;
import com.ihit.warehouse.mscproject.util.EmailUtil;
import com.ihit.warehouse.mscproject.util.Encryption;
import com.ihit.warehouse.mscproject.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by User on 9/10/2021.
 */
@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    EmailUtil emailUtil;

    String mail_body = "<font size=\"2\" face=\"Arial,Helvetica,Tahoma\"> \n" +
            " Dear Sir,<br><br> \n" +
            " <p>A product order has been sent to you from the Automatic Warehouse Management System. This order has been created in Automatic System on  <b>REQUSTED_DATE</b> and you are requested to complete it by <b>REQUERD_DATE</b>. The full details of the order sent to you are given below. \n" +
            " And by clicking on the link sent with this email, the app will be able to view the details of this order and provide some data entry to complete<br><br></p> \n" +
            " <br><p></p> \n" +
            " <table width='100%'> \n" +
            " <tbody> \n" +
            " <tr>\n" +
            "                                       <th style='width='100%'; border: 1px solid black;'>Category</th>\n" +
            "                                       <th style='width='100%'; border: 1px solid black;'>Product Name</th>\n" +
            "                                       <th style='width='100%'; border: 1px solid black;'>Brand</th>\n" +
            "                                       <th style='width='100%'; border: 1px solid black;'>Qrt</th>\n" +
            "                                   </tr> \n" +
            " ORDER_LIST  \n" +
            " </tbody> \n" +
            " </table> \n" +
            " <p></p><br> \n" +
            " <p>view link: LOGIN_LINK</p><br> \n" +
            " </font><br> \n" +
            " This email and any attachments are confidential and may also be privileged. If you are not the intended recipient, please delete all copies and notify the sender immediately. <br>";
    public Order save(Order order){
        if(order.getId()==null){
            order.setStatus(Status.INITIATED);
            order.setActive(true);
        }
        return orderRepo.save(order);
    }

    public List getAll() {
        return orderRepo.findAll();
    }
    public List getAllBySuppliers(Integer id) {
        List list = new ArrayList();
//        list.add(Status.FROWARD);
        list.add(Status.APPROVED);
        return orderRepo.findAllBySuppliersIdAndStatusIn(id,list);
    }

    public Order getOne(Integer id) {
        return orderRepo.findById(id).get();
    }
    public Order getByIsAndSuppliers(Integer id,Integer suppliedId) {
        return orderRepo.findByIdAndSuppliersId(id,suppliedId);
    }

    public Order orderFroward(Integer id) {
        Order order = getOne(id);
        order.setStatus(Status.FROWARD);
        order.setForwardDate(new Date());
        String s = "";
        for (OrderDtl dtl: order.getDtl()) {
            s += "<tr>" +
                    "<td style='width='100%'; border: 1px solid black;'>"+dtl.getProduct().getCategory().getName()+"</td>"+
                    "<td style='width='100%'; border: 1px solid black;'>"+dtl.getProduct().getName()+"</td>"+
                    "<td style='width='100%'; border: 1px solid black;'>"+dtl.getProduct().getBrand().getName()+"</td>"+
                    "<td style='width='100%'; border: 1px solid black;'>"+dtl.getOrderQty()+" "+dtl.getUnit().getName()+"</td>"+
                    "</tr>";
        }
        String link = "http://localhost:8080/order-shipment?tk=" + order.getSuppliers().getId() + "&v=" + String.valueOf(System.currentTimeMillis())+"&i="+ id;
        mail_body = mail_body.replace("ORDER_LIST",s);
        mail_body = mail_body.replace("REQUSTED_DATE", DateUtil.dateFormater(order.getRequestDate(),"dd MMMM yyyy"));
        mail_body = mail_body.replace("REQUERD_DATE", DateUtil.dateFormater(order.getRequiredDate(),"dd MMMM yyyy"));
        mail_body = mail_body.replace("LOGIN_LINK", link);
        emailUtil.manageMail("NewOrdersList",order.getSuppliers().getEmail(),null,mail_body);
        return orderRepo.save(order);
    }

    public Order orderApproved(Integer id, Integer suppliedId) {
        Order order = getByIsAndSuppliers(id, suppliedId);
        order.setStatus(Status.APPROVED);
        order.setApprovedDate(new Date());
        return orderRepo.save(order);
    }
}
