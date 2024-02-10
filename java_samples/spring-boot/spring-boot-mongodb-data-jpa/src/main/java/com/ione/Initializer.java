package com.ione;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ione.model.Car;
import com.ione.service.CarService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
@Order(1)
public class Initializer  implements CommandLineRunner{

	@Lazy
	@Autowired
	private CarService carService;
	
	@Override
	public void run(String... args) throws Exception {
		log.info("initializer started...........");
		
		Car car1 = new Car();
		car1.setCarId(100);
		car1.setComanyName("Volvo");
		car1.setType("SUV");
		
		Car car2 = carService.saveCar(car1);
		
		log.info("saved: car info:"+ car2);
		
		Car car3 = new Car(101,"Suzuki", "Non-suv");
		
		log.info("saving car info:"+ carService.saveCar(car3));
		
		// get by id
		log.info("getting car by id :");
		
		log.info("get the car id having 101:"+ carService.getCarById(101).orElseGet(null));
		
		log.info("get the car id having 111:");
		if(carService.getCarById(111).isPresent()) {
			System.out.println(" 111:"+ carService.getCarById(111).get());
		} else {
			System.out.println("No car found!");
		}
		// gett all cars
		log.info("get all cars ");
		carService.getAllCars().forEach(c -> {System.out.println(c);});
		
		
	}

}
