package com.FuzzySearch.FuzzyApi.Repository;

import com.FuzzySearch.FuzzyApi.Model.foodItems;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends MongoRepository<foodItems,Long> {


}
