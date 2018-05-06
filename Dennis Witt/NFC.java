//CST-135 group assignment for Topic 4, a collaboration of Richard Boyd, Chad Galloway, and Dennis Witt
/**  Program: Vending Machine
 *    File: Product.java
 *    Summary: Base class for products to be sold in the dispenser.
 *    Author: Dennis Witt
 *    Date: May 3, 2018
 **/

import VendingMachine.NfcException;
import VendingMachine.NfcManager;

import java.util.*;

package VendingMachine;

public class NFC {

    // Apple pay or google pay
        public static void main(String[] args) throws NfcException {
        NfcManager mgt = NfcManager.getInstance(null);
        try {
            System.out.println(mgt.getProperty("open_nfc.version"));
            System.out.println(mgt.getProperty("nfcc.firmware_version"));
        } finally {
            mgt.stop();
        }
    }
}
