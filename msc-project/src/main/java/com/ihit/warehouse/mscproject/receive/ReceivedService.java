package com.ihit.warehouse.mscproject.receive;

import com.ihit.warehouse.mscproject.order.Order;
import com.ihit.warehouse.mscproject.order.OrderDtl;
import com.ihit.warehouse.mscproject.stock.StocksService;
import com.ihit.warehouse.mscproject.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by User on 9/22/2021.
 */
@Service
public class ReceivedService {
    @Autowired
    ReceivedRepo receivedRepo;
    @Autowired
    StocksService stocksService;

    public Received createNewReceive(Order order){
        Received received = new Received();
        received.setOrder(order);
        received.setStatus(Status.RECEIVE_STATUS.INITIATED);
        received.setReceiveDate(new Date());
        received.setSuppliers(order.getSuppliers());
        List list = new ArrayList();
        for (OrderDtl dtl: order.getDtl() ) {
            ReceivedDtl receivedDtl = new ReceivedDtl();
            receivedDtl.setOrderQty(dtl.getOrderQty());
            receivedDtl.setProduct(dtl.getProduct());
            receivedDtl.setUnit(dtl.getUnit());
            list.add(receivedDtl);
        }
        received.setDtl(list);
        return receivedRepo.save(received);
    }



    public List getAll(){
        return receivedRepo.findAll();
    }

    public Received getById(Integer id){
        return receivedRepo.findById(id).get();
    }

    public Received receivedConfirm(Received received){
        receivedRepo.save(received);
        stocksService.stickRaise(received);
        return received;
    }
}
