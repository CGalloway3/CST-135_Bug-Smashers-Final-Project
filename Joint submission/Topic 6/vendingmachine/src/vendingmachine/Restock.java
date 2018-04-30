package vendingmachine;

import java.util.ArrayList;

import vendingmachine.Global_Inventory_Management.InventoryItem;

public class Restock {
	
	public ArrayList<InventoryItem> getLowItems(ArrayList<InventoryItem> list) {
		ArrayList<InventoryItem> lowItems = new ArrayList<>();
		for (int i = 0; i < list.size(); i++ ) {
			if (list.get(i).getQuantity() <= 3) {
				lowItems.add(list.get(i));
			}
		}
		
		
		return lowItems;				
	}
	
}
