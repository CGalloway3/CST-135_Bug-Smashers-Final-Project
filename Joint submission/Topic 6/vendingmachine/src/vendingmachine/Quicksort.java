//CST-135 group assignment for Topic 4, a collaboration of Richard Boyd, Chad Galloway, and Dennis Witt
/**  Program: Vending Machine
 *    File: Product.java
 *    Summary: Base class for products to be sold in the dispenser.
 *    Author: Richard Boyd
 *    Date: April 28, 2018
 **/
package vendingmachine;

import java.util.ArrayList;

public class Quicksort {
    public static void sortAlpha(ArrayList<InventoryManager.InventoryItem> a) {
        alphaSort(a, 0, a.size() - 1, 0);
    }

    private static void alphaSort(ArrayList<InventoryManager.InventoryItem> a, int low, int high, int d) {
        if (high <= low) return;
        int lt = low, ht = high;
        if ( a.get(low).getName().length() <= d ) return;
        int v = a.get(low).getName().charAt(d);
        int i = low + 1;
        while (i <= ht)
        {
            if ( a.get(i).getName().length() <= d ) return;
            int t = a.get(i).getName().charAt(d);
            if (t < v) exchange(a, lt++, i++);
            else if (t > v) exchange(a, i, ht--);
            else
                i++;
        }

        // Recursive call
        alphaSort(a, low, lt-1, d);
        if(v >= 0) alphaSort(a, lt, ht, d+1);
        alphaSort(a, ht+1, high, d);
    }
 
     public static void sortNum(ArrayList<InventoryManager.InventoryItem> a) {
        numericSort(a, 0, a.size() - 1);
    }

    private static void numericSort(ArrayList<InventoryManager.InventoryItem> a, int low, int high) {
        if (high <= low) return;
        int lt = low, ht = high;
        int v = a.get(low).getQuantity();
        int i = low + 1;
        while (i <= ht)
        {
            int t = a.get(i).getQuantity();
            if (t < v) exchange(a, lt++, i++);
            else if (t > v) exchange(a, i, ht--);
            else
                i++;
        }

        // Recursive call
        numericSort(a, low, lt-1);
        numericSort(a, ht+1, high);    
    }

    private static void exchange(ArrayList<InventoryManager.InventoryItem> a, int i, int i1) {
        InventoryManager.InventoryItem temp = a.get(i);
        a.set(i, a.get(i1));
        a.set(i1, temp);
    }
    
    public static ArrayList<InventoryManager.InventoryItem> itemSearch() {
        return null;
    }
}