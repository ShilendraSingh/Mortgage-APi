package com.hcl.mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.mortgage.entity.LoanDetails;


@Repository
public interface LoanRepository extends JpaRepository<LoanDetails, Integer> {

}
