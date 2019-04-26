
package AlertBox;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Sara
 */
public class Interface{
    
    static Button ok = new Button("OK");
    static Button cancel = new Button("CANCEL");
    
    static Image icon = new Image("/images/warning.png");
    
    static int flag;
    
    public static int display(String mess){
        
        flag = 0;
        Stage primaryStage = new Stage();
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        
        BorderPane page = new BorderPane();
        HBox btns = new HBox(30);
        
        Label message = new Label(mess);

        btns.getChildren().addAll(ok, cancel);
        btns.setPadding(new Insets(5, 0, 5, 100));
        
        ImageView iconView = new ImageView(icon);
        iconView.setFitHeight(100);
        iconView.setFitWidth(100);
        
        page.setLeft(iconView);
        page.setCenter(message);
        page.setBottom(btns);
        BorderPane.setAlignment(btns, Pos.CENTER);
        
        ok.setOnAction(e ->
        {
            flag = 1;
            primaryStage.close();
        });
        cancel.setOnAction(e -> 
        {
            flag = 0;
            primaryStage.close();           
        });
        
        Scene scene = new Scene(page, 300, 160);
        primaryStage.setTitle("WARNING");
        primaryStage.setScene(scene);
        scene.getStylesheets().add(Interface.class.getResource("/AlertBox/style.css").toExternalForm());
        primaryStage.showAndWait();
        
        return flag;
    }

}
