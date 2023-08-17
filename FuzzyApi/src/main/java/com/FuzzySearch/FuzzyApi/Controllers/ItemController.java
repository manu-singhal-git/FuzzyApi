package com.FuzzySearch.FuzzyApi.Controllers;

import com.FuzzySearch.FuzzyApi.Model.foodItems;
import com.FuzzySearch.FuzzyApi.Services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

         @GetMapping("/search")
        public List<foodItems> result(@RequestParam String name){

            int threshold = 4;
            List<foodItems> dataset=itemService.getAll();

            List<foodItems> result = itemService.fuzzySearch(name, dataset, threshold);
            return result;

        }
        @PostMapping("/add")
    public List<foodItems> add(@RequestBody foodItems item){
             itemService.add(item);
             return itemService.getAll();

        }
    }

