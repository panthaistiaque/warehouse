package com.ihit.warehouse.mscproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by User on 8/31/2021.
 */
@RestController
public class ShelfCtrl {
@Autowired
    ShelfService shelfService;

    @GetMapping(value = "/shelf")
    public List getShelf(){
        return shelfService.getAll();
    }
}
