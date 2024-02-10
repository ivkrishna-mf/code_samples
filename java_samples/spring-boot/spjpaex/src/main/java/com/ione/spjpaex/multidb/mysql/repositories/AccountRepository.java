package com.ione.spjpaex.multidb.mysql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ione.spjpaex.multidb.mysql.domain.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
}
