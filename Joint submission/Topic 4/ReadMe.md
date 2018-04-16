//CST-135 group assignment for Topic 4, a collaboration of Richard Boyd, Chad Galloway, and Dennis Witt
/**  Program: Vending Machine
*    File: Dispenser.java
*    Summary: Current Working build of our Vending Machine
*    Author: Richard Boyd, Chad Galloway
*    Date: April 15th, 2018
**/

Project timelime:

  Weel 1: 
    Develop story board, dispenser UML, and product UML
  Week 2:
    Expand on product UML by making it abstract and creating subclasses of drink, snack, candy, chips, and gum.
  Week 3: Updated 04-09-18
    Made classes drink and snack implement the compartable interface. Added some rudiment form of a user interface
  week 4: further work on the user interface adding transaction processing.

    
  Our current approach in design is to have a dispenser class with slot loctaions in it and products defined by the product class 
in those slot locations. When the user purchases a product the code will trigger a dispensing mechanism for the items slot dropping
the item to the user. We now have a working pop up window for items in the "cart" as well as a pop up for completing the transaction, that acts as a receipt and resets the rest of the program for the next user, while keeping update inventory levels from the previous transactions.
  
Instructions:
  This is the full package of working netbeans or Eclipse project code. Run the project, just have all source files in the "vendingmachine" folder and the product images in the "images" sub folder they should package themselves.
Click the splash screen anywhere to enter customer mode and hit ctrl-a on the keyboard before clicking to enter the admin mode. No implemintation is available for administrative mode as of yet. Clicking finish returns you to the splash screen. At the customer screen, you can either use the buttons on the left to add currency, or click one of the categories to see available items. clicking an item adds it to your cart. The right sidebar shows how much currency you have added and your cart's current total cost. Clicking complete purchase prints a receipt and dispenses whatever change it many owe you, if any.

