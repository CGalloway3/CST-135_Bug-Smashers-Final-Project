//CST-135 group assignment for Topic 4, a collaboration of Richard Boyd, Chad Galloway, and Dennis Witt
/**  Program: Vending Machine
*    File: Product.java
*    Summary: Base class for products to be sold in the dispenser.
*    Author: Richard Boyd
*    Date: March 30th, 2018
**/

package vendingmachine;

public abstract class Product implements IPurchasableProduct{
	
    // Private fields
    
	private String productName;          
	private String productLocation;
	private int productQuantity;
	private int productPrice;
	
    // Public constructors
        
        public Product() {	//no argument constructor
            productName = "";
            productLocation = "";
            productQuantity = 0;
            productPrice = 0;
        }
	
	public Product(String name, String location, int quantity, int price) {   //overloaded constructor with parameters
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
	
	
    // Public accessors for private fields.
	
	public String getName() {
		return this.productName;
	}
	public String getLocation() {
		return this.productLocation;
	}
	public int getQuantity() {
		return this.productQuantity;
	}
	public int getPrice() {
		return this.productPrice;
	}
        
    // Public inventory management methods
        
	public void renameProduct(String newName) {    
		this.productName = newName;
	}
	public void relocateProduct(String newLocation) {
		this.productLocation = newLocation;
	}
	public void restockProduct(int newQuantity) {     //restock and reprice methods
		this.productQuantity = newQuantity;
	}
    public void repriceProduct(int newPrice) {
		this.productPrice = newPrice;
	}
	
    // Additional public methods
        
	@Override
        public void addProductToProductsSelectedForPurchase() {
            PRODUCTS_SELECTEDFORPURCHASE.add(this);
        }
        
        @Override
        public void removeProductFromProductsForPurchase() {
            PRODUCTS_SELECTEDFORPURCHASE.remove(this);
        }
                
	@Override
        public String toString() {     //toString method
		return String.format(this.getName() + "\n$" + this.getPrice() / 100 + ".%02d", this.getPrice() % 100);
	}
	
		
}