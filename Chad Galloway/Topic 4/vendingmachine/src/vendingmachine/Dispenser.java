//CST-135 group assignment for Topic 2, a collaboration of Richard Boyd, Chad Galloway, and Dennis Witt
/**  Program: Vending Machine
*    File: Dispenser.java
*    Summary: Vending Machine GUI elements.
*    Author: Chad Galloway
*    Date: April 9th, 2018
**/

package vendingmachine;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Dispenser extends Application {
    
    private final ArrayList<Product> productList = new ArrayList<>();
    private Boolean adminMode = false;  // adminMode flag
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
    private final Label lblBills = new Label("Bills");
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
    private final Button btnItem1 = new Button();
    private final Button btnItem2 = new Button();
    private final Button btnItem3 = new Button();
    private final Button btnItem4 = new Button();
    private final Button btnItem5 = new Button();
    private final Button btnItem6 = new Button();
    private final Button btnItem7 = new Button();
    private final Button btnItem8 = new Button();
    private final Button btnItem9 = new Button();
    private final Label lblFunds = new Label("Funds:");
    private final Text txtFundsAmount = new Text("$0.00");
    private final Label lblCost = new Label("Cost:");
    private final Text txtCostAmount = new Text("$0.00");
    private final Button btnReturnMoney = new Button("Coin Return");
    private final Button btnCompletePurchase = new Button("Complete Purchase");
    private final Button btnMyItems = new Button ("My Items");
    private final Button btnFinished = new Button("Finished");
    private final Stage customerStage = new Stage();
    
    @Override
    public void start(Stage primaryStage) {
        
        populateProductList();
        
        // Set VBox and HBox spacing and padding.
        largeCoinSlot.setSpacing(8);
        smallCoinSlot.setSpacing(2);
        moneySlot.setSpacing(10);
        moneySlot.setPadding(new Insets(5));
        customerControls.setSpacing(8);
        customerControls.setPadding(new Insets(5));

        // Set Grid gaps
        categoryGrid.setVgap(10);
        categoryGrid.setHgap(10);
        itemGrid.setHgap(10);
        itemGrid.setVgap(10);
        
        // Set button sizes, states, and events
        btnNextPage.setPrefSize(70, 10);
        btnNextPage.setDisable(true);
        btnPreviousPage.setPrefSize(70, 10);
        btnPreviousPage.setDisable(true);
        
        btnDrinkCategory.setPrefSize(100, 100);
        viewDrinkCategory.setFitHeight(100);
        viewDrinkCategory.setFitWidth(100);
        btnDrinkCategory.setContentDisplay(ContentDisplay.TOP);
        btnDrinkCategory.setGraphic(viewDrinkCategory);
        btnDrinkCategory.setOnAction((event) -> {
            populateItemGrid(1,1);
        });
        
        btnChipsCategory.setPrefSize(100, 100);
        viewChipsCategory.setFitHeight(100);
        viewChipsCategory.setFitWidth(100);
        btnChipsCategory.setContentDisplay(ContentDisplay.TOP);
        btnChipsCategory.setGraphic(viewChipsCategory);
        btnChipsCategory.setOnAction((event) -> {
            populateItemGrid(2,1);
        });
        
        btnCandyCategory.setPrefSize(100, 100);
        viewCandyCategory.setFitHeight(100);
        viewCandyCategory.setFitWidth(100);
        btnCandyCategory.setContentDisplay(ContentDisplay.TOP);
        btnCandyCategory.setGraphic(viewCandyCategory);
        btnCandyCategory.setOnAction((event) -> {
            populateItemGrid(3,1);
        });
        
        btnGumCategory.setPrefSize(100, 100);
        viewGumCategory.setFitHeight(100);
        viewGumCategory.setFitWidth(100);
        btnGumCategory.setContentDisplay(ContentDisplay.TOP);
        btnGumCategory.setGraphic(viewGumCategory);
        btnGumCategory.setOnAction((event) -> {
            populateItemGrid(4,1);
        });
        
        btnItem1.setPrefSize(70, 70);
        btnItem1.setDisable(true);
        btnItem2.setPrefSize(70, 70);
        btnItem2.setDisable(true);
        btnItem3.setPrefSize(70, 70);
        btnItem3.setDisable(true);
        btnItem4.setPrefSize(70, 70);
        btnItem4.setDisable(true);
        btnItem5.setPrefSize(70, 70);
        btnItem5.setDisable(true);
        btnItem6.setPrefSize(70, 70);
        btnItem6.setDisable(true);
        btnItem7.setPrefSize(70, 70);
        btnItem7.setDisable(true);
        btnItem8.setPrefSize(70, 70);
        btnItem8.setDisable(true);
        btnItem9.setPrefSize(70, 70);
        btnItem9.setDisable(true);
        
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
        
        btnAddOneDollar.prefWidthProperty().bind(smallCoinSlot.widthProperty());
        btnAddFiveDollars.prefWidthProperty().bind(smallCoinSlot.widthProperty());
        btnAddTenDollars.prefWidthProperty().bind(smallCoinSlot.widthProperty());
        btnAddTwentyDollars.prefWidthProperty().bind(smallCoinSlot.widthProperty());
        
        btnMyItems.prefWidthProperty().bind(btnCompletePurchase.widthProperty());
        btnReturnMoney.prefWidthProperty().bind(btnCompletePurchase.widthProperty());
        btnFinished.prefWidthProperty().bind(btnCompletePurchase.widthProperty());
        btnFinished.setOnAction((event) -> {
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
        lblCost.setMinHeight(20);
        txtCostAmount.setFont(Font.font("courier", FontWeight.BOLD, FontPosture.REGULAR, 20));
        txtCostAmount.setFill(Paint.valueOf("Black"));
        txtCostAmount.setStroke(Paint.valueOf("Red"));
        
        customerControls.getChildren().addAll(lblFunds, txtFundsAmount, lblCost, txtCostAmount, lblRightBlank, btnCompletePurchase, btnMyItems, btnReturnMoney, btnFinished);
        customerControls.setAlignment(Pos.BOTTOM_CENTER);
        customerBorder.setRight(customerControls);
        
        // Build category center section for border pane
        categoryGrid.addRow(0, btnDrinkCategory, btnChipsCategory);
        categoryGrid.addRow(1, btnCandyCategory, btnGumCategory);
        categoryGrid.setAlignment(Pos.CENTER);
        customerBorder.setCenter(categoryGrid);
        
        // build item center section for border pane
        itemGrid.addRow(0, btnItem1, btnItem2, btnItem3);
        itemGrid.addRow(1, btnItem4, btnItem5, btnItem6);
        itemGrid.addRow(2, btnItem7, btnItem8, btnItem9);
        itemGrid.add(btnNextPage, 2, 3);
        itemGrid.add(btnPreviousPage, 0, 3);
        itemGrid.setAlignment(Pos.CENTER);
        
        // Add border to pane
        customerPane.getChildren().add(customerBorder);
        
        // Set the scene
        customerStage.setTitle("Speedy Vend 5000");
        customerStage.setScene(new Scene(customerPane, 550, 300));

                // Admin page not fully implemented. Code below is just filler code
                Button btnAdmin = new Button("Admin Stage");
                Stage adminStage = new Stage();
                adminStage.setTitle("Admin Stage");
                adminStage.setScene(new Scene(btnAdmin, 100, 100));
                btnAdmin.setOnAction((ActionEvent event) -> {
                    adminStage.hide();
                    primaryStage.show();
                });
                adminStage.setOnShowing((event) -> {
                    System.out.println("password accepted");

                });
                // End Admin code section
        
        // Create Button and set text
        Button btn = new Button();
        btn.setText(" Welcome to Speedy Vend 5000.\n\n        Click to begin shopping.");
        
        // Catch key press ctrl-a and set admin mode flag to true
        btn.setOnKeyPressed((event) -> {
            if ( event.isControlDown() && event.getText().equalsIgnoreCase("a") ) {
                System.out.println("enter Admin mode");
                adminMode = true;
            }
            
        });
        
        // Catch button action and enter customer mode or admin mode. reset admin flag to false
        btn.setOnAction((ActionEvent event) -> {
            if (adminMode) {
                System.out.println("Hello admin");
                adminMode = false;
                primaryStage.hide();
                adminStage.show();
            }
            else {
                System.out.println("Hello customer");
                primaryStage.hide();
                customerStage.show();
            }
        });
        
        primaryStage.setTitle("Speedy Vend 5000");
        primaryStage.setScene(new Scene(btn, 300, 250));
        primaryStage.show();
        btn.requestFocus();      

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     *  @param category product category 1=drink 2=chips 3=candy 4=gum 
     *  @param page page number to display 1=first page 2=second...
     */
    private Boolean populateItemGrid(int category, int page) {
        
        switch (category){
            case 1:
                for (Product p : productList) {
                    //System.out.println(String.valueOf((char)(64+page)));
                    //System.out.println(p.getClass().getSimpleName());
                    if (p.getClass().getSimpleName().equalsIgnoreCase("Drink") && p.getLocation().startsWith((String.valueOf((char)(64+page)))))
                    {
                        //System.out.println("vendingmachine.Dispenser.populateItemGrid()");
                        //System.out.println(String.valueOf(p.getLocation().charAt(1)));
                        switch (String.valueOf(p.getLocation().charAt(1))) {
                            case "1":
                                btnItem1.setDisable(false);
                                btnItem1.setText(p.getName());
                            case "2":
                                btnItem2.setDisable(false);
                                btnItem2.setText(p.getName());
                            case "3":
                                btnItem3.setDisable(false);
                                btnItem3.setText(p.getName());
                            case "4":
                                btnItem4.setDisable(false);
                                btnItem4.setText(p.getName());
                            case "5":
                                btnItem5.setDisable(false);
                                btnItem5.setText(p.getName());
                            case "6":
                                btnItem6.setDisable(false);
                                btnItem6.setText(p.getName());
                            case "7":
                                btnItem7.setDisable(false);
                                btnItem7.setText(p.getName());
                            case "8":
                                btnItem8.setDisable(false);
                                btnItem8.setText(p.getName());
                            case "9":
                                btnItem9.setDisable(false);
                                btnItem9.setText(p.getName());
                        }
                    }
                    
                }
        }
        customerBorder.setCenter(itemGrid);
    }

    private void updateFunds() {
        String text = String.format("$" + moneyInserted / 100 + ".%02d", moneyInserted % 100);
        txtFundsAmount.setText(text);
    }

    private void populateProductList() {
        
        // Add some Drinks
        productList.add(new Drink("Pepsi", "A1", 10, 1.25));
        productList.add(new Drink("Diet Pepsi", "A2", 10, 1.25));
        productList.add(new Drink("Cherry Pepsi", "A3", 10, 1.25));
        productList.add(new Drink("Coke", "A4", 10, 1.25));
        productList.add(new Drink("Diet Coke", "A5", 1, 1.25));
        productList.add(new Drink("Cherry Coke", "A6", 10, 1.25));
        productList.add(new Drink("Dr.Pepper", "A7", 10, 1.25));
        productList.add(new Drink("Diet Dr.Pepper", "A8", 10, 1.25));
        productList.add(new Drink("Vanillia Dr.Pepper", "A9", 10, 1.25));
        productList.add(new Drink("Fanta Orange", "B1", 10, 1.25));
        productList.add(new Drink("Fanta Grape", "B2", 0, 1.25));
        productList.add(new Drink("Fanta Strawberry", "B3", 10, 1.25));
        productList.add(new Drink("Mug Root Beer", "B4", 10, 1.25));
        productList.add(new Drink("Mug Cream Soda", "B5", 10, 1.25));
        productList.add(new Drink("Sprite", "B6", 10, 1.25));
        productList.add(new Drink("7-Up", "B7", 10, 1.25));
        productList.add(new Drink("Sierra Mist", "B8", 10, 1.25));
        
        // Add some candy
        productList.add(new Candy("M&M", "A1", 10, 1.25));
        productList.add(new Candy("Kit Kat", "A2", 10, 1.25));
        productList.add(new Candy("Reses Pieces", "A4", 10, 1.25));
        productList.add(new Candy("Baby Ruth", "A5", 10, 1.25));
        productList.add(new Candy("Snickers", "A6", 10, 1.25));
        
        // Add some chips
        productList.add(new Chips("Ruffles", "A1", 1, 1.25));
        productList.add(new Chips("Cheetoes", "A2", 10, 1.25));
        productList.add(new Chips("Doritoes", "A3", 10, 1.25));
        productList.add(new Chips("Hot Fries", "A5", 10, 1.25));
        productList.add(new Chips("Lays", "B2", 10, 1.25));
        
        // Add some gum
        productList.add(new Gum("Orbits", "A1", 10, 1.25));
        productList.add(new Gum("Five", "A2", 10, 1.25));
        productList.add(new Gum("Trident", "A3", 0, 1.25));
        productList.add(new Gum("Juicy fruit", "A4", 10, 1.25));
        productList.add(new Gum("Bubble Yum", "A5", 10, 1.25));
    }

 }
