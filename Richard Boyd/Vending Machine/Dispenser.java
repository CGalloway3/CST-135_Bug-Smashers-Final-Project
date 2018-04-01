package vendingmachine;

import java.util.ArrayList;

public class Dispenser {
	
	ArrayList<Object> productlist = new ArrayList<Object>();
	
	public Dispenser() {
		createProducts();
	}
	
	private ArrayList<Object> createProducts() {              //creates products
		
		Drink pepsi = new Drink("Pepsi", "A1", 10, 1.75);
		productlist.add(pepsi);
		
		Drink dietpepsi = new Drink(pepsi);
		dietpepsi.setName("Diet Pepsi");
		dietpepsi.setLocation("A2");
		productlist.add(dietpepsi);
		
		
		Chips ruffles = new Chips("Ruffles", "B1", 5, 1.00);
		productlist.add(ruffles);
		
		Chips doritos = new Chips(ruffles);
		doritos.setName("Doritos");
		doritos.setLocation("B2");
		productlist.add(doritos);
		
		
		Candy kitkat = new Candy("Kit Kat", "C1", 12, .75);
		productlist.add(kitkat);
		
		Candy snickers = new Candy(kitkat);
		snickers.setName("Snickers");
		snickers.setLocation("C2");
		productlist.add(snickers);
		
		
		Gum orbitpep = new Gum("Orbit Peppermint", "D1", 15, .50);
		productlist.add(orbitpep);
		
		Gum orbitspear = new Gum(orbitpep);
		orbitspear.setName("Orbit Spearmint");
		orbitspear.setLocation("D2");
		productlist.add(orbitspear);
		
		return productlist;
		
	}
	
	public void displayProducts() {   //Displays products on their own line using a simple loop
		
		int counter = 0;
		
		while (counter < productlist.size()) {
			
			System.out.println(productlist.get(counter).toString());
			
			counter++;
			
		}
		
	}
	
}
