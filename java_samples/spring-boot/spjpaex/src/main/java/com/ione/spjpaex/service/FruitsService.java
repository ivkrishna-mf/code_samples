//package com.ione.spjpaex.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.ione.spjpaex.entity.Fruits;
//import com.ione.spjpaex.repository.FruitsRepository;
//
//@Service
//public class FruitsService {
//	
//	@Autowired
//	private FruitsRepository fruitsRepository;
//	
//	
//	
//	public List<Fruits> getAllFruits(){
//		List<Fruits> fruitsList = new ArrayList<Fruits>();
//		
//		fruitsRepository.findAll().forEach(fruit -> fruitsList.add(fruit));
//		
//		return fruitsList;
//	}
//		public Fruits saveFruit(Fruits fruits) {
//			
//			return fruitsRepository.save(fruits);
//			
//		}
//		
//	}
//
//
