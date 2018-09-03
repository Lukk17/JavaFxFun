package helloWorld;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import static helloWorld.AdditionalMethods.*;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    static Scene    scene1, scene2, scene3, webBrowserScene;
    static Button   gokuButton, button1W, button12, button13 , button21, button2W, button23,
            button31, button32, button3W,  buttonW1, buttonW2, buttonW3,
            windowBut, pointbut, exitBut, songo,
                checkboxBut, choiceBoxbut, textFieldBut, clearBut, listViewBut, 
                addtoTable, deleteFromTable, browserAdressBut;
    
//    number in brackets are spacing between elements
    static VBox     layout1 = new VBox(10), layout2V = new VBox(10), layout2V_2= new VBox(10);
    static HBox    layout2H = new HBox(10), layout2H_2= new HBox(), layoutTableInput = new HBox(),
            browserAdressLayout = new HBox();
    
    static GridPane layout2 = new GridPane(), layout3= new GridPane();
    
    static BorderPane borderPane = new BorderPane(), webBrowserLayout;
    
    
    static Stage    mainWindow;
    
    static Label label1, label2, checkboxLabel, choiceBoxLabel, textLabel, comboBoxLabel,
            listLabel, treeLabel, menuLabel, bindLabel;
    
    static Text bindTxt;
    
    static TableView<Product> table;
    
    static TextField nameField, priceField, quantityField, bindField, browserAdressField;
    
    static private String textinLabel = "";
    
    
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        
        mainWindow = primaryStage;
        
//        on closing request (such as X button in right conner) it will consume this event,
//        which will normally close window and run method for confimation of app closing
      
        /* mainWindow.setOnCloseRequest(e ->
        {
            e.consume();
            closeProgram();
        });*/
        
        mainWindow.setTitle("Dragon ball");
        
//  ======================================================================================
//                                   BUTTONS
        
        //        button closing program
        exitBut = new Button("exit");
        exitBut.setOnAction(e -> closeProgram());

        //        button for songo, GridPane settings for layout2 (which is grid pane)
        gokuButton = new Button("Songo!");
        gokuButton.setOnAction(e -> {
            textLabel.setText(textinLabel+="KA-ME-HA-ME-HA !!!\n");
            });
        GridPane.setConstraints(gokuButton, 0, 0);

        //        popup new window - method HelloWorld open it
        windowBut = new Button("hello window");
        windowBut.setOnAction(e -> HelloWorld.display("Hello title", "Hello World"));
        GridPane.setConstraints(windowBut, 1, 1);

        //       button to print points in console
        pointbut = new Button("Points!");
        pointbut.setOnAction(e ->
        {
            boolean result = Point.point();
            if (result)
            {
                System.out.println("Point!");
            }
        });
        
//      buttons switching scenes
//        for scene1
      button1W = new Button("go to WebBrowser");
      button1W.setOnAction(e -> mainWindow.setScene(webBrowserScene));
      GridPane.setConstraints(button1W, 1, 0);

      button12 = new Button("go to scene2");
      button12.setOnAction(e -> mainWindow.setScene(scene2));
      
      button13 = new Button("go to scene3");
      button13.setOnAction(e -> mainWindow.setScene(scene3));
      
//      for scene2
      button2W = new Button("go to WebBrowser");
      button2W.setOnAction(e -> mainWindow.setScene(webBrowserScene));
      GridPane.setConstraints(button2W, 1, 0);

      button21 = new Button("go to scene1");
      button21.setOnAction(e -> mainWindow.setScene(scene1));
      
      button23 = new Button("go to scene3");
      button23.setOnAction(e -> mainWindow.setScene(scene3));
      
//      for scene 3
      button3W = new Button("go to WebBrowser");
      button3W.setOnAction(e -> mainWindow.setScene(webBrowserScene));
      GridPane.setConstraints(button3W, 1, 0);

      button31 = new Button("go to scene1");
      button31.setOnAction(e -> mainWindow.setScene(scene1));
      
      button32 = new Button("go to scene2");
      button32.setOnAction(e -> mainWindow.setScene(scene2));
      
//      for browser
      buttonW1 = new Button("go to scene1");
      buttonW1.setOnAction(e -> mainWindow.setScene(scene1));
      GridPane.setConstraints(buttonW1, 1, 0);

      buttonW2 = new Button("go to scene2");
      buttonW2.setOnAction(e -> mainWindow.setScene(scene2));
      
      buttonW3 = new Button("go to scene3");
      buttonW3.setOnAction(e -> mainWindow.setScene(scene3));
      
            
//      button for choiceBox
      choiceBoxbut = new Button("Fav show");
      
//      button for textField
      textFieldBut = new Button("show!");
      
      clearBut = new Button("Clear !");
      clearBut.setOnAction(e->
      {
          textLabel.setText(textinLabel="");
      
      });
      
      listViewBut = new Button("show list");
      
      addtoTable = new Button("Add");
      deleteFromTable = new Button("Delete");
//      change style class defined in .css file (here .redBut )
      deleteFromTable.getStyleClass().add("redBut");
      
      
      browserAdressBut = new Button("Go!");
      
       
//   ====================================================================================
//                                  LABELS  
      
        //        label printing info in scenes
        label1 = new Label("scene 1");
        label2 = new Label("Scene 2");
        GridPane.setConstraints(label2, 2, 0);
        
//        label printing info from checkbox
        checkboxLabel = new Label();
        choiceBoxLabel = new Label();
        
        textLabel = new Label();
        
        comboBoxLabel = new Label();
        
        listLabel = new Label();
        
        treeLabel = new Label();
        
        menuLabel = new Label();
        menuLabel.setPadding(new Insets(10, 50, 100, 100));
        menuLabel.setStyle("-fx-text-fill: rgb(240,247,115)");
        
        bindLabel = new Label();
        bindLabel.setPadding(new Insets(10, 50, 100, 100));
        bindLabel.setMinSize(300, 300);
        bindLabel.setMaxSize(300, 300);
        bindLabel.setWrapText(true);
        bindLabel.setId("textoo");
        
        
//    =================================================================================
//                              TEXT
        
        bindTxt = new Text();
        bindTxt.setWrappingWidth(200);
        bindTxt.maxWidth(300);
        bindTxt.minWidth(300);
        bindTxt.maxHeight(300);
        bindTxt.minHeight(300);
        
        
        
//    =================================================================================
//                              CHECKBOXES
        
//        checkbox - handleOption write into label the chechboxes texts
        CheckBox box1 = new CheckBox("Onion");
        CheckBox box2 = new CheckBox("Apple");
        
        checkboxBut = new Button("Order!");
        checkboxBut.setOnAction(e-> {
            
            checkboxLabel.setText(handleOption(box1,box2));
            });
        
        
//    ================================================================================
//                                  TEXTFIELD INPUT
        
        //        input for text
        TextField nameInput = new TextField("Bucky");
        GridPane.setConstraints(nameInput, 2, 1);
        nameInput.setMaxWidth(150);
        
        TextField nameInput2 = new TextField();
        nameInput2.setPromptText("input word!");
        GridPane.setConstraints(nameInput2, 2, 2);
        nameInput2.setMaxWidth(150);
        
        textFieldBut.setOnAction(e->{
            textLabel.setText(textinLabel += nameInput.getText()+ " " + nameInput2.getText()+"\n");
        });
        
        nameField = new TextField();
        nameField.setPromptText("Name");
        nameField.setMinWidth(150);
        
        priceField = new TextField();
        priceField.setPromptText("Price");
        
        quantityField = new TextField();
        quantityField.setPromptText("Quantity");
        
        bindField = new TextField();
        bindField.setPromptText("teexto");
        bindField.setMinSize(200, 200);
        
        browserAdressField = new TextField();
        browserAdressField.setPromptText("Type URL");
        browserAdressField.setMinSize(300, 25);
                

//    ================================================================================
//                                    CHOICEBOX
        
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("Dragon Ball", "Justice League" ,
                                    "Avengers", "Lion King");
        choiceBox.setValue("Dragon Ball");
        
        
        choiceBoxbut.setOnAction(e-> {
            
            choiceBoxLabel.setText(selectItem(choiceBox));
        });
        
        
//        choiceBox without button - automatically find value when choiceBox is clicked
        ChoiceBox<String> choiceBoxAuto = new ChoiceBox<>();
        choiceBoxAuto.getItems().addAll("Dragon Ball", "Justice League" ,
                                    "Avengers", "Lion King");
        choiceBoxAuto.setValue("Justice League");
        
        choiceBoxAuto.getSelectionModel().selectedItemProperty()
                        .addListener((v, oldValue, newValue) -> 
                            choiceBoxLabel.setText("old value: "+oldValue + ", new value: "+newValue) );
        
        
//    ===============================================================================
//                                     COMBOBOX
        
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Avatar"," Equalibrium"," Never Back Down");
        comboBox.setPromptText("Select movie");
        comboBox.setEditable(true);
        comboBox.setOnAction(e -> comboBoxLabel.setText(comboBox.getValue()));
        
        
//    ===============================================================================
//                                      LISTS
        
        ListView<String> list = new ListView<>();
        list.getItems().addAll("A","B","C");
        list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        listViewBut.setOnAction(e->{
            String result= "";
            ObservableList<String> items = list.getSelectionModel().getSelectedItems();
            for(String i:items)
            {
                result += i;
            }
        listLabel.setText(result);
        });
                
//    ================================================================================
//                                  TREEVIEW
        
        TreeItem<String> root, lukk, songo;
                               
        root= new TreeItem<>();
//        tree will be expanded
        root.setExpanded(true);
        
        lukk = makeBranch("Lukk", root);
        makeBranch("apple", lukk);
        makeBranch("power!", lukk);
        
        songo = makeBranch("Songo", root);
        makeBranch("KAMEHAMEHA", songo);
        
        TreeView<String> tree = new TreeView<>(root);
//        root branch won't show, only it's content:
        tree.setShowRoot(false);
        
//        will print into label selected branch
        tree.getSelectionModel().selectedItemProperty().addListener((v, oldVal, newVal) ->
        {
            String result = "";
            result+="old value: " +oldVal.getValue()+"\n";
            if(newVal!=null)
            {
                result+=" new value: "+newVal.getValue();
            }
            
            treeLabel.setText(result);
        });
            
        
//    ================================================================================
//                                  TABLES
        
       table = new TableView<>();
                      
       TableColumn<Product, String> name = new TableColumn<>("Name");
       name.setMinWidth(200);
       name.setCellValueFactory(new PropertyValueFactory<>("name"));
       
       TableColumn<Product, Double> price = new TableColumn<>("Price");
       price.setMinWidth(100);
       price.setCellValueFactory(new PropertyValueFactory<>("price"));
       
       TableColumn<Product, Integer> quantity = new TableColumn<>("Quantity");
       quantity.setMinWidth(100);
       quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
       
       table.setItems(addProducts());
       table.getColumns().addAll(name, price, quantity);
       table.setMinWidth(400);
       table.setMaxHeight(400);
       
       addtoTable.setOnAction(e-> addToTable());
       deleteFromTable.setOnAction(e->deleteFromTable());
       
//    ================================================================================
//                                  MENU
       Menu menu1 = new Menu("*");
       Menu menu2 = new Menu("**");
       Menu menu3 = new Menu("Scene change");
       
//       with _ user can press ALT + S (first letter) to open this menu:
       Menu menu4 = new Menu("_Summon");
       
       Menu menuCheck = new Menu("Check");
       
       Menu menuRadio = new Menu("Radio");
       
       menu1.getItems().add(new MenuItem("one"));
       menu1.getItems().add(new MenuItem("two"));
       menu1.getItems().add(new MenuItem("osiem"));
       
       menu2.getItems().add(new MenuItem("1"));
       menu2.getItems().add(new MenuItem("2"));
       menu2.getItems().add(new MenuItem("8"));
       
       MenuItem scene1Switch = new MenuItem("Scene 1");
       scene1Switch.setOnAction(e-> mainWindow.setScene(scene1));
       
       MenuItem scene2Switch = new MenuItem("Scene 2");
       scene2Switch.setOnAction(e-> mainWindow.setScene(scene2));
       
       MenuItem webBrowserSwitch = new MenuItem("Web Browser");
       webBrowserSwitch.setOnAction(e-> mainWindow.setScene(webBrowserScene));
       
       menu3.getItems().add(scene1Switch);
       menu3.getItems().add(scene2Switch);
       menu3.getItems().add(webBrowserSwitch);
       
       MenuItem star4 = new MenuItem("Summon Shenron!");
       star4.setOnAction(e-> menuLabel.setText("He----ey, Shenron!! Come on out!!"));
       
       MenuItem m44 = new MenuItem("m44");
       m44.setDisable(true);
         
       menu4.getItems().add(star4);
       menu4.getItems().add(new SeparatorMenuItem());
       menu4.getItems().add(m44);
       menu4.getItems().add(new MenuItem("444"));
       
//       manu item which can be checked like checkbox
       CheckMenuItem checked = new CheckMenuItem("Check");
       menuCheck.getItems().add(checked);
       
//       radio menu buttons - only one can be checked
       RadioMenuItem easy = new RadioMenuItem("Easy");
       RadioMenuItem medium = new RadioMenuItem("Medium");
       RadioMenuItem hard = new RadioMenuItem("Hard");
       
       ToggleGroup tg = new ToggleGroup();  // group items in one radio button group
       
       easy.setToggleGroup(tg);
       medium.setToggleGroup(tg);
       hard.setToggleGroup(tg);
       
       menuRadio.getItems().addAll(easy, medium, hard);
       
//       add menuBar which have all menus
       MenuBar menuBar = new MenuBar();
       menuBar.getMenus().addAll(menu1, menu2, menu3, menu4, menuCheck, menuRadio);
      
//    ================================================================================
//                                  BINDING
       
       bindLabel.textProperty().bind(bindField.textProperty());
       
       bindTxt.textProperty().bind(bindField.textProperty());
       
//    ================================================================================
//                                  BROWSER
       
       
       WebView webBrowser = new WebView();
       WebEngine webEngine = webBrowser.getEngine();
       
       Hyperlink hyperlink = new Hyperlink("Google");
       
       hyperlink.setOnAction(e-> webEngine.load("http://google.com"));
       
       browserAdressBut.setOnAction(e->
       {
           
       webEngine.load("http://"+browserAdressField.getText());
       browserAdressField.setText(webEngine.getLocation().replaceAll("http://", "").replaceAll("https://", ""));
       });
         
       
        
//    ================================================================================
//                                  LAYOUTS
        
        //        layouts settings Aligment- position in window; padding - space from edges;
        //        Vgap and Hgap - spaces between elements in layout
        layout1.getChildren().addAll(checkboxLabel, button12, button13, button1W, label1, windowBut, 
                    pointbut, exitBut, box1, box2, checkboxBut);
        layout1.setPadding(new Insets(10, 10, 10, 10));
        layout1.setAlignment(Pos.CENTER);

        
//        layout2 is grid layout
//        inside it there are 2 layouts - vertical and horizontal
        
//        layout2.addRow(2, layout2V);
//        layout2.addRow(1, layout2H);
//        layout2.addRow(3, layout2V_2);
        layout2.getChildren().addAll(layout2V, layout2V_2, layout2H, layout2H_2);
        layout2.setPadding(new Insets(10, 10, 10, 10));
        layout2.setVgap(40);
        layout2.setHgap(40);
        
        layout2V.getChildren().addAll(gokuButton, button21, button23, button2W, nameInput, nameInput2, textFieldBut, choiceBox, choiceBoxbut);
        layout2V.setSpacing(20);
        layout2V.setMaxSize(150, 300);
        GridPane.setConstraints(layout2V, 0, 1);
        
        layout2V_2.getChildren().addAll(choiceBoxAuto, comboBox,choiceBoxLabel, comboBoxLabel);
        layout2V_2.setPadding(new Insets(10,10,10,10));
        layout2V_2.setSpacing(20);
        layout2V_2.setMaxSize(300, 200);
        layout2V_2.setMinSize(300, 200);
        GridPane.setConstraints(layout2V_2, 0, 2);
        
        layout2H.getChildren().addAll(label2, windowBut, textLabel, clearBut);
        layout2H.setMinHeight(100);
        layout2H.setSpacing(40);
        layout2H.setMaxSize(400, 200);
        layout2H.setMinSize(400, 200);
        
        GridPane.setConstraints(layout2H, 1, 1);
        
        layout2H_2.getChildren().addAll(list, listLabel, listViewBut);
        layout2H_2.setSpacing(40);
        layout2H_2.setMaxSize(500, 200);
        layout2H_2.setMinSize(500, 200);
        GridPane.setConstraints(layout2H_2, 1, 2);
        
        layoutTableInput.getChildren().addAll(nameField, priceField, 
                quantityField, addtoTable, deleteFromTable);
        GridPane.setConstraints(layoutTableInput, 0, 1);
        
        layout3.getChildren().addAll(tree, treeLabel, table, layoutTableInput, button31, button32, button3W);
        layout3.setPadding(new Insets(10, 10, 10, 10));
        
        VBox binded = new VBox();
        binded.getChildren().addAll(bindLabel, bindTxt);
        
        borderPane.setCenter(layout3);
        borderPane.setTop(menuBar);
        borderPane.setBottom(menuLabel);
        borderPane.setRight(bindField);
        borderPane.setLeft(binded);
        
        browserAdressLayout.getChildren()
                    .addAll(browserAdressField, browserAdressBut, hyperlink, buttonW1, buttonW2, buttonW3 );
        
        webBrowserLayout = new BorderPane();
        webBrowserLayout.setTop(browserAdressLayout);
        webBrowserLayout.setCenter(webBrowser);
        
        
//    ================================================================================
//                                    SCENES
        
        //        numbers after selected layout are sizes of window
        scene1 = new Scene(layout1, 500, 500);
        scene2 = new Scene(layout2, 800, 650);
        scene3 = new Scene(borderPane, 900, 550);
        
//        add style sheet to scene
        scene3.getStylesheets().add("lukk.css");
        
        webBrowserScene = new Scene(webBrowserLayout, 900, 600);

        
        
//    ===============================================================================
//                                  STAGE SETTINGS
        
        mainWindow.setScene(webBrowserScene);
        mainWindow.show();
    }
    
}
