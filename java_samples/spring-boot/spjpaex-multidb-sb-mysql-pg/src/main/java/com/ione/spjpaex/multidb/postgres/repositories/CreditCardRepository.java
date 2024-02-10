package com.ione.spjpaex.multidb.postgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ione.spjpaex.multidb.postgres.domain.CreditCard;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
