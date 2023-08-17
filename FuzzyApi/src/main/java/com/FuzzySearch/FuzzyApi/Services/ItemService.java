package com.FuzzySearch.FuzzyApi.Services;

import com.FuzzySearch.FuzzyApi.Model.foodItems;
import com.FuzzySearch.FuzzyApi.Repository.ItemsRepository;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemsRepository itemsRepository;
    public List<foodItems> getAll(){
       return itemsRepository.findAll();

    }
    public static List<foodItems> fuzzySearch(String query, List<foodItems> dataset, int threshold) {
        String[] queryTokens = query.split("\\s+");
        LevenshteinDistance levenshteinDistance = new LevenshteinDistance();

        List<foodItems> matches = new ArrayList<>();

        for (foodItems item : dataset) {
            String[] itemTokens = item.getName().split("\\s+");
            boolean allTokensMatch = true;

            for (String queryToken : queryTokens) {
                boolean tokenMatch = Arrays.stream(itemTokens)
                        .anyMatch(itemToken -> levenshteinDistance.apply(queryToken, itemToken) <= threshold);

                if (!tokenMatch) {
                    allTokensMatch = false;
                    break;
                }
            }

            if (allTokensMatch) {
                matches.add(item);
            }
        }

        return matches;
    }
    public foodItems add(foodItems item){
        itemsRepository.save(item);
        return item;
    }
}
