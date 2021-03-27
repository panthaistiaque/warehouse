package com.ihit.warehouse.mscproject.shipment.service;

import com.ihit.warehouse.mscproject.shipment.repo.ShipmentRepo;
import com.ihit.warehouse.mscproject.suppliers.model.Suppliers;
import com.ihit.warehouse.mscproject.suppliers.service.SuppliersService;
import com.ihit.warehouse.mscproject.util.EmailUtil;
import com.ihit.warehouse.mscproject.util.Encryption;
import com.ihit.warehouse.mscproject.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by User on 3/9/2021.
 */
@Service
public class ShipmentService {
    @Autowired
    ShipmentRepo shipmentRepo;
    @Autowired
    SuppliersService suppliersService;
    @Autowired
    EmailUtil emailUtil;

    String d = "<font size=\"2\" face=\"Arial,Helvetica,Tahoma\">\n" +
            "Dear MR  CONTACT_PERSON<br><br>\n" +
            "<p>The following products are requested to be delivered to our warehouse within the next <b>7</b> days.<br><br></p>\n" +
            "<br><p></p>\n" +
            "<table width=\"517px\" cellspacing=\"0\" cellpadding=\"0\" border=\"1\" bgcolor=\"#FBFCFF\">\n" +
            "<tbody>\n" +
            "<tr>\n" +
            "<td>Product Type</td>\n" +
            "<td>Product Name</td>\n" +
            "<td>Product Unit</td>\n" +
            "<td>Qty</td>\n" +
            "</tr>\n" +
            " ORDER_LIST "+
            "</tbody>\n" +
            "</table>\n" +
            "<p></p><br>\n" +
            "<p>view link: LOGIN_LINK</p><br>\n" +
            "</font><br>\n" +
            "This email and any attachments are confidential and may also be privileged. If you are not the intended recipient, please delete all copies and notify the sender immediately. <br>\n";
    @Transactional
    public Map<String, Object> saveShipment(Map<String, Object> shipment) {
        Integer orderMasterId = shipmentRepo.saveShipmentMaster(shipment);
        List<Map<String, Object>> maps = (List<Map<String, Object>>) shipment.get("item");
        System.out.println(orderMasterId);
        for (Map<String, Object> obj : maps) {
            obj.put("orderMasterId", orderMasterId);
        }
        int[] detailsId = shipmentRepo.saveShipmentDetails(maps);
        System.out.println(Status.INITIATED);
        return null;
    }

    public List<Map<String, Object>> getAllOrders() {
        return shipmentRepo.getAllOrders();
    }

    public void deleteOrders(Integer id) {
        shipmentRepo.deleteOrders(id);
    }

    public void orderFroward(Integer id) {
        Suppliers suppliers = suppliersService.findById((Integer) shipmentRepo.findOneById(id).get("suppliers_id"));
        List<Map<String, Object>> mapList = shipmentRepo.findOneOrderDetailsById(id);
        String temp = "";
        for (Map<String, Object> obj:mapList) {
            temp +=  "<tr>\n" +
                    "<td>"+obj.get("type")+"</td>\n" +
                    "<td>"+obj.get("name")+"</td>\n" +
                    "<td>"+obj.get("size")+"</td>\n" +
                    "<td>"+obj.get("qty")+"</td>\n" +
                    "</tr>\n" ;
        }
        String s = "http://localhost:8080/vendor-singup?tk=" + suppliers.getToken() + "&v=" + String.valueOf(System.currentTimeMillis())+"&i="+ Encryption.getMd5(String.valueOf(id));
        String e = d.replace("CONTACT_PERSON",suppliers.getContactPersonName());
        e = e.replace("ORDER_LIST", temp);
        e = e.replace("LOGIN_LINK", s);
        emailUtil.manageMail("NewOrdersList", suppliers.getEmail(), s, e);

        shipmentRepo.orderFroward(id);
    }
}
