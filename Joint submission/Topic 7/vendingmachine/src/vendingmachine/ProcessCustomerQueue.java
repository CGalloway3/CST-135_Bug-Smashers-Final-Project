//CST-135 group assignment for Topic 7, a collaboration of Richard Boyd, Chad Galloway, and Dennis Witt
/**  Program: Vending Machine
 *    File: ProcessCustomerQueue.java
 *    Summary: Virtual customer queue control
 *    Author: Richard Boyd, Chad Galloway.
 *    Date: May 03, 2018
 *    Last Updated: May 04, 2018
 **/
package vendingmachine;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import vendingmachine.InventoryManager;

public class ProcessCustomerQueue{
	
	
	private Dispenser dispenser;
        LinkedList<Customer> customerQueue = new LinkedList<>();
	
	public ProcessCustomerQueue(Dispenser dispenser) {
           this.dispenser = dispenser;
           readQueueFile();
	}
	
	public Customer first() {
            if ( customerQueue.isEmpty()) {
                return null;
            }
            else {
                return customerQueue.getFirst();
            }
        }
        
        public int length() {
            return customerQueue.size();
        }
        
        public Boolean in(Customer customer) {
            customerQueue.addLast(customer);
            return true;
        }
        
        public Boolean out() {
            customerQueue.removeFirst();
            return true;
        }
        
        public Boolean isEmpty() {
            return customerQueue.isEmpty();
        }
        
        public void readQueueFile() {
            Scanner queueFileScanner = new Scanner(getClass().getResourceAsStream("files/Customer Queue.csv"));
            while (queueFileScanner.hasNextLine()) {
                String scannedLine = queueFileScanner.nextLine();
                String[] scannedLineArray = scannedLine.split(",");
                this.in(new Customer(scannedLineArray[0], scannedLineArray[1]));
            }
            queueFileScanner.close();
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

        public void processQueue() {
            CustomerDisplay customerDisplay = new CustomerDisplay(dispenser);
            
            // Initialize Customer line
            customerDisplay.lineCustomersUp();
            
            // next customer
            customerDisplay.nextCustomer();

        }
	
	public void processCurrentCustomerInQueue(CustomerDisplay customerDisplay) {
            // seartch for what customer wants and add it to cart
            InventoryManager.InventoryItem customerSelectedItem;
            
            customerSelectedItem = dispenser.quicksort.queueSearch(first().getSelection());
            
            if ( customerSelectedItem == null ) {
                customerSelectedItem = dispenser.inventoryManager.getLocalInventoryList().get((int)(Math.random() * dispenser.inventoryManager.getLocalInventoryList().size()));
                customerDisplay.customerDone("Vending machine does not have " + first().getSelection() + " so,\n" + first().getName() + " purchased " + customerSelectedItem.getName() + " for " + customerSelectedItem.getFormattedPrice() + "\n");

            }
            else {
                // Remove customer from queue
                customerDisplay.customerDone(first().getName() + " purchased " + customerSelectedItem.getName() + " for " + customerSelectedItem.getFormattedPrice() + "\n");
            }
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


