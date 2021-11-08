package com.ihit.warehouse.mscproject.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by user on 11/5/2021.
 */
@Controller
public class StocksCtrl {
    @Autowired
    StocksService stocksService;

    @PostMapping(value = "/stocks-list")
    @ResponseBody
    public List stockList(){
        return stocksService.stockList();
    }

}
