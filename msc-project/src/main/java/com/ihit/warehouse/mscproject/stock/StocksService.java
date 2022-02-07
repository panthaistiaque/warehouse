package com.ihit.warehouse.mscproject.stock;

import com.ihit.warehouse.mscproject.delivery.Delivery;
import com.ihit.warehouse.mscproject.delivery.DeliveryDtl;
import com.ihit.warehouse.mscproject.receive.Received;
import com.ihit.warehouse.mscproject.receive.ReceivedDtl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by user on 10/22/2021.
 */
@Service
public class StocksService {
    @Autowired
    private StocksRepo stocksRepo;

    @Autowired
    private SlotAllottedService slotAllottedService;

    public List stockList(){
        return stocksRepo.findAllByOrderByProductCategoryNameAscProductNameAsc();
    }

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

    public void stickDispatch(Delivery delivery) {
        for (DeliveryDtl dtl: delivery.getDtl()) {
            Stocks stocksItem = stocksRepo.findByProduct(dtl.getProduct());
            if (stocksItem != null) {
                stocksItem.setQty(stocksItem.getQty() - dtl.getDeliveredQty());
                stocksItem = stocksRepo.save(stocksItem);
            }
        }
    }

}
