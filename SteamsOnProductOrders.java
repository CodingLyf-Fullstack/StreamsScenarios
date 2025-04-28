package com.example.demo.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQProperties;

class Product {
	private String productId;
	private String productName;
	private String category;
	private double price;
	private String currency;
	private String eventTime; // ISO date string
	private String eventType; // e.g. "PRICE_UPDATE"

	// Constructors
	public Product() {
	}

	public Product(String productId, String productName, String category, double price, String currency,
			String eventTime, String eventType) {
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.price = price;
		this.currency = currency;
		this.eventTime = eventTime;
		this.eventType = eventType;
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

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", category=" + category
				+ ", price=" + price + ", currency=" + currency + ", eventTime=" + eventTime + ", eventType="
				+ eventType + "]";
	}

}

class Order {
	private String orderId;
	private String productId;
	private String userId;
	private double orderAmount;
	private int quantity;
	private String paymentMode;
	private String orderStatus; // e.g. "PLACED", "CANCELLED"
	private String source; // e.g. "WEB", "MOBILE_APP", "POS"
	private String country;
	private String eventTime; // ISO date string

	public Order() {
	}

	public Order(String orderId, String productId, String userId, double orderAmount, int quantity, String paymentMode,
			String orderStatus, String source, String country, String eventTime) {
		this.orderId = orderId;
		this.productId = productId;
		this.userId = userId;
		this.orderAmount = orderAmount;
		this.quantity = quantity;
		this.paymentMode = paymentMode;
		this.orderStatus = orderStatus;
		this.source = source;
		this.country = country;
		this.eventTime = eventTime;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productId=" + productId + ", userId=" + userId + ", orderAmount="
				+ orderAmount + ", quantity=" + quantity + ", paymentMode=" + paymentMode + ", orderStatus="
				+ orderStatus + ", source=" + source + ", country=" + country + ", eventTime=" + eventTime + "]";
	}

}

class MockDataUtil {

	public static List<Product> getMockProducts() {
		List<Product> products = new ArrayList<>();

		products.add(new Product("P12345", "Wireless Mouse", "Electronics", 1499.00, "INR", "2025-04-22T10:05:00Z",
				"PRICE_UPDATE"));

		products.add(new Product("P67890", "Gaming Keyboard", "Electronics", 3499.00, "INR", "2025-04-22T09:55:00Z",
				"PRICE_UPDATE"));

		products.add(new Product("P11111", "Bluetooth Speaker", "Electronics", 1999.00, "INR", "2025-04-22T09:50:00Z",
				"PRICE_UPDATE"));

		products.add(new Product("P22222", "Fitness Tracker", "Wearables", 2999.00, "INR", "2025-04-22T10:00:00Z",
				"PRICE_UPDATE"));

		return products;
	}

	public static List<Order> getMockOrders() {
		List<Order> orders = new ArrayList<>();

		orders.add(new Order("O98765", "P12345", "U67890", 2998.00, 2, "UPI", "PLACED", "MOBILE_APP", "IN",
				"2025-04-22T10:06:12Z"));

		orders.add(new Order("O54321", "P12345", "U12345", 1499.00, 1, "CREDIT_CARD", "PLACED", "WEB", "IN",
				"2025-04-22T10:06:30Z"));

		orders.add(new Order("O22222", "P67890", "U33333", 3499.00, 1, "NET_BANKING", "PLACED", "WEB", "IN",
				"2025-04-22T10:07:12Z"));

		orders.add(new Order("O98765", "P12345", "U67890", 0.00, 0, "UPI", "CANCELLED", "MOBILE_APP", "IN",
				"2025-04-22T10:10:45Z"));

		orders.add(new Order("O45678", "P67890", "U11111", 3499.00, 1, "CASH", "PLACED", "POS", "IN",
				"2025-04-22T10:07:30Z"));

		orders.add(new Order("O45679", "P67890", "U11112", 3499.00, 1, "CASH", "PLACED", "POS", "IN",
				"2025-04-22T10:07:45Z"));

		orders.add(new Order("O45680", "P67890", "U11113", 3499.00, 1, "CASH", "PLACED", "POS", "IN",
				"2025-04-22T10:08:00Z"));

		orders.add(new Order("O99999", "P22222", "U98765", 2999.00, 1, "UPI", "PLACED", "WEB", "IN",
				"2025-04-22T09:59:00Z"));

		orders.add(new Order("O10001", "P11111", "U55555", 1999.00, 1, "CREDIT_CARD", "PLACED", "MOBILE_APP", "IN",
				"2025-04-22T10:09:00Z"));

		orders.add(new Order("O10001", "P11111", "U55555", 1999.00, 1, "CREDIT_CARD", "PLACED", "WEB", "IN",
				"2025-04-22T10:09:10Z"));

		return orders;
	}
}

public class SteamsOnProductOrders {
	public static void main(String[] args) {
		// 1. Get all orders placed via Mobile
		List<Order> mobileAppList = MockDataUtil.getMockOrders().stream()
				.filter(o -> o.getSource().toLowerCase().contains("mobile")).collect(Collectors.toList());
		System.out.println("1. Get all orders placed via Mobile: "+mobileAppList.size());
		System.out.println("");
		
		// 2. List all the product names
		List<String> prodcutNamesList = MockDataUtil.getMockProducts().stream().map(p -> p.getProductName())
				.collect(Collectors.toList());
		System.out.println("2. List all the product names: "+prodcutNamesList);
		System.out.println("");
		
		// 3. Count the number of orders placed for each product.
		Map<Object, Long> numberOfOrdersPerProduct = MockDataUtil.getMockOrders().stream()
				.collect(Collectors.groupingBy(o -> o.getProductId(), Collectors.counting()));
		System.out.println("3. Count the number of orders placed for each product: "+numberOfOrdersPerProduct);
		System.out.println("");
		
		// 4. Find the total revenue generated by "Gaming Keyboard" orders.
		Product gamingProduct = MockDataUtil.getMockProducts().stream()
				.filter(p -> p.getProductName().toLowerCase().equals("gaming keyboard")).findFirst().get();

		Double revenueGeneratedByGamingKeyboards = MockDataUtil.getMockOrders().stream()
				.filter(o -> o.getProductId().equals(gamingProduct.getProductId()))
				.collect(Collectors.summingDouble(o -> o.getOrderAmount()));
		System.out.println("4. Find the total revenue generated by \"Gaming Keyboard\" orders: "+ revenueGeneratedByGamingKeyboards);
		System.out.println("");
		//5. Get a distinct list of payment methods used in the orders.
		List<String> paymentMethodsList = MockDataUtil.getMockOrders().stream().map(o -> o.getPaymentMode()).distinct()
				.toList();
		System.out.println("5. Get a distinct list of payment methods used in the orders: "+paymentMethodsList);
		System.out.println("");
		
		//6. Get the top 2 products with the highest price.
		List<Product> top2ProductsWithHighestPrice  = MockDataUtil.getMockProducts().stream()
				.sorted((o1, o2) -> o1.getPrice() < o2.getPrice() ? 1 : -1).limit(2).toList();
		System.out.println("6. Get the top 2 products with the highest price: "+top2ProductsWithHighestPrice);
		System.out.println("");
		
		//7️. Detect duplicate orders (same orderId) and list them.
		List<Order> duplicateOrdersList =  MockDataUtil.getMockOrders().stream().collect(Collectors.groupingBy(o -> o.getOrderId()))
		 .entrySet()
		 .stream()
		 .filter(map -> map.getValue().size() > 1)
		 .flatMap(o -> o.getValue().stream())
		 .collect(Collectors.toList());
		System.out.println("7: Detect duplicate orders (same orderId) and list them: "+duplicateOrdersList);
		System.out.println("");
		
		// 8.For each product, find total quantity sold across all orders.
		Map<String, Integer> eachProductTotalQuanity = MockDataUtil.getMockOrders().stream()
		.collect(Collectors.groupingBy(o -> o.getProductId(), Collectors.summingInt(p -> p.getQuantity())));

		System.out.println("8. For each product, find total quantity sold across all orders: "+eachProductTotalQuanity);
		System.out.println("");
		//9️ Find the product whose total revenue is highest.
		Map<String, String> productIdNameMap = MockDataUtil.getMockProducts().stream()
				.collect(Collectors.toMap(Product::getProductId, Product::getProductName));
		
		 
		String productNameString = MockDataUtil.getMockOrders().stream()
		.collect(Collectors.groupingBy(o -> o.getProductId(), Collectors.summingDouble(p -> p.getOrderAmount())))
		.entrySet()
		.stream()
		.max(Map.Entry.comparingByValue())
		.map(p -> productIdNameMap.get(p.getKey())).orElse("");
		System.out.println("9. Find the product whose total revenue is highest.: "+productNameString);
	}
}
