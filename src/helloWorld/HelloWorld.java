package helloWorld;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class HelloWorld 
{
    /**
     * method will display a window with label and close button
     * 
     * @param title - it will be title of window
     * 
     * @param msg   - it will be label text
     */
    public static void display(String title, String msg)
    {
        
        Stage helloStage = new Stage();
        
//      Block previous window
        helloStage.initModality(Modality.APPLICATION_MODAL);
        helloStage.setTitle(title);
        helloStage.setHeight(300);
        helloStage.setWidth(300);
        
        Label label = new Label();
        label.setText(msg);
        
        Button closebutton = new Button("close this windowwww");
        closebutton.setOnAction(e-> helloStage.close());
        
        VBox layout = new VBox(10);
        layout.getChildren().addAll(closebutton,label);
        layout.setAlignment(Pos.BOTTOM_CENTER);
        
        Scene scene = new Scene(layout);
        helloStage.setScene(scene);
        helloStage.showAndWait();
        
    }
}
