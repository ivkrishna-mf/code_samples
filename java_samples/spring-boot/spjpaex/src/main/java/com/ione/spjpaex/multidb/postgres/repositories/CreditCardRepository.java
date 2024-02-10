package com.ione.spjpaex.multidb.postgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ione.spjpaex.multidb.postgres.domain.CreditCardEntity;

public interface CreditCardRepository extends JpaRepository<CreditCardEntity, Long> {
}
