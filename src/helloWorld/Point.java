package helloWorld;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Point
{
    private static boolean result;
    
    /**
     * show new window with choice if add point or close it
     * 
     * @return  true for +1 point, false if no point should be displayed
     */
    public static boolean point()
    {
        result = false;
        Stage pointStage = new Stage();
        pointStage.initModality(Modality.APPLICATION_MODAL);
        pointStage.setHeight(300);
        pointStage.setWidth(300);
        
//        button which change result to true and close window returning value to main class
        Button point = new Button("+1 point");
        point.setOnAction(e-> {
            result=true;
            pointStage.close();
        });
        
        Button close = new Button("close window");
        close.setOnAction(e->pointStage.close());
        
        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(point, close);
        
        Scene scene = new Scene(layout);
                
        pointStage.setScene(scene);
        pointStage.showAndWait();
        
        return result;
    }
}
