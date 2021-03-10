package com.ihit.warehouse.mscproject.shipment.service;

import com.ihit.warehouse.mscproject.shipment.repo.ShipmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by User on 3/9/2021.
 */
@Service
public class ShipmentService {
    @Autowired
    ShipmentRepo shipmentRepo;

    public Map<String, Object> saveShipment(Map<String, Object> shipment) {
        shipmentRepo.saveShipment(shipment);
        return null;
    }
}
