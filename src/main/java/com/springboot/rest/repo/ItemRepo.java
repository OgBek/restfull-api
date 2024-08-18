package com.springboot.rest.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.rest.model.Items;

public interface ItemRepo extends JpaRepository<Items, Long> {

	
}
