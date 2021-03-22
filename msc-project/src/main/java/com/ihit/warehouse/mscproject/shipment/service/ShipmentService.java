package com.ihit.warehouse.mscproject.shipment.service;

import com.ihit.warehouse.mscproject.shipment.repo.ShipmentRepo;
import com.ihit.warehouse.mscproject.suppliers.model.Suppliers;
import com.ihit.warehouse.mscproject.suppliers.service.SuppliersService;
import com.ihit.warehouse.mscproject.util.EmailUtil;
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
            "<p>Your Request for Domestic Transfer has been received and submitted for processing.<br><br>\n" +
            "Following are the details of the transfer.<br></p>\n" +
            "<br><p></p>\n" +
            "<table width=\"517px\" cellspacing=\"0\" cellpadding=\"0\" border=\"1\" bgcolor=\"#FBFCFF\">\n" +
            "<tbody>\n" +
            "<tr>\n" +
            "<td>Product Type</td>\n" +
            "<td>Product Name</td>\n" +
            "<td>Product Unit</td>\n" +
            "<td>Qty</td>\n" +
            "</tr>\n" +
            "ORDER_LIST"+
            "</tbody>\n" +
            "</table>\n" +
            "<p></p><br>\n" +
            "<p>login link: LOGIN_LINK</p><br>\n" +
            "Cut off Time for a Domestic transfer is 4:30 pm, Monday to Thursday and Sunday. Any transfer submitted after cut off time or on Friday/Saturday/Public Holiday will be processed next working day.<br><br>\n" +
            "Please call Phone Banking  on 16233(From Mobile Phone) / +88-09666777111 / +88-02-8332272 if you need any further assistance.<br>Thank you for using Standard Chartered Online Banking.</font><br>\n" +
            "This email and any attachments are confidential and may also be privileged. If you are not the intended recipient, please delete all copies and notify the sender immediately. You may wish to refer to the incorporation details of Standard Chartered PLC, Standard Chartered Bank and their subsidiaries at https://www.sc.com/en/our-locations. Please refer to https://www.sc.com/en/privacy-policy/ for Standard Chartered Bank’s Privacy Policy.<br>\n";
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
        String s = "http://localhost:8080/vendor-singup?tk=" + suppliers.getToken() + " &v=" + String.valueOf(System.currentTimeMillis());
        emailUtil.manageMail("NewOrdersList", suppliers.getEmail(), s, d.replace("CONTACT_PERSON",suppliers.getContactPersonName()).replace("ORDER_LIST",""));

        shipmentRepo.orderFroward(id);
    }
}
