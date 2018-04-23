//CST-135 group assignment for Topic 4, a collaboration of Richard Boyd, Chad Galloway, and Dennis Witt
/**  Program: Vending Machine
*    File: Dispenser.java
*    Summary: Vending Machine GUI elements.
*    Author: Chad Galloway
*    Date: April 9th, 2018
**/

package vendingmachine;


import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class Dispenser extends Application {
    
    private final InventoryManager inventoryManager = new InventoryManager();
    private Boolean adminMode = false;  // adminMode flag
    private String itemGridCategory;
    private int itemGridPageNumber = 1;
    private int moneyInserted = 0;
    private int productsCost = 0;
    
    // GUI node declarations
    private final StackPane customerPane = new StackPane();
    private final BorderPane customerBorder = new BorderPane();
    private final HBox largeCoinSlot = new HBox();
    private final HBox smallCoinSlot = new HBox();
    private final VBox moneySlot = new VBox();
    private final VBox customerControls = new VBox();
    private final GridPane categoryGrid = new GridPane();
    private final GridPane itemGrid = new GridPane();
    private final Button btnSplashButton = new Button(" Welcome to Speedy Vend 5000.\n\n        Click to begin shopping.");
    private final Label lblBills = new Label("Bills");
    private final Button btnBackToCategories = new Button("<< Back");
    private final Button btnAddTwentyDollars = new Button("Twenty Dollars");
    private final Button btnAddTenDollars = new Button("Ten Dollars");
    private final Button btnAddFiveDollars = new Button("Five Dollars");
    private final Button btnAddOneDollar = new Button("One Dollar");
    private final Label lblCoins = new Label("Coins");
    private final Button btnAddOneDollarCoin = new Button("$1.00");
    private final Button btnAddFiftyCentCoin = new Button("$.50");
    private final Button btnAddQuater = new Button("$.25");
    private final Button btnAddDime = new Button("$.10");
    private final Button btnAddNickle = new Button("$.05");
    private final Label lblLeftBlank = new Label("  ");
    private final Label lblRightBlank = new Label("  ");
    private final Button btnNextPage = new Button("Next");
    private final Button btnPreviousPage = new Button("Previous");
    private final Button btnDrinkCategory = new Button("Drinks");
    private final Image imgDrinkCategory = new Image(getClass().getResourceAsStream("images/drinkCategory.png"));
    private final ImageView viewDrinkCategory = new ImageView(imgDrinkCategory);
    private final Button btnChipsCategory = new Button("Chips");
    private final Image imgChipsCategory = new Image(getClass().getResourceAsStream("images/chipsCategory.png"));
    private final ImageView viewChipsCategory = new ImageView(imgChipsCategory);
    private final Button btnCandyCategory = new Button("Candy");
    private final Image imgCandyCategory = new Image(getClass().getResourceAsStream("images/candyCategory.png"));
    private final ImageView viewCandyCategory = new ImageView(imgCandyCategory);
    private final Button btnGumCategory = new Button("Gum");
    private final Image imgGumCategory = new Image(getClass().getResourceAsStream("images/gumCategory.png"));
    private final ImageView viewGumCategory = new ImageView(imgGumCategory);
    private final Image imgCart = new Image(getClass().getResourceAsStream("images/cart.png"));
    private final ImageView viewCart = new ImageView(imgCart);
    private final Button btnItems[] = new Button[9];
    private final Label lblFunds = new Label("Funds:");
    private final Text txtFundsAmount = new Text("$0.00");
    private final Text txtReceiptFunds = new Text("$0.00");
    private final Label lblCost = new Label("Cost:");
    private final Text txtReceiptCost = new Text("$0.00");
    private final Text txtCostAmount = new Text("$0.00");
    private final Button btnReturnMoney = new Button("Coin Return");
    private final Button btnCompletePurchase = new Button("Complete Purchase");
    private final Button btnMyItems = new Button ("My Items");
    private final Button btnExit = new Button("Exit");
    private final Stage customerStage = new Stage();
    private final Stage adminStage = new Stage();

    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("Speedy Vend 5000");
        primaryStage.setScene(new Scene(btnSplashButton, 710, 500));
        primaryStage.show();
        btnSplashButton.requestFocus();      

        // Catch key press ctrl-a and set admin mode flag to true
        btnSplashButton.setOnKeyPressed((event) -> {
            if ( event.isControlDown() && event.getText().equalsIgnoreCase("a") ) {
                adminMode = true;
            }
            
        });
        
        // Catch button action and enter customer mode or admin mode. reset admin flag to false
        btnSplashButton.setOnAction((ActionEvent event) -> {
        	productsCost = 0;
    		moneyInserted = 0;
    		updateFunds();
    		updateCost();
    		btnExit.setText("Exit");
    		inventoryManager.returnItemsSelectedForPurchase();
        	if (adminMode) {
                adminMode = false;
                primaryStage.hide();
                adminStage.show();
            }
            else {
                primaryStage.hide();
                customerStage.show();
            }
        });
        
        // Set VBox and HBox spacing and padding.
        largeCoinSlot.setSpacing(8);
        smallCoinSlot.setSpacing(2);
        moneySlot.setSpacing(10);
        moneySlot.setPadding(new Insets(10));
        customerControls.setSpacing(8);
        customerControls.setPadding(new Insets(10));

        // Set Grid gaps
        categoryGrid.setVgap(10);
        categoryGrid.setHgap(10);
        itemGrid.setHgap(10);
        itemGrid.setVgap(10);
        
        // Set button sizes, states, and events
        for (int i = 0; i < 9; i++) {
            btnItems[i] = new Button();
            btnItems[i].setPrefSize(140, 140);
            btnItems[i].setDisable(true);
        }

        btnNextPage.prefWidthProperty().bind(btnItems[8].widthProperty());
        btnNextPage.setDisable(true);
        btnNextPage.setOnAction((event) -> {
            itemGridPageNumber++;
            if (populateItemGrid()) {
                btnNextPage.setDisable(false);
            }
            else {
                btnNextPage.setDisable(true);
            }
            
            btnPreviousPage.setDisable(false);
        });
        
        btnPreviousPage.prefWidthProperty().bind(btnItems[6].widthProperty());
        btnPreviousPage.setDisable(true);
        btnPreviousPage.setOnAction((event) -> {
            itemGridPageNumber--;
            if (populateItemGrid()) {
                btnNextPage.setDisable(false);
            }
            else {
                btnNextPage.setDisable(true);
            }
            
            if (itemGridPageNumber == 1) {
                btnPreviousPage.setDisable(true);
            }
        });
        
        btnBackToCategories.setTranslateY(-225);
        btnBackToCategories.setTranslateX(-260);
        btnBackToCategories.setVisible(false);
        btnBackToCategories.setOnAction((event) -> {
            itemGridPageNumber = 1;
            btnNextPage.setDisable(true);
            btnPreviousPage.setDisable(true);
            btnBackToCategories.setVisible(false);
            customerBorder.setCenter(categoryGrid);
        });
        btnDrinkCategory.setPrefSize(200, 200);
        viewDrinkCategory.setFitHeight(100);
        viewDrinkCategory.setFitWidth(100);
        btnDrinkCategory.setContentDisplay(ContentDisplay.TOP);
        btnDrinkCategory.setGraphic(viewDrinkCategory);
        btnDrinkCategory.setOnAction((event) -> {
            itemGridCategory = "Drink";
            if (populateItemGrid()) {
                btnNextPage.setDisable(false);
            }
            else {
                btnNextPage.setDisable(true);
            }
        });
        
        btnChipsCategory.setPrefSize(200, 200);
        viewChipsCategory.setFitHeight(100);
        viewChipsCategory.setFitWidth(100);
        btnChipsCategory.setContentDisplay(ContentDisplay.TOP);
        btnChipsCategory.setGraphic(viewChipsCategory);
        btnChipsCategory.setOnAction((event) -> {
            itemGridCategory = "Chips";
            if (populateItemGrid()) {
                btnNextPage.setDisable(false);
            }
        });
        
        btnCandyCategory.setPrefSize(200, 200);
        viewCandyCategory.setFitHeight(100);
        viewCandyCategory.setFitWidth(100);
        btnCandyCategory.setContentDisplay(ContentDisplay.TOP);
        btnCandyCategory.setGraphic(viewCandyCategory);
        btnCandyCategory.setOnAction((event) -> {
            itemGridCategory = "Candy";
            if (populateItemGrid()) {
                btnNextPage.setDisable(false);
            }
        });
        
        btnGumCategory.setPrefSize(200, 200);
        viewGumCategory.setFitHeight(100);
        viewGumCategory.setFitWidth(100);
        btnGumCategory.setContentDisplay(ContentDisplay.TOP);
        btnGumCategory.setGraphic(viewGumCategory);
        btnGumCategory.setOnAction((event) -> {
            itemGridCategory = "Gum";
            if (populateItemGrid()) {
                btnNextPage.setDisable(false);
            }
        });
                
        btnAddDime.setOnAction((event) -> {
            moneyInserted += 10;
            updateFunds();
        });
        
        btnAddFiftyCentCoin.setOnAction((event) -> {
            moneyInserted += 50;
            updateFunds();
        });
        
        btnAddFiveDollars.setOnAction((event) -> {
            moneyInserted += 500;
            updateFunds();
        });
        
        btnAddNickle.setOnAction((event) -> {
            moneyInserted += 5;
            updateFunds();
        });
        
        btnAddOneDollar.setOnAction((event) -> {
            moneyInserted += 100;
            updateFunds();
            
        });
        
        btnAddOneDollarCoin.setOnAction((event) -> {
            moneyInserted += 100;
            updateFunds();
        });
        
        btnAddQuater.setOnAction((event) -> {
            moneyInserted += 25;
            updateFunds();
        });
        
        btnAddTenDollars.setOnAction((event) -> {
            moneyInserted += 1000;
            updateFunds();
        });
        
        btnAddTwentyDollars.setOnAction((event) -> {
            moneyInserted += 2000;
            updateFunds();
        });
        
        btnReturnMoney.setOnAction((event) -> {   //returns funds to 0 when "coin return" is clicked
        	moneyInserted = 0;
        	updateFunds();
        });
        
        
        
        btnAddOneDollar.prefWidthProperty().bind(smallCoinSlot.widthProperty());
        btnAddFiveDollars.prefWidthProperty().bind(smallCoinSlot.widthProperty());
        btnAddTenDollars.prefWidthProperty().bind(smallCoinSlot.widthProperty());
        btnAddTwentyDollars.prefWidthProperty().bind(smallCoinSlot.widthProperty());

        btnMyItems.prefWidthProperty().bind(btnCompletePurchase.widthProperty());
        btnMyItems.setContentDisplay(ContentDisplay.TOP);
        btnMyItems.setGraphic(viewCart);
        btnMyItems.setOnAction((Event) -> {
            drawItemsList();
        });
        btnReturnMoney.prefWidthProperty().bind(btnCompletePurchase.widthProperty());
        btnExit.prefWidthProperty().bind(btnCompletePurchase.widthProperty());
        btnExit.setOnAction((event) -> {
            inventoryManager.returnItemsSelectedForPurchase();
            itemGridPageNumber = 1;
            btnBackToCategories.setVisible(false);
            btnNextPage.setDisable(true);
            btnPreviousPage.setDisable(true);
            customerStage.hide();
            customerBorder.setCenter(categoryGrid);
            primaryStage.show();
        });
        

        // Build left section of border pane with coin and money slots
        largeCoinSlot.getChildren().addAll(btnAddOneDollarCoin, btnAddFiftyCentCoin);
        largeCoinSlot.setAlignment(Pos.CENTER);
        smallCoinSlot.getChildren().addAll(btnAddQuater, btnAddDime, btnAddNickle);
        smallCoinSlot.setAlignment(Pos.CENTER);
        moneySlot.getChildren().addAll(lblCoins, largeCoinSlot, smallCoinSlot, lblLeftBlank, lblBills, btnAddOneDollar, btnAddFiveDollars, btnAddTenDollars, btnAddTwentyDollars);
        moneySlot.setAlignment(Pos.CENTER);
        customerBorder.setLeft(moneySlot);
       
        // Build Right section of border pane with customer controls
        lblFunds.setMinHeight(20);
        txtFundsAmount.setFont(Font.font("courier", FontWeight.BOLD, FontPosture.REGULAR, 20));
        txtFundsAmount.setFill(Paint.valueOf("Black"));
        txtFundsAmount.setStroke(Paint.valueOf("Green"));
        txtReceiptFunds.setFont(Font.font("courier", FontWeight.BOLD, FontPosture.REGULAR, 20));
        txtReceiptFunds.setFill(Paint.valueOf("Black"));
        txtReceiptFunds.setStroke(Paint.valueOf("Green"));
        lblCost.setMinHeight(20);
        txtCostAmount.setFont(Font.font("courier", FontWeight.BOLD, FontPosture.REGULAR, 20));
        txtCostAmount.setFill(Paint.valueOf("Black"));
        txtCostAmount.setStroke(Paint.valueOf("Red"));
        txtReceiptCost.setFont(Font.font("courier", FontWeight.BOLD, FontPosture.REGULAR, 20));
        txtReceiptCost.setFill(Paint.valueOf("Black"));
        txtReceiptCost.setStroke(Paint.valueOf("Red"));
        
        customerControls.getChildren().addAll(lblFunds, txtFundsAmount, lblCost, txtCostAmount, lblRightBlank, btnCompletePurchase, btnMyItems, btnReturnMoney, btnExit);
        customerControls.setAlignment(Pos.BOTTOM_CENTER);
        customerBorder.setRight(customerControls);
        
        // Build category center section for border pane
        categoryGrid.addRow(0, btnDrinkCategory, btnChipsCategory);
        categoryGrid.addRow(1, btnCandyCategory, btnGumCategory);
        categoryGrid.setAlignment(Pos.CENTER);
        customerBorder.setCenter(categoryGrid);
        
        // build item center section for border pane
        itemGrid.addRow(0, btnItems[0], btnItems[1], btnItems[2]);
        itemGrid.addRow(1, btnItems[3], btnItems[4], btnItems[5]);
        itemGrid.addRow(2, btnItems[6], btnItems[7], btnItems[8]);
        itemGrid.add(btnNextPage, 2, 3);
        itemGrid.add(btnPreviousPage, 0, 3);
        itemGrid.setAlignment(Pos.CENTER);
        
        // Add border to pane
        customerPane.getChildren().add(customerBorder);
        customerPane.getChildren().add(btnBackToCategories);
        
        // Set the customer scene
        customerStage.setTitle("Speedy Vend 5000");  
        customerStage.setScene(new Scene(customerPane, 710, 500));

                // Admin page not fully implemented. Code below is just filler code
                Button btnAdmin = new Button("Admin Stage");
                adminStage.setTitle("Admin Stage");
                adminStage.setScene(new Scene(btnAdmin, 300, 300));
                btnAdmin.setOnAction((ActionEvent event) -> {
                    adminStage.hide();
                    primaryStage.show();
                });
                adminStage.setOnShowing((event) -> {
                    System.out.println("password accepted");

                });
                // End Admin code section
        
        btnCompletePurchase.setOnAction((Event) -> {
            
            final Stage receiptStage = new Stage();
            receiptStage.initModality(Modality.APPLICATION_MODAL);
            
            VBox receiptVBox = new VBox(5);
            receiptVBox.setPadding(new Insets(10));
            
            if (inventoryManager.getItemsSelectedForPurchase().isEmpty()) {
                receiptVBox.getChildren().add(new Text("Your have not selected anything to buy."));
            }
            
            else if (moneyInserted < productsCost) {
                receiptVBox.getChildren().add(new Text("Insufficient Funds"));
                receiptVBox.getChildren().add(new Text("Please insert cash before continuing"));
            }
            
            else {
                for (InventoryManager.InventoryItem i : inventoryManager.getItemsSelectedForPurchase()) {
                    Button btnReceiptItem = new Button(i.getProduct().toString());
                    receiptVBox.getChildren().add(btnReceiptItem); 
                    btnReceiptItem.prefWidthProperty().bind(receiptVBox.widthProperty());
                }
                inventoryManager.completePurchase();
                receiptVBox.getChildren().add(new Text("Total: "));
                receiptVBox.getChildren().add(txtReceiptCost);
                moneyInserted = moneyInserted - productsCost;
                updateFunds();
                receiptVBox.getChildren().add(new Text("Thank you for shopping with us!"));
                if (moneyInserted != 0) {
                       receiptVBox.getChildren().add(new Text("Change dispensed:"));
                    receiptVBox.getChildren().add(txtReceiptFunds);
                }        		
                itemGridPageNumber = 1;
                btnBackToCategories.setVisible(false);
                btnNextPage.setDisable(true);
                btnPreviousPage.setDisable(true);
                customerStage.hide();
                primaryStage.show();
                customerBorder.setCenter(categoryGrid);
            }
        
            Button btnSeperator = new Button();
            btnSeperator.setVisible(false);
            receiptVBox.getChildren().add(btnSeperator);
        
            Button btnClose = new Button("Close");
            btnClose.prefWidthProperty().bind(receiptVBox.widthProperty());
            btnClose.setOnAction((event) -> {
                receiptStage.close();
            });
            receiptVBox.getChildren().add(btnClose);

            Scene receiptScene = new Scene(receiptVBox);
            receiptStage.setScene(receiptScene);
            receiptStage.show();
        });
    }

    
    public static void main(String[] args) {
        launch(args);
    }

    //pop-up window for "my items" button
    private void drawItemsList() {
    
        final Stage cartStage = new Stage();
        cartStage.initModality(Modality.APPLICATION_MODAL);
        VBox cartVBox = new VBox(5);
        cartVBox.setPadding(new Insets(10));
        if (inventoryManager.getItemsSelectedForPurchase().isEmpty()) {
                cartVBox.getChildren().add(new Text("Your cart is empty"));
        }
        else {
                // Added functionallity for dynamically added and removed buttons.
                cartVBox.getChildren().add(new Text("Click on an item to remove it"));
                for (InventoryManager.InventoryItem i : inventoryManager.getItemsSelectedForPurchase()) {
                    Button btnCartItem = new Button(i.getProduct().toString());
                    btnCartItem.prefWidthProperty().bind(cartVBox.widthProperty());
                    btnCartItem.setContentDisplay(ContentDisplay.TOP);                                     
                    cartVBox.getChildren().add(btnCartItem);
                    btnCartItem.setOnAction((event) -> {
                        cartVBox.getChildren().remove(btnCartItem);
                        inventoryManager.removeItemFromProductsSelectedForPurchase(i);
                        productsCost -= i.getProduct().getPrice();
                        updateCost();
                        populateItemGrid();
                        cartStage.hide();
                        drawItemsList();
                    });
                }
        }
        
        Button btnSeperator = new Button();
        btnSeperator.setVisible(false);
        cartVBox.getChildren().add(btnSeperator);
        
        Button btnClose = new Button("Close");
        btnClose.prefWidthProperty().bind(cartVBox.widthProperty());
        btnClose.setOnAction((event) -> {
            cartStage.close();
        });
        cartVBox.getChildren().add(btnClose);
        
        
        Scene cartScene = new Scene(cartVBox);
        cartStage.setScene(cartScene);
        cartStage.show();        

    }
    
    private Boolean populateItemGrid() {
        
        // Internal usage variables
        Boolean morePages = false; // return value flag;
        int indexOfButtonLocationOnTheGrid; // index of the curent button undergoing property modifications.

        // Reset all buttons on item grid back to blank disabled buttons.
        for (int i = 0; i < 9; i++) {
            btnItems[i].setText("");
            btnItems[i].setDisable(true);
            btnItems[i].setGraphic(new ImageView(new Image(getClass().getResourceAsStream("images/empty.png"), 90, 90, true, true)));
        }
                
        // Turn on the Back button on the item grid display.
        btnBackToCategories.setVisible(true);
        
        // iterate through all products
        for (InventoryManager.InventoryItem i : inventoryManager.getMasterInventoryList()) {
            // If the product is in the correct category and in the correct slot to be displayed on this screen.
            if (i.getProduct().getClass().getSimpleName().equalsIgnoreCase(itemGridCategory) && i.getLocation().startsWith((String.valueOf((char)(64+itemGridPageNumber))))) {

                // Parse the button index to modify from the Location property of a product
                indexOfButtonLocationOnTheGrid = Integer.parseInt(String.valueOf(i.getLocation().charAt(1))) - 1; // subtract 1 because button location 1 is index 0.
                
                // Modify the item button properties.
                btnItems[indexOfButtonLocationOnTheGrid].setDisable(false);
                btnItems[indexOfButtonLocationOnTheGrid].setContentDisplay(ContentDisplay.TOP);
                
                // Build button icon
                StackPane imageStack = new StackPane();
                BorderPane imageBorder = new BorderPane();
                Text nameText = new Text(i.getName());
                Text priceText = new Text(String.format("$" + i.getPrice() / 100 + ".%02d", i.getPrice() % 100));
                
                BorderPane.setAlignment(nameText, Pos.TOP_CENTER);
                BorderPane.setAlignment(priceText, Pos.BOTTOM_CENTER);

                imageBorder.setTop(nameText);
                imageBorder.setBottom(priceText);
                        

                try {
                    imageStack.getChildren().add(new ImageView(new Image(getClass().getResourceAsStream("images/" + i.getInventoryItemType() + "/" + i.getName() + ".png"), 90, 90, true, true)));
                }
                catch (Exception error) {
                    imageStack.getChildren().add(new ImageView(new Image(getClass().getResourceAsStream("images/noImage.png"), 90, 90, true, true)));
                }
                imageStack.getChildren().add(imageBorder);
                btnItems[indexOfButtonLocationOnTheGrid].setGraphic(imageStack);
                
                // Adds an item to the produdct selected for purchase list when user clicks button and updates the cost display with its' price.
                btnItems[indexOfButtonLocationOnTheGrid].setOnAction((event) -> {  
                    
                	final Stage animation = new Stage();
                	animation.initStyle(StageStyle.TRANSPARENT);
                	Pane canvas = new Pane();
                	Scene scene = new Scene(canvas, 710, 500);
                	scene.setFill(Color.TRANSPARENT);
                	ImageView moveItem = new ImageView(new Image(getClass().getResourceAsStream("images/" + i.getInventoryItemType() + "/" + i.getName() + ".png"), 90, 90, true, true));
                    canvas.getChildren().add(moveItem);
                    
                    animation.setScene(scene);
                    animation.show();
                    
                	TranslateTransition tt = new TranslateTransition(Duration.seconds(2.0), (Node)(moveItem));
                    tt.setToX(200);
                    tt.setToY(100);
                    
                    tt.play();
                    tt.setOnFinished((e) -> {
                        tt.jumpTo(Duration.ZERO);
                        animation.hide();
                    });
                    
                    inventoryManager.addItemToProductsSelectedForPurchase(i);
                    productsCost += i.getPrice();  
                    updateCost();

                    populateItemGrid();
                    if (inventoryManager.getItemsSelectedForPurchase().size() > 0) {
                    	btnExit.setText("Cancel Order");
                    }

                });
                
                if (i.getQuantity() < 1) {
                    btnItems[indexOfButtonLocationOnTheGrid].setOnAction((event) -> {  
                    
                    });
                    
                    btnItems[indexOfButtonLocationOnTheGrid].setDisable(false);
                    imageStack = new StackPane();
                    try {
                        imageStack.getChildren().addAll(new ImageView(new Image(getClass().getResourceAsStream("images/" + i.getInventoryItemType() + "/" + i.getName() + ".png"), 90, 90, true, true)), new ImageView(new Image(getClass().getResourceAsStream("images/OutOfStock.png"), 90, 90, true, true)));
                    }
                    catch (Exception error) {
                        imageStack.getChildren().add(new ImageView(new Image(getClass().getResourceAsStream("images/OutOfStock.png"), 90, 90, true, true)));
                    }
                    btnItems[indexOfButtonLocationOnTheGrid].setGraphic(imageStack);
                }
            }

            // Check to see if more pages of products in this category exist.
            if (i.getInventoryItemType().equalsIgnoreCase(itemGridCategory) && i.getLocation().startsWith((String.valueOf((char)(65+itemGridPageNumber))))) {
                morePages = true;
            }
        }

        // Display the finished item grid
        customerBorder.setCenter(itemGrid);
        return morePages;
    }

    private void updateFunds() {
        String text = String.format("$" + moneyInserted / 100 + ".%02d", moneyInserted % 100);
        txtFundsAmount.setText(text);
        txtReceiptFunds.setText(text);
    }
    
    private void updateCost() {
    	String text = String.format("$" + productsCost / 100 + ".%02d", productsCost % 100);
        txtCostAmount.setText(text);
        txtReceiptCost.setText(text);
    }

 }
