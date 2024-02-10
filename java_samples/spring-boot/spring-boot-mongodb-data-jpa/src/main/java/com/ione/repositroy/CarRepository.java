package com.ione.repositroy;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ione.model.Car;

@Repository
public interface CarRepository extends MongoRepository<Car, Integer>{

}
