package com.ione.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ione.model.Car;

@Service
public interface CarService {
	
	public Car saveCar(Car car); 
	
	public Optional<Car> getCarById(int id);
	
	public List<Car> getAllCars();

}
