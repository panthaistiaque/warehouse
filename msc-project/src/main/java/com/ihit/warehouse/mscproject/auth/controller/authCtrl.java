package com.ihit.warehouse.mscproject.auth.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by user on 1/6/2021.
 */
@RestController
public class authCtrl {
    @GetMapping(value = "/")
    public List userList(){
        return Arrays.asList("Istiaque","Hossain","Pantha");
    }

}
