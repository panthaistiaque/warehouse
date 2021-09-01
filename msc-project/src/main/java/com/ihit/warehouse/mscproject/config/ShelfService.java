package com.ihit.warehouse.mscproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by User on 8/31/2021.
 */
@Service
public class ShelfService {

    @Autowired
    private shelfRepo shelfRepo;

    public List getAll(){
        return shelfRepo.findAll();
    }
}
