package helloWorld;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TreeItem;

import static helloWorld.Main.*;

public class AdditionalMethods
{

/**
 * 
 * @param choiceBox - selected item from {@link ChoiceBox}
 * 
 * @return  String with value of selected {@link ChoiceBox} option
 */
    protected static String selectItem(ChoiceBox<String> choiceBox)
    {
        return choiceBox.getValue();
    }

    
/**
 * 
 * @param box1  - first {@link CheckBox} 
 * @param box2  - second {@link CheckBox}
 * 
 * @return  string of selected checkboxes
 */
    protected static String handleOption(CheckBox box1, CheckBox box2)
    {
        String result = "";
        
        if(box1.isSelected())
        {
            result+= box1.getText() + " ";
        }
        
        if(box2.isSelected())
        {
            result+= box2.getText();
        }
        
        return result;
        
    }

    /**
     * 
     * Run confirmation pop up before closing program
     */
    
    protected static void closeProgram()
    {
        Boolean answer = false;
        answer = Confirm.confirmation("Sure to close app?");
        if (answer) mainWindow.close();
    }
    
    /**
     * 
     * @param title     - title of new branch
     * @param parent    - parent of created branch
     * 
     * @return          - return new branch
     */
    protected static TreeItem<String> makeBranch(String title, TreeItem<String> parent)
    {
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }
    
    /**
     * 
     * Add products from inputs to table
     * Clear input fields
     */
    protected static void addToTable()
    {
        Product product = new Product();
        product.setName(nameField.getText());
        product.setPrice(Double.parseDouble(priceField.getText()));
        product.setQuantity(Integer.parseInt(quantityField.getText()));
        
        table.getItems().add(product);
        
        nameField.clear();
        priceField.clear();
        quantityField.clear();
    }
    
    /**
     * 
     * Delete selected item from table
     */
    protected static void deleteFromTable()
    {
        ObservableList<Product> allProducts, selectedProduct;
        
        allProducts = table.getItems();
        selectedProduct = table.getSelectionModel().getSelectedItems();
        
        
                for(Product p : selectedProduct)
                {
//                    allProducts.remove(p);
                    table.getItems().remove(p);
                }
           
//        selectedProduct.forEach(allProducts::remove);
                
    }
    
    
    /**
     * 
     * Add products into list
     * 
     * @return  - observableList of products
     */
    protected static ObservableList<Product> addProducts()
    {
        ObservableList<Product> productsList = FXCollections.observableArrayList();
        productsList.add(new Product("apple", 1, 10));
        productsList.add(new Product("banana", 1.5, 20));
        productsList.add(new Product("steak", 15, 100));
        productsList.add(new Product("cheese", 7, 20));
        
        return productsList;
    }

}
