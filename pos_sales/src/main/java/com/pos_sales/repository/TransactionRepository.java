package com.pos_sales.repository;

import com.pos_sales.model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TransactionRepository extends JpaRepository<TransactionModel, Integer>{
		TransactionModel findByTransactionid(int transactionid);

		@Query(value = "SELECT SUM(total_price) FROM TransactionModel")
		Double computeGrossSales();

		List<TransactionModel> findByReturned(boolean returned);

		List<TransactionModel> findByRefunded(boolean refunded);
}