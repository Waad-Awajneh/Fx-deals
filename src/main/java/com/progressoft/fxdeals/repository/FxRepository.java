package com.progressoft.fxdeals.repository;

import com.progressoft.fxdeals.exceptionhandler.FxDealValidationException;
import com.progressoft.fxdeals.model.DealEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(noRollbackFor = RuntimeException.class,propagation = Propagation.REQUIRES_NEW)

public interface FxRepository extends JpaRepository<DealEntity, Integer> {
}
