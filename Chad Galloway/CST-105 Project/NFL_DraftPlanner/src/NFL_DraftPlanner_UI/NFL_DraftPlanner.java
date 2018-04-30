//This is my own work. Chad Galloway
/**  Program: NFL Draft Planner
*    File: NFL_DraftPlanner.java
*    Summary: Offensive player class to be used in NFL Draft Planner application.
*    Author: Chad Galloway 
*    Date: Jan. 20, 2018
**/

package NFL_DraftPlanner_UI;

import NFL_DraftPlanner_PlayerManager.NFL_PlayerManager;
import NFL_DraftPlanner_PlayerManager.Team;
import NFL_DraftPlanner_Players.Defensive_NFL_Player;
import NFL_DraftPlanner_Players.NFL_Player;
import NFL_DraftPlanner_Players.Offensive_NFL_Player;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NFL_DraftPlanner extends Application {
    
    //////////////////////////////////
    // Private class wide variables //
    //////////////////////////////////
    
    // Table view selection tracking
    private Team selectedTeam = new Team();
    private NFL_Player selectedPlayer = new Offensive_NFL_Player();
    
    // Manager object instance for all the players
    private NFL_PlayerManager playerManager = new NFL_PlayerManager();
    
    // Table views for displaying players
    private TableView<NFL_Player> tableAvaliblaPlayers = new TableView<>(FXCollections.observableArrayList(playerManager.getAvaliblePlayers()));
    private TableView<NFL_Player> tableSelectedPlayers = new TableView<>(FXCollections.observableArrayList(playerManager.getSelectedPlayers()));
        
    // Main and start methods to get the ball rolling
    public static void main(String[] args) throws InterruptedException {
        launch(args);
    }        
    @Override
    public void start(Stage primaryStage) throws InterruptedException {
        
        // Load players
        playerManager.loadPlayers(); 
        
        // Load sort tables by name
        playerManager.sortPlayersByName();
        
        // Create Splash screen
        StackPane base_splashScene = new StackPane();
        BorderPane bdrPane = new BorderPane();
        Text txt_Logo = new Text("CEG Studios");
        txt_Logo.setFont(new Font("SansSerif",72));
        Text txt_description = new Text("Desgining solotions for the demanding\n                  buisness world.");
        txt_description.setFont(new Font("SansSerif",21));
        ProgressBar pgrBar = new ProgressBar(0);
        pgrBar.setPrefWidth(200);
        BorderPane.setAlignment(pgrBar, Pos.CENTER);
        BorderPane.setMargin(pgrBar, new Insets(20));
        BorderPane.setAlignment(txt_Logo, Pos.CENTER);
        BorderPane.setMargin(txt_Logo, new Insets(4));
        bdrPane.setBottom(pgrBar);
        bdrPane.setTop(txt_Logo);
        bdrPane.setCenter(txt_description);
        base_splashScene.getChildren().add(bdrPane);
        Scene splashScene = new Scene(base_splashScene, 450,350);

        // Load the Team Selection Scene and start the Primary Stage.
        primaryStage.setTitle("NFL Draft Planner");
        primaryStage.setScene(splashScene);        
        primaryStage.show();
        
        //Wait five seconds, update progress bar, and load team scane.
        // unable to figure out how to make java wait so this part does not work.
//        Long start = System.currentTimeMillis();
//        Long tick = start + 500;
//        while ( start + 5000  > System.currentTimeMillis() ) {
//            if ( tick < System.currentTimeMillis() ) {
//                tick = System.currentTimeMillis() + 500;
//                pgrBar.setProgress((System.currentTimeMillis() - start) / 50);
//                System.out.println("tick");
//            }
//        }
        
        
        primaryStage.hide();

        // Load the Team Selection Scene and show the Primary Stage
        primaryStage.setTitle("NFL Draft Planner - Team Selection.");
        primaryStage.setScene(TeamSelectionScene());
        primaryStage.show();
    }

    public Scene TeamSelectionScene() {
        
        // Title for team Scene
        Label title_teamScene = new Label("Team Selection");
        title_teamScene.setFont(Font.font("Courier", 24));
        
        // Button Select
        Button btn_select_teamScene = new Button("Select Team");
        btn_select_teamScene.setPrefWidth(200);
        btn_select_teamScene.setOnAction((ActionEvent e) -> {
            // Catch no team selected
            if ( selectedTeam.getTeamName().equals("") ) {
                return;
            }
            
            // Find and hide the Primary Stage
            Stage mainSceneStage = (Stage)((Node) e.getSource()).getScene().getWindow();
            mainSceneStage.hide();
            
            // Load the Main Scene and show the Primary Stage
            mainSceneStage.setTitle("NFL Draft Planner - " + selectedTeam.toString() + " Drafting session.");
            mainSceneStage.setScene(MainScene());
            mainSceneStage.show();
        });
        
        // Button Exit
        Button btn_exit_teamScene = new Button("Exit");
        btn_exit_teamScene.setPrefWidth(200);
        btn_exit_teamScene.setOnAction((e) -> {
            System.exit(0);
        });
       
        // Button Box
        HBox btns_teamScene = new HBox();
        btns_teamScene.getChildren().addAll(btn_select_teamScene, btn_exit_teamScene);
        btns_teamScene.setAlignment(Pos.CENTER);
        btns_teamScene.setSpacing(20);
        btns_teamScene.setPadding(new Insets(10));
        
        // TableView table_teamScene
        TableView<Team> table_teamScene = new TableView();

        // Table Column teamCityColumn
        TableColumn<Team, String> teamCityColumn = new TableColumn<>("Team City");
        teamCityColumn.setCellValueFactory(new PropertyValueFactory<>("teamCity"));
        teamCityColumn.prefWidthProperty().bind(table_teamScene.widthProperty().divide(2).subtract(8));
                
        // Table Column teamNameColumn
        TableColumn<Team, String> teamNameColumn = new TableColumn<>("Team Name");
        teamNameColumn.setCellValueFactory(new PropertyValueFactory<>("teamName"));
        teamNameColumn.prefWidthProperty().bind(table_teamScene.widthProperty().divide(2).subtract(7));
        
        // TableView table_mainScene
        table_teamScene.getColumns().addAll(teamCityColumn, teamNameColumn);
        table_teamScene.setItems(FXCollections.observableArrayList(Team.genereateAllCurrent_NFL_Teams()));
        table_teamScene.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                selectedTeam = newSelection;
            }
        });
        
        // BorderPane
        BorderPane bdr_teamScene = new BorderPane();
        BorderPane.setAlignment(title_teamScene, Pos.CENTER);
        BorderPane.setMargin(table_teamScene, new Insets(5));
        bdr_teamScene.setBottom(btns_teamScene);
        bdr_teamScene.setTop(title_teamScene);
        bdr_teamScene.setCenter(table_teamScene);
        
        // Stack pane at the base
        StackPane base_teamScene = new StackPane();
        base_teamScene.getChildren().add(bdr_teamScene);
        
        // Composed Scene
        Scene teamScene = new Scene(base_teamScene, 450,350);
        
        return teamScene;
        
      }

    public Scene MainScene() {
        
        // Use tab pane with one tab for avalible players UI and one tab for selected players UI
        TabPane tabs_mainScene = new TabPane();
        tabs_mainScene.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        // Avalible players tab
        Tab tabAvaliblePlayers = new Tab();
        tabAvaliblePlayers.setText("Avalible Players for Draft");
        tabAvaliblePlayers.setContent(avaliblePlayersTabBasePane());
        
        // Selected players tab
        Tab tabSelectedPlayers = new Tab();
        tabSelectedPlayers.setText("Players on My Roster");
        tabSelectedPlayers.setContent(selectedPlayersTabBasePane());
        tabSelectedPlayers.setOnSelectionChanged((Event e) -> {
            refreshPlayersTables();
        });
        
        // Add tabs to tab pane
        tabs_mainScene.getTabs().addAll(tabAvaliblePlayers, tabSelectedPlayers);

        // StackPane base_mainScene
        StackPane mainScenePane = new StackPane();
        mainScenePane.getChildren().add(tabs_mainScene);         
        
        Scene mainScene = new Scene(mainScenePane, 500, 350);

        return mainScene;
    }
    private Pane avaliblePlayersTabBasePane() {

        // Title for avalible players tab.
        Label title_AvaliblePlayersTab = new Label("Current draft cantidates for the " + selectedTeam.toString());
        title_AvaliblePlayersTab.setFont(Font.font("Courier", 18));
        BorderPane.setAlignment(title_AvaliblePlayersTab, Pos.CENTER);

        // Button Filter Players
        Button btn_filterPlayers_AvaliblePlayersTab = new Button("Filter Players");        
        btn_filterPlayers_AvaliblePlayersTab.setPrefWidth(150);
        btn_filterPlayers_AvaliblePlayersTab.setOnAction((ActionEvent e) -> {
            filterDialog("Avalible Player");
        });
        
        // Button Add Player
        Button btn_addPlayer_AvaliblePlayersTab = new Button("  Add Player\nto My Roster");
        btn_addPlayer_AvaliblePlayersTab.setPrefWidth(150);
        btn_addPlayer_AvaliblePlayersTab.setOnAction((ActionEvent e) -> {
            playerManager.selectPlayer(selectedPlayer.getName());
            refreshPlayersTables();
        });

        // Button View player Details
        Button btn_playerDetails_AvaliblePlayersTab = new Button("Player Details");
        btn_playerDetails_AvaliblePlayersTab.setPrefWidth(150);
        btn_playerDetails_AvaliblePlayersTab.setOnAction((ActionEvent e) -> {
            detailsDialog("Avalible Player");
        });
        
        // Button Remove Player From Avalibility.
        Button btn_removePlayer_AvaliblePlayersTab = new Button("Remove Player\nFrom Avalibility");
        btn_removePlayer_AvaliblePlayersTab.setPrefWidth(150);
        btn_removePlayer_AvaliblePlayersTab.setOnAction((ActionEvent e) -> {
            playerManager.removeFromAvalibility(selectedPlayer);
            refreshPlayersTables();
        });
        
        // Button Exit closes application
        Button btn_exit_AvaliblePlayersTab = new Button("EXIT");
        btn_exit_AvaliblePlayersTab.setPrefWidth(150);
        btn_exit_AvaliblePlayersTab.setOnAction((ActionEvent event) -> {
            System.exit(0);
        });

        
        // VBox_Button_Holder
        VBox btnHolder_AvaliblePlayersTab = new VBox();
        btnHolder_AvaliblePlayersTab.setSpacing(10);
        btnHolder_AvaliblePlayersTab.getChildren().add(btn_filterPlayers_AvaliblePlayersTab);
        btnHolder_AvaliblePlayersTab.getChildren().add(btn_addPlayer_AvaliblePlayersTab);
        btnHolder_AvaliblePlayersTab.getChildren().add(btn_playerDetails_AvaliblePlayersTab);
        btnHolder_AvaliblePlayersTab.getChildren().add(btn_removePlayer_AvaliblePlayersTab);
        //btnHolder_AvaliblePlayersTab.getChildren().add(btn_exit_AvaliblePlayersTab);

        // Stack pane for buttons
        StackPane btnStackPane_AvaliblePlayersTab = new StackPane();
        StackPane.setAlignment(btn_exit_AvaliblePlayersTab, Pos.BOTTOM_CENTER);
        StackPane.setAlignment(btnHolder_AvaliblePlayersTab, Pos.TOP_CENTER);
        btnStackPane_AvaliblePlayersTab.getChildren().addAll(btnHolder_AvaliblePlayersTab, btn_exit_AvaliblePlayersTab);
        
         // Players Name column
        TableColumn<NFL_Player, String> playersNameColumn = new TableColumn<>("Name");
        playersNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        // Players Number column
        TableColumn<NFL_Player, Short> playersNumberColumn = new TableColumn<>("Number");
        playersNumberColumn.setCellValueFactory(new PropertyValueFactory<>("playersNumber"));
        
        // Players Position Column
        TableColumn<NFL_Player, String> playersPositionColumn = new TableColumn<>("Position");
        playersPositionColumn.setCellValueFactory(new PropertyValueFactory<>("playersPosition"));
        
        // Players Age column
        TableColumn<NFL_Player, Short> playersAgeColumn = new TableColumn<>("Age");
        playersAgeColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        
        // TableView of avalible players
        tableAvaliblaPlayers.getColumns().addAll(playersNameColumn, playersNumberColumn, playersPositionColumn, playersAgeColumn);
        tableAvaliblaPlayers.setItems(FXCollections.observableArrayList(playerManager.getAvaliblePlayers()));
        refreshPlayersTables();
        tableAvaliblaPlayers.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                selectedPlayer = newSelection;
            }
        });
        
        // BorderPane bdr_selectedPlayersTab
        BorderPane bdr_mainScene = new BorderPane();
        bdr_mainScene.setPadding(new Insets(0, 7, 10, 5));
        bdr_mainScene.setRight(btnStackPane_AvaliblePlayersTab);
        bdr_mainScene.setTop(title_AvaliblePlayersTab);
        bdr_mainScene.setLeft(tableAvaliblaPlayers);
        tableAvaliblaPlayers.prefWidthProperty().bind(bdr_mainScene.widthProperty().subtract(170));

        return bdr_mainScene;
    }
    private Pane selectedPlayersTabBasePane() {

        // Title for selected players tab
        Label title_selectedPlayersTab = new Label("Players the " + selectedTeam.toString() + " are considering for the draft.");
        title_selectedPlayersTab.setFont(Font.font("Courier", 14));
        BorderPane.setAlignment(title_selectedPlayersTab, Pos.CENTER);
        BorderPane.setMargin(title_selectedPlayersTab, new Insets(3, 0, 4, 0));
        
        // Button Filter Players
        Button btn_filter_selectedPlayersTab = new Button("Filter Players");        
        btn_filter_selectedPlayersTab.setMaxWidth(300);
        btn_filter_selectedPlayersTab.setOnAction((ActionEvent e) -> {
            filterDialog("Selected Player");
        });
        
        // Button Remove Player
        Button btn_addPlayer_selectedPlayersTab = new Button("Remove Player\nfrom My Roster");
        btn_addPlayer_selectedPlayersTab.setMaxWidth(300);
        btn_addPlayer_selectedPlayersTab.setOnAction((ActionEvent e) -> {
            playerManager.removePlayer(selectedPlayer.getName());
            playerManager.sortPlayersByName();
            refreshPlayersTables();

        });

        // Button Raise draft Priority
        Button btn_raisePriority_selectedPlayersTab = new Button("Raise Draft Priority");
        btn_raisePriority_selectedPlayersTab.setMaxWidth(300);
        btn_raisePriority_selectedPlayersTab.setPrefWidth(150);
        btn_raisePriority_selectedPlayersTab.setOnAction((ActionEvent e) -> {
            playerManager.raisePlayersPriority(selectedPlayer.getName());
            refreshPlayersTables();
        });
        
        // Button View player Details
        Button btn_playerDetails_selectedPlayersTab = new Button("Player Details");
        btn_playerDetails_selectedPlayersTab.setMaxWidth(300);
        btn_playerDetails_selectedPlayersTab.setOnAction((ActionEvent e) -> {
            detailsDialog("Selected Player");
        });
        
        // Button Lower draft Priority
        Button btn_lowerPriority_selectedPlayersTab = new Button("Lower Draft Priority");
        btn_lowerPriority_selectedPlayersTab.setMaxWidth(300);
        btn_lowerPriority_selectedPlayersTab.setOnAction((ActionEvent e) -> {
            playerManager.lowerPlayersPriority(selectedPlayer.getName());
            refreshPlayersTables();
        });

        // btn_exit_selectedPlayersTab
        Button btn_exit_selectedPlayersTab = new Button("EXIT");
        btn_exit_selectedPlayersTab.setMaxWidth(300);
        btn_exit_selectedPlayersTab.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        
        // VBox_Button_Holder
        VBox btn_hldr_selectedPlayersTab = new VBox();
        btn_hldr_selectedPlayersTab.setSpacing(10);
        btn_hldr_selectedPlayersTab.getChildren().add(btn_filter_selectedPlayersTab);
        btn_hldr_selectedPlayersTab.getChildren().add(btn_addPlayer_selectedPlayersTab);
        btn_hldr_selectedPlayersTab.getChildren().add(btn_raisePriority_selectedPlayersTab);
        btn_hldr_selectedPlayersTab.getChildren().add(btn_playerDetails_selectedPlayersTab);
        btn_hldr_selectedPlayersTab.getChildren().add(btn_lowerPriority_selectedPlayersTab);

        // Stack pane for buttons
        StackPane btnStackPane_SelectedPlayersTab = new StackPane();
        StackPane.setAlignment(btn_exit_selectedPlayersTab, Pos.BOTTOM_CENTER);
        StackPane.setAlignment(btn_hldr_selectedPlayersTab, Pos.TOP_CENTER);
        btnStackPane_SelectedPlayersTab.getChildren().addAll(btn_hldr_selectedPlayersTab, btn_exit_selectedPlayersTab);
        
        // Players Name column
        TableColumn<NFL_Player, String> playersNameColumn = new TableColumn<>("Name");
        playersNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        playersNameColumn.setSortable(Boolean.FALSE);
        
        // Players Number column
        TableColumn<NFL_Player, Short> playersNumberColumn = new TableColumn<>("Number");
        playersNumberColumn.setCellValueFactory(new PropertyValueFactory<>("playersNumber"));
        playersNumberColumn.setSortable(Boolean.FALSE);
        
        // Players Position Column
        TableColumn<NFL_Player, String> playersPositionColumn = new TableColumn<>("Position");
        playersPositionColumn.setCellValueFactory(new PropertyValueFactory<>("playersPosition"));
        playersPositionColumn.setSortable(Boolean.FALSE);
        
        // Players Age column
        TableColumn<NFL_Player, Short> playersAgeColumn = new TableColumn<>("Age");
        playersAgeColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        playersAgeColumn.setSortable(Boolean.FALSE);
        
        // TableView table_selectedPlayersTab
        tableSelectedPlayers.getColumns().addAll(playersNameColumn, playersNumberColumn, playersPositionColumn, playersAgeColumn);
        tableSelectedPlayers.setItems(FXCollections.observableArrayList(playerManager.getSelectedPlayers()));
        refreshPlayersTables();
        tableSelectedPlayers.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                selectedPlayer = newSelection;
            }
        });
        
        // BorderPane bdr_selectedPlayersTab
        BorderPane bdr_selectedPlayersTab = new BorderPane();
        bdr_selectedPlayersTab.setPadding(new Insets(0,7,10,5));
        bdr_selectedPlayersTab.setRight(btnStackPane_SelectedPlayersTab);
        bdr_selectedPlayersTab.setTop(title_selectedPlayersTab);
        bdr_selectedPlayersTab.setLeft(tableSelectedPlayers);
        tableSelectedPlayers.prefWidthProperty().bind(bdr_selectedPlayersTab.widthProperty().subtract(170));

        return bdr_selectedPlayersTab;
    }
    
    private void filterDialog(String playerType) {

        RadioButton rb_position = new RadioButton("Position");        
        RadioButton rb_sideOfField = new RadioButton("Side of Field");
        CheckBox cb_offense = new CheckBox("Offense");
        CheckBox cb_defense = new CheckBox("Defense");
        CheckBox cb_quaterback = new CheckBox("Quaterback");
        CheckBox cb_runningback = new CheckBox("Runningback");
        CheckBox cb_wideReceiver = new CheckBox("Wide Receiver");
        CheckBox cb_tightEnd = new CheckBox("Tight End");
        CheckBox cb_offensiveLineman = new CheckBox("Offensive Lineman");
        CheckBox cb_defensiveLineman = new CheckBox("Defensive Lineman");
        CheckBox cb_linebacker = new CheckBox("Linebacker");
        CheckBox cb_defensiveBack = new CheckBox("Defensive Back");
        ToggleGroup rb_group = new ToggleGroup();
        rb_group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
                if (rb_group.getSelectedToggle().equals(rb_sideOfField)) {
                    cb_quaterback.setSelected(false);
                    cb_runningback.setSelected(false);
                    cb_wideReceiver.setSelected(false);
                    cb_tightEnd.setSelected(false);
                    cb_offensiveLineman.setSelected(false);
                    cb_defensiveLineman.setSelected(false);
                    cb_linebacker.setSelected(false);
                    cb_defensiveBack.setSelected(false);
                }
                else {
                    cb_offense.setSelected(false);
                    cb_defense.setSelected(false);
                }
            }
        });
                
        Stage filterDialog = new Stage();
        filterDialog.initModality(Modality.WINDOW_MODAL);

        // Anchor pane
        AnchorPane filterPane = new AnchorPane();
        
        // Radio buttons
        rb_sideOfField.setLayoutX(20);
        rb_sideOfField.setLayoutY(17);
        rb_sideOfField.setSelected(true);
        rb_sideOfField.setToggleGroup(rb_group);
        Rectangle rec_sideOfField = new Rectangle(11, 13, 300, 53);
        rec_sideOfField.setFill(Color.WHITESMOKE);
        rec_sideOfField.setArcHeight(10);
        rec_sideOfField.setArcWidth(10);
        rec_sideOfField.setStroke(Color.GRAY);
        
        rb_position.setLayoutX(20);
        rb_position.setLayoutY(75);
        rb_position.setToggleGroup(rb_group);
        Rectangle rec_position = new Rectangle(11, 70, 300, 108);
        rec_position.setFill(Color.WHITESMOKE);
        rec_position.setArcHeight(10);
        rec_position.setArcWidth(10);
        rec_position.setStroke(Color.GRAY);
       
        // CheckBoxes
        cb_offense.setSelected(true);
        cb_offense.setOnAction((ActionEvent e)-> {
            if ( ((CheckBox)e.getSource()).isSelected() ){
                rb_sideOfField.setSelected(true);
            }
        });
        cb_defense.setSelected(true);
        cb_defense.setOnAction((ActionEvent e)-> {
            if ( ((CheckBox)e.getSource()).isSelected() ){
                rb_sideOfField.setSelected(true);
            }
        });
        cb_quaterback.setOnAction((ActionEvent e)-> {
            if ( ((CheckBox)e.getSource()).isSelected() ){
                rb_position.setSelected(true);
            }
        });
        cb_runningback.setOnAction((ActionEvent e)-> {
            if ( ((CheckBox)e.getSource()).isSelected() ){
                rb_position.setSelected(true);
            }
        });
        cb_wideReceiver.setOnAction((ActionEvent e)-> {
            if ( ((CheckBox)e.getSource()).isSelected() ){
                rb_position.setSelected(true);
            }
        });
        cb_tightEnd.setOnAction((ActionEvent e)-> {
            if ( ((CheckBox)e.getSource()).isSelected() ){
                rb_position.setSelected(true);
            }
        });
        cb_offensiveLineman.setOnAction((ActionEvent e)-> {
            if ( ((CheckBox)e.getSource()).isSelected() ){
                rb_position.setSelected(true);
            }
        });
        cb_defensiveLineman.setOnAction((ActionEvent e)-> {
            if ( ((CheckBox)e.getSource()).isSelected() ){
                rb_position.setSelected(true);
            }
        });
        cb_linebacker.setOnAction((ActionEvent e)-> {
            if ( ((CheckBox)e.getSource()).isSelected() ){
                rb_position.setSelected(true);
            }
        });
        cb_defensiveBack.setOnAction((ActionEvent e)-> {
            if ( ((CheckBox)e.getSource()).isSelected() ){
                rb_position.setSelected(true);
            }
        });
        
        GridPane sideOfFieldGrid = new GridPane();
        sideOfFieldGrid.add(cb_offense, 0, 0);
        sideOfFieldGrid.add(cb_defense, 1, 0);
        sideOfFieldGrid.setLayoutX(43);
        sideOfFieldGrid.setLayoutY(43);
        sideOfFieldGrid.setHgap(65);
        
        GridPane positionGrid = new GridPane();
        positionGrid.add(cb_quaterback, 0, 0);
        positionGrid.add(cb_runningback, 0, 1);
        positionGrid.add(cb_wideReceiver, 0, 2);
        positionGrid.add(cb_tightEnd, 0, 3);
        positionGrid.add(cb_offensiveLineman, 1, 0);
        positionGrid.add(cb_defensiveLineman, 1, 1);
        positionGrid.add(cb_linebacker, 1, 2);
        positionGrid.add(cb_defensiveBack, 1, 3);
        positionGrid.setLayoutX(43);
        positionGrid.setLayoutY(100);
        positionGrid.setHgap(30);
        
        Button btn_ok = new Button("OK");
        btn_ok.setLayoutX(110);
        btn_ok.setLayoutY(187);
        btn_ok.setOnAction((ActionEvent e) -> {            
            int filterCount = 0;
            if ( rb_sideOfField.isSelected() ) {
                if ( cb_offense.isSelected() ) filterCount += 1;
                if ( cb_defense.isSelected() ) filterCount += 2;
            }
            else if (rb_position.isSelected() ) {
                if ( cb_quaterback.isSelected() ) filterCount += 4;
                if ( cb_runningback.isSelected() ) filterCount += 8;
                if ( cb_wideReceiver.isSelected() ) filterCount += 16;
                if ( cb_tightEnd.isSelected() ) filterCount += 32;
                if ( cb_offensiveLineman.isSelected() ) filterCount += 64;
                if ( cb_defensiveLineman.isSelected() ) filterCount += 128;
                if ( cb_linebacker.isSelected() ) filterCount += 256;
                if ( cb_defensiveBack.isSelected()) filterCount += 512;
            }
            if ( playerType.startsWith( "Avalible" ) ) playerManager.filterAvaliblePlayers( filterCount );
            if ( playerType.startsWith( "Selected" ) ) playerManager.filterSelectedPlayers( filterCount );
            playerManager.sortPlayersByName();
            refreshPlayersTables();
            filterDialog.hide();
        });
        
        Button btn_cancel = new Button("Cancel");
        btn_cancel.setLayoutX(160);
        btn_cancel.setLayoutY(187);
        btn_cancel.setOnAction((ActionEvent e) -> {
            filterDialog.close();
        });
        
        filterPane.getChildren().addAll(rec_sideOfField, rb_sideOfField, rec_position, rb_position, sideOfFieldGrid, positionGrid, btn_ok, btn_cancel);
        
        StackPane baseStackPane = new StackPane();        
        baseStackPane.getChildren().addAll( filterPane );
        Scene filterDialogScene = new Scene(baseStackPane, 325, 221);

        filterDialog.setTitle(playerType + " Filters");
        filterDialog.setScene(filterDialogScene);
        filterDialog.show();
    }
    private void detailsDialog(String playerType) {
        
        Stage detailsDialog = new Stage();
        detailsDialog.initModality(Modality.WINDOW_MODAL);
        
        // Anchor pane
        AnchorPane detailsPane = new AnchorPane();
        Text txt_player = new Text(selectedPlayer.toString());
        txt_player.setX(20);
        txt_player.setY(20);
        Text txt_stats = new Text();
        txt_stats.setX(20);
        txt_stats.setY(150);
        
        Button btn_close = new Button("Close");
        btn_close.setLayoutX(210);
        btn_close.setLayoutY(188);
        btn_close.setOnAction((ActionEvent e) -> {
            detailsDialog.close();
        });
        
        Offensive_NFL_Player oPlayer;
        Defensive_NFL_Player dPlayer;
        if ( selectedPlayer instanceof Offensive_NFL_Player ) {
            oPlayer = (Offensive_NFL_Player)selectedPlayer;
            txt_stats.setText(oPlayer.toStringStats());
        }
        else {
            dPlayer = (Defensive_NFL_Player)selectedPlayer;
            txt_stats.setText(dPlayer.toStringStats());
        }
        
            
        detailsPane.getChildren().addAll(txt_player, txt_stats, btn_close);


        StackPane baseStackPane = new StackPane();        
        baseStackPane.getChildren().addAll( detailsPane );
        Scene detailsDialogScene = new Scene(baseStackPane, 450, 225);

        detailsDialog.setTitle("Player Details");
        detailsDialog.setScene(detailsDialogScene);
        detailsDialog.show();

    }

    private void refreshPlayersTables() {
        tableAvaliblaPlayers.setItems(FXCollections.observableArrayList(playerManager.getAvaliblePlayers()));
        tableSelectedPlayers.setItems(FXCollections.observableArrayList(playerManager.getSelectedPlayers()));
    }
}
