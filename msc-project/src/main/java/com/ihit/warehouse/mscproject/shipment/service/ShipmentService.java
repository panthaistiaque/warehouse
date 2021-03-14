package com.ihit.warehouse.mscproject.shipment.service;

import com.ihit.warehouse.mscproject.shipment.repo.ShipmentRepo;
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

    @Transactional
    public Map<String, Object> saveShipment(Map<String, Object> shipment) {
        Integer orderMasterId = shipmentRepo.saveShipmentMaster(shipment);
        List<Map<String, Object>>  maps = (List<Map<String, Object>>) shipment.get("item");
        System.out.println(orderMasterId);
        for (Map<String, Object> obj: maps) {
            obj.put("orderMasterId", orderMasterId);
        }
        int[] detailsId= shipmentRepo.saveShipmentDetails(maps);
        System.out.println(Status.INITIATED);
        return null;
    }
}
