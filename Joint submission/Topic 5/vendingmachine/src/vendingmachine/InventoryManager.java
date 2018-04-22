package vendingmachine;

import java.util.ArrayList;
import vendingmachine.products.Product;

public class InventoryManager {

    private final ArrayList<Product> productList = new ArrayList<>();
    private final ArrayList<Product> productsSelectedForPurchase = new ArrayList<>();

    public InventoryManager(){
    }

    void clearProductsSelectedForPurchase() {
        this.productsSelectedForPurchase.clear();
    }

    ArrayList<Product> getProductsSelectedForPurchase() {
        return this.productsSelectedForPurchase;
    }

    ArrayList<Product> getMasterProductList() {
        return this.productList;
    }

    void addProductToProductsSelectedForPurchase(Product p) {
        this.productsSelectedForPurchase.add(p);
    }
	
    void removeProductFromProductsSelectedForPurchase(Product p) {
        this.productsSelectedForPurchase.remove(p);
    }

}
