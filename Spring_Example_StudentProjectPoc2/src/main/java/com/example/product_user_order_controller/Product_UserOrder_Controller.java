package com.example.product_user_order_controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.product_user_order_serivce.Product_UserOrder_Service;
import com.example.product_usuer_order.Message;
import com.example.product_usuer_order.Product;
import com.example.product_usuer_order.UserOrder;

@RestController
@RequestMapping("/rest")
public class Product_UserOrder_Controller {
	@Autowired
private Product_UserOrder_Service pus;

	// creating userid
	
	   @PostMapping("/create")
	   public Product create(@RequestBody Product product) {
	   return pus.createProduct(product);	
		}
	
	   @PostMapping("/order/create")
		public UserOrder createuser(@RequestBody UserOrder order) {
			return pus.createuser(order);
		}
		
		@GetMapping("/order/list")
		public Iterable<UserOrder> getAllUserOrder() {
			return pus.getAllUser();
		}
		@GetMapping("/rest/user")
		public Optional<UserOrder>getUserOrder(@RequestParam("code")Integer code) {
			return pus.getUserOrder(code);
		}
		
//		@PostMapping("/product/list")
//		public Product createProduct(@RequestParam Product product) {
//			return pus.createProduct(product);	
//		}
		@GetMapping("/product/list")
		public Iterable<Product> getInfo() {
			return pus.getInfo();
		}
		@GetMapping("/product/{id}")
		public Optional<Product>getProduct(@PathVariable("id")Integer id) {
			return pus.getProduct(id);
		}
		@GetMapping("/order/place")
		public Message placeOrder(@RequestParam("id") Integer id, @RequestParam("quantity") Integer quantity) {
			Message msg = getMsgObj();
			try {
				UserOrder order = new UserOrder();
				int code = pus.placeOrder(id, quantity, order);
				if(code == 0) {
					msg.setCode(0);
					msg.setMessage("Success");
				}
				else if(code == 1) {
					msg.setCode(1);
					msg.setMessage("Invalid");
				}
				return msg;
			} catch (Exception e) {
				return msg;
			}
		}
		@GetMapping("/order/update")
		public Message updateOrder(@RequestParam("id") Integer id, @RequestParam("quantity") Integer quantity) {
			Message msg = getMsgObj();
			try {
				int code = pus.updateOrder(id, quantity);
				if(code == 0) {
					msg.setCode(0);
					msg.setMessage("Success");
				}
				else if(code == 1) {
					msg.setCode(1);
					msg.setMessage("Invalid");
				}
				return msg;
			} catch (Exception e) {
				return msg;
			}
		}
		
		public static Message getMsgObj() {
			return new Message();
		}
}
		