package com.pos_sales.controller;

import com.pos_sales.model.ProductModel;
import com.pos_sales.model.TransactionModel;
import com.pos_sales.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/transaction")
public class TransactionController {

		@Autowired
		TransactionService tserv;

		//Test
				@GetMapping("/print1")
				public String printTest() {
					return "Hello, Test!";
				}
		
				//Create or insert a product record
				@PostMapping("/postTransaction")
				public TransactionModel insertTransaction(@RequestBody TransactionModel transaction) {
					return tserv.insertTransaction(transaction);
				}
				
				//Read all records
				@GetMapping("/getAllTransaction")
				public List<TransactionModel> getAllTransaction(){
					return tserv.getAllTransaction();
				}
				
				//Read a record by transaction id
				@GetMapping("/getByTransaction")
				public TransactionModel findByTransactionid(@RequestParam int transactionid) {
					return tserv.findByTransactionid(transactionid);	
				}
//				
				//Update a record
				@PutMapping("/putTransaction")
				public TransactionModel putTransaction(@RequestParam int transactionid, @RequestBody TransactionModel newTransactionDetails) throws Exception{
					return tserv.putTransaction(transactionid, newTransactionDetails);
				}
				
				//isRefunded
				@PutMapping("/isRefunded")
				public TransactionModel isRefunded(@RequestParam int transactionid, @RequestBody TransactionModel newTransactionDetails) throws Exception{
					return tserv.isRefund(transactionid, newTransactionDetails);
				}
				
				//isReturned
				@PutMapping("/isReturned")
				public TransactionModel isReturned(@RequestParam int transactionid, @RequestBody TransactionModel newTransactionDetails) throws Exception{
					return tserv.isReturned(transactionid, newTransactionDetails);
				}
				
				// Delete a record
				@DeleteMapping("/deleteTransaction/{transactionid}")
				public String deleteTransaction(@PathVariable int transactionid) {
					return tserv.deleteTransaction(transactionid);
				}

				// Read all transactions performed with products purchased
			    @GetMapping("/{transactionid}/products")
			    public List<ProductModel> getProductsForTransaction(@PathVariable int transactionid) {
			        List<ProductModel> products = tserv.getProducts(transactionid);
			        
			        if (products != null) {
			            return products;
			        } else {
			            // Handle the case where the transaction is not found
			            // You can return an error response or appropriate HTTP status code (e.g., 404 Not Found)
			            return null;
			        }
			    }

				@GetMapping("/gross-sales")
				public ResponseEntity<Double> getGrossSales() {
					Double grossSales = tserv.computeGrossSales();

					if (grossSales != null) {
						return ResponseEntity.ok(grossSales);
					} else {
						return ResponseEntity.notFound().build();
					}
				}

				@GetMapping("/net-sales")
				public ResponseEntity<Double> getNetSales() {
					Double netSales = tserv.computeNetSales();

					if (netSales != null) {
						return ResponseEntity.ok(netSales);
					} else {
						return ResponseEntity.notFound().build();
					}
				}

				@GetMapping("/returned-prices")
				public ResponseEntity<Double> getReturnedPrices() {
					Double returnedPrices = tserv.computeReturnedPrices();
					return ResponseEntity.ok(returnedPrices);
				}

				@GetMapping("/returned-products")
				public ResponseEntity<List<ProductModel>> getReturnedProducts() {
					List<ProductModel> returnedProducts = tserv.getReturnedProducts();
					return ResponseEntity.ok(returnedProducts);
				}

				@GetMapping("/refunded-prices")
				public ResponseEntity<Double> getRefundedPrices() {
					Double refundedPrices = tserv.computeRefundedPrices();
					return ResponseEntity.ok(refundedPrices);
				}

				@GetMapping("/refunded-products")
				public ResponseEntity<List<ProductModel>> getRefundedProducts() {
					List<ProductModel> refundedProducts = tserv.getRefundedProducts();
					return ResponseEntity.ok(refundedProducts);
				}
}