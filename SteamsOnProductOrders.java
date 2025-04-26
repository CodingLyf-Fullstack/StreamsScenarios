package com.example.demo.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Product {
	private String productId;
	private String productName;
	private String category;
	private double price;
	private String currency;

	// Constructors
	public Product() {
	}

	public Product(String productId, String productName, String category, double price, String currency) {
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.price = price;
		this.currency = currency;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", category=" + category
				+ ", price=" + price + ", currency=" + currency + "]";
	}

}

class Order {
	private String orderId;
	private String productId;
	private double orderAmount;
	private int quantity;
	private String paymentMode;
	private String orderStatus; // e.g. "PLACED", "CANCELLED"
	private String source; // e.g. "WEB", "MOBILE_APP", "POS"

	public Order() {
	}

	public Order(String orderId, String productId, double orderAmount, int quantity, String paymentMode,
			String orderStatus, String source) {
		this.orderId = orderId;
		this.productId = productId;
		this.orderAmount = orderAmount;
		this.quantity = quantity;
		this.paymentMode = paymentMode;
		this.orderStatus = orderStatus;
		this.source = source;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productId=" + productId + ", orderAmount="
				+ orderAmount + ", quantity=" + quantity + ", paymentMode=" + paymentMode + ", orderStatus="
				+ orderStatus + ", source=" + source +"]";
	}

}

class MockDataUtil {

	public static List<Product> getMockProducts() {
		List<Product> products = new ArrayList<>();

		products.add(new Product("P12345", "Wireless Mouse", "Electronics", 1499.00, "INR"));

		products.add(new Product("P67890", "Gaming Keyboard", "Electronics", 3499.00, "INR"));

		products.add(new Product("P11111", "Bluetooth Speaker", "Electronics", 1999.00, "INR"));

		products.add(new Product("P22222", "Fitness Tracker", "Wearables", 2999.00, "INR"));

		return products;
	}

	public static List<Order> getMockOrders() {
		List<Order> orders = new ArrayList<>();

		orders.add(new Order("O98765", "P12345", 2998.00, 2, "UPI", "PLACED", "MOBILE_APP"));

		orders.add(new Order("O54321", "P12345", 1499.00, 1, "CREDIT_CARD", "PLACED", "WEB"));

		orders.add(new Order("O22222", "P67890", 3499.00, 1, "NET_BANKING", "PLACED", "WEB"));

		orders.add(new Order("O98765", "P12345", 0.00, 0, "UPI", "CANCELLED", "MOBILE_APP"));

		orders.add(new Order("O45678", "P67890", 3499.00, 1, "CASH", "PLACED", "POS"));

		orders.add(new Order("O45679", "P67890", 3499.00, 1, "CASH", "PLACED", "POS"));

		orders.add(new Order("O45680", "P67890", 3499.00, 1, "CASH", "PLACED", "POS"));

		orders.add(new Order("O99999", "P22222", 2999.00, 1, "UPI", "PLACED", "WEB"));

		orders.add(new Order("O10001", "P11111", 1999.00, 1, "CREDIT_CARD", "PLACED", "MOBILE_APP"));

		orders.add(new Order("O10001", "P11111", 1999.00, 1, "CREDIT_CARD", "PLACED", "WEB"));

		return orders;
	}
}

public class ProductOrders {
	public static void main(String[] args) {
		// 1. Get all orders placed via Mobile
		/**
		 * Hint: Filter orders where the source contains the word "mobile". 
		 * Convert the result to a list and get the size.
		 **/
		List<Order> mobileAppList = MockDataUtil.getMockOrders().stream()
				.filter(o -> o.getSource().toLowerCase().contains("mobile")).collect(Collectors.toList());
		System.out.println(mobileAppList.size());

		// 2. List all the product names.
		/**
		 * Hint:
		 * Extract the product names from the product list. 
		 * Collect them into a new list.
		 **/

		
		// 3. Count the number of orders placed for each product.
		/**
		 * Hint:
		 * Group the orders by the product ID. 
		 * Count how many orders are placed for each product.
		 **/

		
		// 4. Find the total revenue generated by "Gaming Keyboard" orders.
		/**
		 * Hint:
		 * First, find the product with the name "Gaming Keyboard".
		 * Filter orders based on this product ID and sum (Collectors.summingDouble)  their amounts .
		 **/
		
		
		// 5. Get a distinct list of payment methods used in the orders.
		/**
		 * Hint:
		 * Extract the payment methods from the orders .
		 * Get only distinct values (no duplicates).
		 */
		
		
		// 6. Get the top 2 products with the highest price.
		/**
		 * Hint: 
		 * Sort the products by price in descending order (use .sorted).
		 * Limit the result to the top 2 products.
		 */
		
		
		// 7️. Detect duplicate orders (same orderId) and list them.
		/**
		 * Hint: 
		 * Group the orders by order ID (Use Collectors.groupingBy).
		 * Iterate through entrySet
		 * Filter where value size is greater than 1.
		 */
		
		
		// 8.For each product, find total quantity sold across all orders.
		/**
		 * Hint:
		 * Group the orders by product ID (Use Collectors.groupingBy).
		 * Sum the quantities for each product (Use Collectors.summingInt).
		 */
		

		//9️ Find the product whose total revenue is highest.
		/**
		 * Hint: Group the orders by product ID and sum the revenue for each(Use
		 * Collectors.groupingBy and Collectors.summingDouble). 
		 * Find the product with the highest total revenue.
		 */
	}
}
