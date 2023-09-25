package com.pos_sales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pos_sales.model.TransactionModel;
import com.pos_sales.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	TransactionService tserv;
	
		@GetMapping("/print")
		public String printHelloTransaction() {
			return "Hello, Transaction!";
		}
		
		@PostMapping("/postTransaction")
		public TransactionModel insertTransaction(@RequestBody TransactionModel transaction) {
			return tserv.insertTransaction(transaction);
		}
		
		@GetMapping("/getAllProduct")
		public List<TransactionModel> getAllTransaction(){
			return tserv.getAllTransaction();
		}
		
		@GetMapping("/getById")
		public TransactionModel findByTransactionid(@RequestParam int transactionid) {
			return tserv.findByTransactionid(transactionid);
		}
		
		@DeleteMapping("/deleteTransaction/{transactionid}")
		public String deleteTransaction(@PathVariable int transactionid) {
			return tserv.deleteTransaction(transactionid);
		}
}
