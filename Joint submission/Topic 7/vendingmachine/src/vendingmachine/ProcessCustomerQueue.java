package vendingmachine;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ProcessCustomerQueue {
	
	ArrayList<Customer> customerQueue = new ArrayList<>();
	
	public ProcessCustomerQueue() {
		
	}
	
	public void addToQueue(Customer newCustomer) {
		customerQueue.add(newCustomer);
	}
	
	public void printQueue() throws IOException {
		FileWriter writer = new FileWriter("Customer Queue");
		writer.append("Customer Name,Items Ordered\n");
		for (int i=0; i < this.customerQueue.size(); i++) {
			writer.append(this.customerQueue.get(i).getName() + "," + this.customerQueue.get(i).getSelection() + "\n");
		}
		writer.append("END");
		writer.close();
	}
	
	
	
	
	
	public class Customer {
		private String customerName;
		private String customerSelection;
		
		public Customer(String name) {
			this.customerName = name;
		}
		
		public Customer(String name, String cart) {
			this.customerName = name;
			this.customerSelection = cart;
		}
		
		public void addCustomerItem(String item) {
			this.customerSelection = this.customerSelection + "," + item;
		}
		
		public String getName() {
			return this.customerName;
		}
		
		public String getSelection() {
			return this.customerSelection;
		}
		
	}
	
}


