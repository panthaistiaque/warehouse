package com.ihit.warehouse.mscproject.delivery;

import com.ihit.warehouse.mscproject.stock.SlotAllottedService;
import com.ihit.warehouse.mscproject.stock.StocksService;
import com.ihit.warehouse.mscproject.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 11/12/2021.
 */
@Service
public class DeliveryService {
    @Autowired
    DeliveryRepo repo;
    @Autowired
    StocksService stocksService;
    @Autowired
    SlotAllottedService slotAllottedService;

    public void saveDelivery(Delivery delivery){ 
        if(delivery.getStatus().equals(Status.DELIVERY_STATUS.INITIATED)){
            stocksService.stickDispatch(delivery);
            for (DeliveryDtl dtl: delivery.getDtl()) {
                dtl.setDeliveryMap(slotAllottedService.SlotDeAllotted(dtl));
            }
        }
        repo.save(delivery);

    }

    public List getAll() {
        return repo.findAll();
    }

    public Delivery getById(Integer id) {
        return repo.findById(id).get();
    }
}
