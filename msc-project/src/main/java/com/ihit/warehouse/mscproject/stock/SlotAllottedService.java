package com.ihit.warehouse.mscproject.stock;

import com.ihit.warehouse.mscproject.config.Slot;
import com.ihit.warehouse.mscproject.config.SlotRepo;
import com.ihit.warehouse.mscproject.product.ProductModel;
import com.ihit.warehouse.mscproject.receive.ReceivedDtl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    public void SlotAllotted(ReceivedDtl dtl, Stocks stocks) {
        SlotAllotted slotAllotted = new SlotAllotted();
        SlotAllotted slotAllots;
        slotAllotted.setProduct(dtl.getProduct());
        slotAllotted.setUnit(dtl.getUnit());
        slotAllotted.setStock(stocks);
        slotAllotted.setActive(true);
        slotAllotted.setLastUpdateOn(new Date());
//        slotAllotted.setSlot(slotRepo.findById(slotCustomRepo.findFreeSlot(dtl.getProduct())).get());
        List list = slotCustomRepo.findFreeSlot(dtl.getProduct());
        int item = dtl.getApproveQty();
        List<SlotAllotted> objectList = new ArrayList<>();
        int j = 0;
        if (item % 2 != 0) {
            item = item - 1;
            slotAllots = findHalfFullSlot(dtl.getProduct());
            if (slotAllots != null) {
                slotAllotted = slotAllots;
                slotAllotted.setQty(2);
                slotAllotted.setFull(true);
            } else {
                slotAllotted.setSlot((Slot) list.get(j));
                slotAllotted.setQty(1);
                slotAllotted.setFull(false);
                j++;
            }

            objectList.add(slotAllotted);
//            slotAllottedRepo.save(slotAllotted);
        }

        for (int i = 0; i < item / 2; i++) {
            SlotAllotted sa = new SlotAllotted();
            BeanUtils.copyProperties(slotAllotted, sa);
            sa.setId(null);
            sa.setQty(2);
            sa.setSlot((Slot) list.get(j));
            sa.setFull(true);
            objectList.add(sa);
            j++;
//            slotAllottedRepo.save(sa);
        }

        slotAllottedRepo.saveAll(objectList);
    }

    public SlotAllotted findHalfFullSlot(ProductModel product) {
        return slotAllottedRepo.findByProductAndIsFull(product, false);
    }
}
