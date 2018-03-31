
public abstract class Product {
	
	private String productName;          
	private String productLocation;
	private int productQuantity;
	private double productPrice;
	
	public Product() {	//no argument constructor
	}
	
	public Product(String name, String location, int quantity, double price) {   //overloaded constructor with parameters
		productName = name;
		productLocation = location;
		productQuantity = quantity;
		productPrice = price;
	}
	
	public Product(Product copy) {    //overloaded constructor that copies another objects fields
		productName = copy.getName();
		productLocation = copy.getLocation();
		productQuantity = copy.getQuantity();
		productPrice = copy.getPrice();
	}
	
	public String toString() {     //toString method
		return productName + ", " + productLocation + ", " + productQuantity + ", " + productPrice;
	}
	
	public void restockProduct(int newQuantity) {     //restock and reprice methods
		this.productQuantity = newQuantity;
	}
	
	public void repriceProduct(double newPrice) {
		this.productPrice = newPrice;
	}
	
	public void setName(String newName) {     //setters and getters for copying and admin options
		this.productName = newName;
	}
	
	public String getName() {
		return this.productName;
	}
	
	public void setLocation(String newLocation) {
		this.productLocation = newLocation;
	}
	
	public String getLocation() {
		return this.productLocation;
	}
	
	public int getQuantity() {
		return this.productQuantity;
	}
	
	public double getPrice() {
		return this.productPrice;
	}
		
}