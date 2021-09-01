package com.ihit.warehouse.mscproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by User on 8/31/2021.
 */
@Service
public class ShelfService {
    @Autowired
    private shelfRepo shelfRepo;
}
