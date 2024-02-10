package com.ione.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ione.model.Car;
import com.ione.repositroy.CarRepository;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarRepository carRepository;
	
	@Override
	public Car saveCar(Car car) {
		return carRepository.save(car);
	}

	@Override
	public Optional<Car> getCarById(int id) {
				
		return carRepository.findById(id);
	}

	@Override
	public List<Car> getAllCars() {
		return carRepository.findAll();
	}

}
