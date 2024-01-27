package com.in28mins.unittesting.data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28mins.unittesting.model.Item;
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{

}
