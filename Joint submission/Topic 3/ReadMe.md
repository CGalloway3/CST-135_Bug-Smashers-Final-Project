//CST-135 group assignment for Topic 2, a collaboration of Richard Boyd, Chad Galloway, and Dennis Witt
/**  Program: Vending Machine
*    File: .java
*    Summary: 
*    Author: Richard Boyd
*    Date: March 30th, 2018
**/

Project timelime:

  Weel 1: 
    Develop story board, dispenser UML, and product UML
  Week 2:
    Expand on product UML by making it abstract and creating subclasses of drink, snack, candy, chips, and gum.
  Week 3: Updated 04-09-18
    Made classes drink and snack implement the compartable interface. Added some rudiment form of a user interface
    
  Our current approach in design is to have a dispenser class with slot loctaions in it and products defined by the product class 
in those slot locations. When the user purchases a product the code will trigger a dispensing mechanism for the items slot dropping
the item to the user.
  
Instructions:
  This is the full package of working code. Run the main class, just have them all in the same folder and they should package themselves.
Type the product name to dispense it and type admin to enter administrative mode. No password access is available for administrative 
mode as of yet. Type x to exit the program.

