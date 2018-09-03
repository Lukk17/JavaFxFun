package helloWorld;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Confirm
{
    static boolean result;

    /**
     * 
     * @param ConfirmText   - string which will be displayed as label text
     * 
     * @return  true if user is sure to do thing, 
     *          false if he doesn't want to do action anymore
     */
    public static boolean confirmation(String ConfirmText)
    {

        Stage confirm = new Stage();
        confirm.initModality(Modality.APPLICATION_MODAL);
        confirm.setTitle("Confirm");
        confirm.setMinWidth(200);
        confirm.setMinHeight(100);

        Label label = new Label();
        label.setText(ConfirmText);

//        buttons which change returning value and close pop uped window
        Button yesBut = new Button("Yes");
        yesBut.setOnAction(e ->
        {
            result = true;
            confirm.close();

        });
        Button noBut = new Button("No");
        noBut.setOnAction(e ->
        {
            result = false;
            confirm.close();
        });

        VBox layout = new VBox(10);
        
        layout.getChildren().addAll(label, yesBut, noBut);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(layout, 100, 100);

        confirm.setScene(scene);
        confirm.showAndWait();

        return result;
    }
}
