package com.application.wallet;

import org.springframework.data.jpa.repository.JpaRepository;


public interface WalletJpaRepository extends JpaRepository<WalletDto,Integer>{

}
