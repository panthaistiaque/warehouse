package com.ihit.warehouse.mscproject.stock;

import com.ihit.warehouse.mscproject.config.SlotRepo;
import com.ihit.warehouse.mscproject.product.ProductModel;
import com.ihit.warehouse.mscproject.receive.ReceivedDtl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by user on 10/22/2021.
 */
@Service
public class SlotAllottedService {
    @Autowired
    SlotAllottedRepo slotAllottedRepo;
    @Autowired
    AllottedSlotCustomRepo slotCustomRepo;
    @Autowired
    SlotRepo slotRepo;

    public void SlotAllotted(ReceivedDtl dtl,  Stocks stocks){
        SlotAllotted slotAllotted = new SlotAllotted();
        slotAllotted.setProduct(dtl.getProduct());
        slotAllotted.setUnit(dtl.getUnit());
        slotAllotted.setStock(stocks);
        slotAllotted.setActive(true);
        slotAllotted.setFull(true);
        slotAllotted.setSlot(slotRepo.findById(slotCustomRepo.findFreeSlot(dtl.getProduct())).get());
        slotAllotted.setQty(dtl.getApproveQty());

        slotAllottedRepo.save(slotAllotted);
    }
}
