package com.pos_sales.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos_sales.model.TransactionModel;
import com.pos_sales.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	TransactionRepository trepo;
		
	//C - create or insert a product record
	public TransactionModel insertTransaction(TransactionModel transaction) {
		return trepo.save(transaction);
	}
	
	//R -Read or search for transaction record by transaction id
	public TransactionModel findByTransactionid(String transactionid) {
		if (trepo.findByTransactionid(transactionid) !=null)
			return trepo.findByTransactionid(transactionid);
		else
			return null;
	}
	
	//D - Delete transactionrecord
	public String deleteTransaction(int transactionid) {
		String msg;
		if (trepo.findById(transactionid) !=null) {
			trepo.deleteByTransactionid(transactionid);
			
			msg = "Transaction "+ transactionid + " succesfully deleted!";
		} else
			msg = "Transaction " + transactionid + "is NOT found!";
		
		return msg;
	}
}
