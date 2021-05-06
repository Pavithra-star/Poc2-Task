package com.example.product_user_order_serivce;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product_dao.ProductDao;
import com.example.product_dao.UserOrderDao;
import com.example.product_usuer_order.Product;
import com.example.product_usuer_order.UserOrder;

@Service
public class Product_UserOrder_Service {

	@Autowired
	private UserOrderDao userdao;

	public UserOrder createuser(UserOrder user) {
		return userdao.save(user);

	}

	public Iterable<UserOrder> getAllUser() {
		return userdao.findAll();
	}

	public Optional<UserOrder> getUserOrder(Integer code) {
		return userdao.findById(code);

	}

	public void deleteUser(Integer code) {
		userdao.deleteById(code);
	}

	@Autowired
	private ProductDao pdao;

	public Product createProduct(Product product) {
		// TODO Auto-generated method stub
		return pdao.save(product);
	}

	public Iterable<Product> getInfo() {
		// TODO Auto-generated method stub
		return pdao.findAll();
	}

	public Optional<Product> getProduct(Integer id) {
		// TODO Auto-generated method stub
		return pdao.findById(id);
	}

	public int placeOrder(Integer productId, Integer quantity, UserOrder order) {
		int result = 1;
		Product product = pdao.findById(productId).orElse(new Product());
		if (product == null)
			return result;
		order.setQuantity(quantity);

		order.setProducts(product);
		userdao.save(order);
		result = 0;
		return result;

	}

	public int updateOrder(Integer id, Integer quantity) {
		int result = 1;
		UserOrder order = userdao.findById(id).orElse(new UserOrder());
		if (order.getOrderId() == 0) {
			return result;
		}
		order.setQuantity(quantity);
		userdao.save(order);
		result = 0;
		return result;

	}

	

	

}
