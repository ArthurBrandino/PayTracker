package com.ArthurBrandino.PayTracker.repository;

import com.ArthurBrandino.PayTracker.model.Bill;
import com.ArthurBrandino.PayTracker.model.BillStatus;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BillRepository extends JpaRepository<Bill, Long>{

    @Query ("SELECT b FROM Bill b WHERE " +
        "(:description IS NULL OR LOWER(b.description) LIKE LOWER(CONCAT('%', :description, '%'))) AND " +
        "(:category IS NULL OR LOWER(b.category) = LOWER(:category)) AND " +
        "(:status IS NULL OR b.status = :status)")
    List<Bill> findByFilters(
        @Param("description") String description,
        @Param("category") String category,
        @Param("status") BillStatus status
    );
}
