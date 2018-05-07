//CST-135 group assignment for Topic 6, a collaboration of Richard Boyd, Chad Galloway, and Dennis Witt 

Project timelime:

Weel 1: Develop story board, dispenser UML, and product UML 
Week 2: Expand on product UML by making it abstract and creating subclasses of drink, snack, candy, chips, and gum. 
Week 3: Updated 04-09-18 Made classes drink and snack implement the compartable interface. Added some rudiment form of a user interface 
Week 4: further work on the user interface adding transaction processing.
Week 5: Move inventory management methods into dedicated Inventory Management class, as well as add animation when adding a product to cart.
week 6: added in a majority of the admin features for reordering low stock and tracking items.
week 7: Added ProcessCustomerQueue.java which reads a list of customers and their desired items, and simulates a queue, going through each transaction and showing a short animation.

Our current approach in design is to have a dispenser class with slot loctaions in it and products defined by the product class in those slot locations. When the user purchases a product the code will trigger a dispensing mechanism for the items slot dropping the item to the user. We now have a working pop up window for items in the "cart" as well as a pop up for completing the transaction, that acts as a receipt and resets the rest of the program for the next user, while keeping update inventory levels from the previous transactions. This inventory function is still handled in the same way as before, but from a specific Inventory Mangement class as specified by this week's instructions. There is also an animation of the clicked item moving into the cart logo.

Instructions: This is the full package of working netbeans or Eclipse project code. Run the project, just have all source files in the "vendingmachine" folder and the product images in the "images" sub folder they should package themselves. Click the splash screen anywhere to enter customer mode and hit ctrl-a on the keyboard before clicking to enter the admin mode. Clicking finish returns you to the splash screen.

 View word document "User instructions with screen shots" for a detailed account of the programs features.