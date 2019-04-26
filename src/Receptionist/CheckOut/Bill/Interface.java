
package Receptionist.CheckOut.Bill;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Sara
 */
public class Interface {

    Stage primaryStage;
    static Label [] billLbls = new Label[14];
    Label [] billInfo = new Label[14];

    public Interface() {
        
        primaryStage = new Stage();
        
        billLbls[0] = new Label("Room Boarded By");
        billLbls[1] = new Label("Address");
        billLbls[2] = new Label("Mobile");
        billLbls[3] = new Label("Room ID");
        billLbls[4] = new Label("Room Type");
        billLbls[5] = new Label("Room Cost");
        billLbls[6] = new Label("CheckIn Time");
        billLbls[7] = new Label("CheckOut Time");
        billLbls[8] = new Label("Food Service");
        billLbls[9] = new Label("Food Cost");
        billLbls[10] = new Label("Car Service");
        billLbls[11] = new Label("Car Cost");
        billLbls[12] = new Label("Total");
        billLbls[13] = new Label("Receptionist");
        
        for (int i = 0; i < billInfo.length; i++) {
            
            billInfo[i] = new Label("");
        }
        
    }
    
    
    
    public void start() {
        
        
        
        HBox bill = new HBox(20);
        VBox lbls = new VBox(30);
        VBox info = new VBox(30);
        
        
        
        for (int i = 0; i < billLbls.length ; i++) {
            lbls.getChildren().add(billLbls[i]);
        }
        
        for (int i = 0; i < billInfo.length ; i++) {
            info.getChildren().add(billInfo[i]);
        }
        
        billLbls[13].setPadding(new Insets(50, 0, 0, 0));
        billInfo[13].setPadding(new Insets(50, 0, 0, 0));
        
        bill.getChildren().addAll(lbls, info);
        bill.setPadding(new Insets(20));
        
        
        
        Scene scene = new Scene(bill, 500, 900);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Bill");
        scene.getStylesheets().add(Interface.class.getResource("/Receptionist/CheckOut/Bill/style.css").toExternalForm());
        primaryStage.show();
                
    }
}
