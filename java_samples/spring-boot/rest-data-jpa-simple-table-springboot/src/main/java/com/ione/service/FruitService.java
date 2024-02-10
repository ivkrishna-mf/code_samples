package com.ione.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ione.entity.Fruit;
import com.ione.exceptions.NoFruitsFoundException;
import com.ione.repository.FruitRepository;

@Service
public class FruitService {
	
	@Autowired
	private FruitRepository fruitRepository;
	
	
	public List<Fruit> getAllFruits(){
		
		if(fruitRepository.findAll().size() != 0)
			
		return fruitRepository.findAll();
		
		else throw new NoFruitsFoundException("No Fruits available");
		
		
		
		
	}
	
	public Fruit saveFruit(Fruit fruit) {
		
		
		return fruitRepository.save(fruit);
	}
	
	public Fruit updateFruit(Long id , Fruit newFruit) {
		
		 Fruit old = fruitRepository.getReferenceById(id);
		if(newFruit.getName()!=null) {
			old.setName(newFruit.getName());
		}
		
		if(newFruit.getColor()!=null) {
			old.setColor(newFruit.getColor());
		}
		
		return fruitRepository.save(old);
	}
	
	public List<Fruit> getFilteredFruits(String color){
		
		return fruitRepository.findAll().stream().filter(f -> f.getColor().equals(color)).toList();
		
	}

}
