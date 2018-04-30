package vendingmachine;

import java.util.ArrayList;

public class Restock extends Global_Inventory_Management{
	
	public static ArrayList<InventoryItem> lowLocal = new ArrayList<>();
	public static ArrayList<InventoryItem> lowRemote = new ArrayList<>();
	public static ArrayList<InventoryItem> alphLocal = new ArrayList<>();
	public static ArrayList<InventoryItem> alphRemote = new ArrayList<>();
	public static ArrayList<InventoryItem> numLocal = new ArrayList<>();
	public static ArrayList<InventoryItem> numRemote = new ArrayList<>();
	
	
	public ArrayList<InventoryItem> getLowLocal() {
		for (int i = 0; i < getLocalInventoryList().size(); i++ ) {
			if (getLocalInventoryList().get(i).getQuantity() <= 3) {
				lowLocal.add(getLocalInventoryList().get(i));
			}
		}
		return lowLocal;						
	}
	
	
	
}
