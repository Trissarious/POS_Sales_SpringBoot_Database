package com.pos_sales.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_salesTransaction")
public class TransactionModel {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int transactionid;
	
	private double total_quantity;
	private double total_price;
	private String customer_name;
	private String customer_num;
	private String customer_email;
	
	public TransactionModel() {}
	
	public TransactionModel(int transactionid, double total_quantity, double total_price, String customer_name, String customer_num, String customer_email) {
		this.transactionid = transactionid;
		this.total_quantity = total_quantity;
		this.total_price = total_price;
		this.customer_name = customer_name;
		this.customer_num = customer_num;
		this.customer_email = customer_email;
	}
	
	public int getTransactionid() {
		return transactionid;
	}
	
	public double total_quantity() {
		return total_quantity;
	}
	
	public double total_price() {
		return total_price;
	}
	
	public String customer_name() {
		return customer_name;
	}
	
	public String customer_num() {
		return customer_num;
	}
	
	public String customer_email() {
		return customer_email;
	}
}
