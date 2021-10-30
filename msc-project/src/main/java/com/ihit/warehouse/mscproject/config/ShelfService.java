package com.ihit.warehouse.mscproject.config;

import com.ihit.warehouse.mscproject.stock.SlotAllottedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 8/31/2021.
 */
@Service
public class ShelfService {

    @Autowired
    private shelfRepo shelfRepo;
    @Autowired
    private SlotAllottedService slotAllottedService;

    public List getAll(){
        List<Shelf> shelfList = new ArrayList<>();
        shelfList =shelfRepo.findAll();
        for ( Shelf shelf: shelfList) {
            List  list = slotAllottedService.usedSlotByShelf(shelf);
            shelf.setUsedSlot(list.size());
            shelf.setUsedSlotDtl(list);
        }
        return shelfList;
    }
}
