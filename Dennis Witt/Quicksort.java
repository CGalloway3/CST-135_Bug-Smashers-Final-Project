//CST-135 group assignment for Topic 4, a collaboration of Richard Boyd, Chad Galloway, and Dennis Witt
/**  Program: Vending Machine
 *    File: Product.java
 *    Summary: Base class for products to be sold in the dispenser.
 *    Author: Richard Boyd
 *    Date: April 28, 2018
 **/
package vendingmachine;

import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;


public class Quicksort {
    public static void sortAlpha(ArrayList<InventoryManager.InventoryItem> a) {
        System.out.println(a.size());
        sort(a, 0, a.size() - 1, 0);
        System.out.println(a.size());
    }

    private static void sort(ArrayList<InventoryManager.InventoryItem> a, int low, int high, int d) {
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
        sort(a, low, lt-1, d);
        if(v >= 0) sort(a, lt, ht, d+1);
        sort(a, ht+1, high, d);
    }
 
    private static void exchange(ArrayList<InventoryManager.InventoryItem> a, int i, int i1) {
        InventoryManager.InventoryItem temp = a.get(i);
        a.set(i, a.get(i1));
        a.set(i1, temp);
    }

    static void sortNum(ArrayList<InventoryManager.InventoryItem> a) {
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
        //if(v >= 0) numericSort(a, lt, ht);
        numericSort(a, ht+1, high);
    
    }
    
    public static void main(String[] args) {
        
        try {
        File file = new File("CallStack.txt");
        
        if(!file.exists()) {
            file.createNewFile();
        }
            try (PrintWriter pw = new PrintWriter(file)) {
                pw.println("This is my file content");
                pw.println(100000);
                pw.println();
                pw.close();
                System.out.println("Done");
            }
        
        } catch (IOException e) {
                }
        }
    }
    
    
