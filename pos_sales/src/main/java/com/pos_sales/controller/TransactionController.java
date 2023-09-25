package com.pos_sales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
		
		//@PostMapping("/postTransaction")
		//public TransactionModel insertTransaction(@RequestBody)
}
