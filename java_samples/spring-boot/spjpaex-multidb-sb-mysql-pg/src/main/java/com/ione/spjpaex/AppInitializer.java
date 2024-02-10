package com.ione.spjpaex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ione.spjpaex.multidb.mysql.domain.Account;
import com.ione.spjpaex.multidb.mysql.repositories.AccountRepository;
import com.ione.spjpaex.multidb.postgres.domain.CreditCard;
import com.ione.spjpaex.multidb.postgres.repositories.CreditCardRepository;
//import com.ione.spjpaex.service.FruitsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Order(value = 1)
public class AppInitializer implements CommandLineRunner{
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private CreditCardRepository creditCardRepository;

	@Override
	public void run(String... args) throws Exception {
		log.info("App Initalizer started.............................................................................");
		
		//mysql entity
		log.info("saving to mysql db entity: AccountEntity");
		Account acc = new Account();
		acc.setNumber("111");
		
		acc = accountRepository.save(acc);
		
		log.info("saved mysql entity:AE");
		
		
		
		
		//postgres enitity
		
		
		log.info("saving to postgres db entity: CreditcardEntity");
		CreditCard ce = new CreditCard();
		ce.setNumber("4444");
		ce.setType("Rewards");
		ce = creditCardRepository.save(ce);
		
		log.info("saved postgres entity: CE");
		
	}
	
	

}
