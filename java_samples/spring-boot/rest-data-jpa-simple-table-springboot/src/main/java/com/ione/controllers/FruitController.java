package com.ione.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ione.entity.Fruit;
import com.ione.service.FruitService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/api/v1")
public class FruitController {
	
	@Autowired
	private FruitService fruitService;
	
	@GetMapping("/fruits")
	public List<Fruit> getAllFruits(){
		
		return fruitService.getAllFruits();
		
	}
	
	@PostMapping("/fruits")
	public Fruit saveFruit(@RequestBody Fruit fruit) {
		
		return fruitService.saveFruit(fruit);
		
		
	}
	
	@PatchMapping("/fruits/{id}")
	public Fruit updateFruit(@PathVariable  Long id, @RequestBody Fruit newFruit) {
		
		return fruitService.updateFruit(id, newFruit);
	}
	
	
	@GetMapping("/fruits/search")
	public List<Fruit> getAllFruits(@RequestParam String color){
		
		log.info("color:"+color);
		
		return fruitService.getFilteredFruits(color);
		
	}
	
	

}
