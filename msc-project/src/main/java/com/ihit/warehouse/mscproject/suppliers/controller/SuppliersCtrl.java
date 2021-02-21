package com.ihit.warehouse.mscproject.suppliers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by User on 2/21/2021.
 */
@Controller
public class SuppliersCtrl {
    @GetMapping("/new-supplier")
    public String newSupplier() {
        return "supplier/suppliers_entry_form";
    }

    @GetMapping("/supplier-list")
    public String supplierList() {
        return "supplier/suppliers_list";
    }
}
