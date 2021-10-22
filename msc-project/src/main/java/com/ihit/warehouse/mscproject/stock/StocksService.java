package com.ihit.warehouse.mscproject.stock;

import com.ihit.warehouse.mscproject.receive.Received;
import com.ihit.warehouse.mscproject.receive.ReceivedDtl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by user on 10/22/2021.
 */
@Service
public class StocksService {
    @Autowired
    private StocksRepo stocksRepo;

    @Autowired
    private SlotAllottedService slotAllottedService;

    public void stickRaise(Received received) {
        for (ReceivedDtl model : received.getDtl()) {
            Stocks stocksItem = stocksRepo.findByProduct(model.getProduct());
            if (stocksItem != null) {
                stocksItem.setQty(stocksItem.getQty() + model.getApproveQty());

            } else {
                stocksItem = new Stocks();
                stocksItem.setProduct(model.getProduct());
                stocksItem.setQty(model.getApproveQty());
            }
            stocksItem.setLastUpdateOn(new Date());
            stocksItem = stocksRepo.save(stocksItem);
            slotAllottedService.SlotAllotted(model,stocksItem);
        }
    }
}
