For internal use only!!

4-15-18 20:53 CST: (Chad) Removed line "p.restockProduct(p.getQuantity() - 1);" in populateItemGrid in favor of putting the same code into the Product class under addProductToProductsSelectedForPurchase() now the adding and removing od quanitity is handled privately within the Product class itself.

4-15-18 18:56 CST: (Richard) Added line that updates product quantities when added to cart.
                                -also updates buttons after every click, preventing you from adding more of an item to your cart then                                      there is in stock.
                              Exit button changes label to "cancel order" when there is something in the cart.
                              Exit button adds product back to quantities because they weren't actually purchased.
                              Added padding and spacing to cart and receipt windows for readability.
                              Adjusted some product locations to look more uniform.

4-15-18 18:19 CST: (Richard) changed "finished" button to "Exit" button

4-15-18 17:38 CST: (Richard) finished funcionality of receiptStage to show cost, update funds, dispense change, and reset primary stage

4-15-18 17:07 CST: (Richard) Changed loop that creates cart and receipt pop ups to operate in the same way the grid buttons populate

4-15-18 16:42 CST: (Richard) updated build to work as Eclipse Javafx project (not sure if will cause problems in netbeans)

4-15-18 22:02 CST: (Richard) Changed the way the my items/cart pop up populates, I tried to add  remove item functionality but I can't seem to figure it out right now. It's not required for this week, so I will come back to it next week. For now, it just brings up the items currently in cart, and everything else works as intended.

4-15-18 18:56 CST: (Richard) Added line that updates product quantities when added to cart.
                                -also updates buttons after every click, preventing you from adding more of an item to your cart then                                      there is in stock.
                              Exit button changes label to "cancel order" when there is something in the cart.
                              Exit button adds product back to quantities because they weren't actually purchased.
                              Added padding and spacing to cart and receipt windows for readability.
                              Adjusted some product locations to look more uniform.

4-15-18 18:19 CST: (Richard) changed "finished" button to "Exit" button

4-15-18 17:38 CST: (Richard) finished funcionality of receiptStage to show cost, update funds, dispense change, and reset primary stage

4-15-18 17:07 CST: (Richard) Changed loop that creates cart and receipt pop ups to operate in the same way the grid buttons populate

4-15-18 16:42 CST: (Richard) updated build to work as Eclipse Javafx project (not sure if will cause problems in netbeans)

4-15-18 16:15 CST: (Chad) Continue cleaning and commenting code.

4-15-18 15:53 CST: (Chad) Converted all toString mothods to use String.format to eliminate values like "$1.0". Now all monitary values are represented properly in teo decimal places.

4-15-18 15:33 CST: (Chad) Reduced the lines of code in the populateItemGrid method by turning all item buttons into an array of buttons. Each button no longer has to be set seperately they can be set enmass.

4-15-18 14:49 CST: (Chad) Removed the cart ArrayList in favor of the IPurchasableProduct static ArrayList PRODUCTS_SELECTEDFORPURCHASE. Adding and removing products is now as easy as Product.addProductToProductsSelectedForPurchase() or Product.removeProductFromProductsForPurchase()

4-15-18 14:40 CST: (Chad) changed price values in populateProductList to match class changes for the sub product classes.

4-15-18 14:31 CST: (Chad) Changed the product sub class constructor of drink, candy, chips, and gum to accept double values for price and then converted them to int before calling super constructor to make product additions more user friendly. Snack and product we left alone and still function on int for more percision
