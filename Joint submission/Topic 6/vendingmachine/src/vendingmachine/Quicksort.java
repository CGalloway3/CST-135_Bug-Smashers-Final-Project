//CST-135 group assignment for Topic 4, a collaboration of Richard Boyd, Chad Galloway, and Dennis Witt
/**  Program: Vending Machine
 *    File: Product.java
 *    Summary: Base class for products to be sold in the dispenser.
 *    Author: Richard Boyd
 *    Date: April 28, 2018
 **/
package vendingmachine;

import static sun.text.normalizer.UTF16.charAt;

public class Quicksort {
    private static void sort(String[] a) {
        sort(a, 0, a.length - 1, 0);
    }

    private static void sort(String[] a, int low, int high, int d)
    {
        if (high <= low) return;
        int lt = low, gt = high;
        int v = charAt(a[low], d);
        int i = low + 1;
        while (i <= gt)
        {
            int t = charAt(a[i], d);
            if (t < v) exchange(a, lt++, i++);
            else if (t > v) exchange(a, i, gt--);
            else
                i++;
        }

        // Recursive call
        sort(a, low, lt-1, d);
        if(v >= 0) sort(a, lt, gt, d+1);
        sort(a, gt+1, high, d);
    }
 private static void exchange(String[] a, int i, int i1) {

 }
}

