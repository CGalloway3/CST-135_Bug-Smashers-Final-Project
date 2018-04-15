For internal use only!!

4-15-18 17:07 CST: (Richard) Changed loop that creates cart and receipt pop ups to operate in the same way the grid buttons populate

4-15-18 16:42 CST: (Richard) updated build to work as Eclipse Javafx project (not sure if will cause problems in netbeans)

4-15-18 16:15 CST: (Chad) Continue cleaning and commenting code.

4-15-18 15:53 CST: (Chad) Converted all toString mothods to use String.format to eliminate values like "$1.0". Now all monitary values are represented properly in teo decimal places.

4-15-18 15:33 CST: (Chad) Reduced the lines of code in the populateItemGrid method by turning all item buttons into an array of buttons. Each button no longer has to be set seperately they can be set enmass.

4-15-18 14:49 CST: (Chad) Removed the cart ArrayList in favor of the IPurchasableProduct static ArrayList PRODUCTS_SELECTEDFORPURCHASE. Adding and removing products is now as easy as Product.addProductToProductsSelectedForPurchase() or Product.removeProductFromProductsForPurchase()

4-15-18 14:40 CST: (Chad) changed price values in populateProductList to match class changes for the sub product classes.

4-15-18 14:31 CST: (Chad) Changed the product sub class constructor of drink, candy, chips, and gum to accept double values for price and then converted them to int before calling super constructor to make product additions more user friendly. Snack and product we left alone and still function on int for more percision
