/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

import java.awt.Color;
import java.io.FileInputStream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

/**
 *
 * @author Office Computer
 */
public class Vendingmachine extends Application {
    
    private Boolean adminMode = false;  // adminMode flag
    private int moneyInserted = 0;
    private int productsCost = 0;
    
    // GUI node declarations
    private StackPane customerPane = new StackPane();
    private BorderPane customerBorder = new BorderPane();
    private HBox largeCoinSlot = new HBox();
    private HBox smallCoinSlot = new HBox();
    private VBox moneySlot = new VBox();
    private VBox customerControls = new VBox();
    private GridPane categoryGrid = new GridPane();
    private GridPane itemGrid = new GridPane();
    private Label lblBills = new Label("Bills");
    private Button btnAddTwentyDollars = new Button("Twenty Dollars");
    private Button btnAddTenDollars = new Button("Ten Dollars");
    private Button btnAddFiveDollars = new Button("Five Dollars");
    private Button btnAddOneDollar = new Button("One Dollar");
    private Label lblCoins = new Label("Coins");
    private Button btnAddOneDollarCoin = new Button("$1.00");
    private Button btnAddFiftyCentCoin = new Button("$.50");
    private Button btnAddQuater = new Button("$.25");
    private Button btnAddDime = new Button("$.10");
    private Button btnAddNickle = new Button("$.05");
    private Label lblLeftBlank = new Label("  ");
    private Label lblRightBlank = new Label("  ");
    private Button btnNextPage = new Button("Next");
    private Button btnPreviousPage = new Button("Previous");
    private Button btnDrinkCategory = new Button("Drinks");
    private final Image imgDrinkCategory = new Image(getClass().getResourceAsStream("images/drinkCategory.jpg"));
    private final ImageView viewDrinkCategory = new ImageView(imgDrinkCategory);
    private Button btnChipsCategory = new Button("Chips");
    private final Image imgChipsCategory = new Image(getClass().getResourceAsStream("images/chipsCategory.jpg"));
    private final ImageView viewChipsCategory = new ImageView(imgChipsCategory);
    private Button btnCandyCategory = new Button("Candy");
    private final Image imgCandyCategory = new Image(getClass().getResourceAsStream("images/candyCategory.jpg"));
    private final ImageView viewCandyCategory = new ImageView(imgCandyCategory);
    private Button btnGumCategory = new Button("Gum");
    private final Image imgGumCategory = new Image(getClass().getResourceAsStream("images/gumCategory.jpeg"));
    private final ImageView viewGumCategory = new ImageView(imgGumCategory);
    private Button btnItem1_1 = new Button();
    private Button btnItem1_2 = new Button();
    private Button btnItem1_3 = new Button();
    private Button btnItem2_1 = new Button();
    private Button btnItem2_2 = new Button();
    private Button btnItem2_3 = new Button();
    private Button btnItem3_1 = new Button();
    private Button btnItem3_2 = new Button();
    private Button btnItem3_3 = new Button();
    private Label lblFunds = new Label("Funds:");
    private Text txtFundsAmount = new Text("$0.00");
    private Label lblCost = new Label("Cost:");
    private Text txtCostAmount = new Text("$0.00");
    private Button btnReturnMoney = new Button("Coin Return");
    private Button btnCompletePurchase = new Button("Complete Purchase");
    private Button btnFinished = new Button("Finished");
    private Stage customerStage = new Stage();
    
    @Override
    public void start(Stage primaryStage) {
        
        // Set VBox and HBox spacing and padding.
        largeCoinSlot.setSpacing(8);
        smallCoinSlot.setSpacing(2);
        moneySlot.setSpacing(10);
        moneySlot.setPadding(new Insets(5));
        customerControls.setSpacing(10);
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
        
        btnItem1_1.setPrefSize(70, 70);
        btnItem1_2.setPrefSize(70, 70);
        btnItem1_3.setPrefSize(70, 70);
        btnItem2_1.setPrefSize(70, 70);
        btnItem2_2.setPrefSize(70, 70);
        btnItem2_3.setPrefSize(70, 70);
        btnItem3_1.setPrefSize(70, 70);
        btnItem3_2.setPrefSize(70, 70);
        btnItem3_3.setPrefSize(70, 70);
        
        btnFinished.setOnAction((event) -> {
            customerStage.hide();
            customerBorder.setCenter(categoryGrid);
            primaryStage.show();
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
        
        btnAddOneDollar.prefWidthProperty().bind(smallCoinSlot.widthProperty());
        btnAddFiveDollars.prefWidthProperty().bind(smallCoinSlot.widthProperty());
        btnAddTenDollars.prefWidthProperty().bind(smallCoinSlot.widthProperty());
        btnAddTwentyDollars.prefWidthProperty().bind(smallCoinSlot.widthProperty());
        
        btnReturnMoney.prefWidthProperty().bind(btnCompletePurchase.widthProperty());
        btnFinished.prefWidthProperty().bind(btnCompletePurchase.widthProperty());

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
        
        customerControls.getChildren().addAll(lblFunds, txtFundsAmount, lblCost, txtCostAmount, lblRightBlank, btnCompletePurchase, btnReturnMoney, btnFinished);
        customerControls.setAlignment(Pos.BOTTOM_CENTER);
        customerBorder.setRight(customerControls);
        
        // Build category center section for border pane
        categoryGrid.addRow(0, btnDrinkCategory, btnChipsCategory);
        categoryGrid.addRow(1, btnCandyCategory, btnGumCategory);
        categoryGrid.setAlignment(Pos.CENTER);
        customerBorder.setCenter(categoryGrid);
        
        // build item center section for border pane
        itemGrid.addRow(0, btnItem1_1, btnItem1_2, btnItem1_3);
        itemGrid.addRow(1, btnItem2_1, btnItem2_2, btnItem2_3);
        itemGrid.addRow(2, btnItem3_1, btnItem3_2, btnItem3_3);
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
    private void populateItemGrid(int category, int page) {
        customerBorder.setCenter(itemGrid);
    }

    private void updateFunds() {
        String text = String.format("$" + moneyInserted / 100 + ".%02d", moneyInserted % 100);
        txtFundsAmount.setText(text);
    }

 }
