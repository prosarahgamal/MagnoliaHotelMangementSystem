
package Receptionist.CheckIn.RoomInfo;

import Models.*;
import java.sql.Date;
import java.time.LocalDate;
import javafx.event.EventHandler;
import javafx.scene.AccessibleAttribute;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Sara
 */
public class Control {
    
    Interface i = new Interface();
    String[][] typesFlag = {{"1", "single"},{"0", "double"},{"0", "triple"},{"0", "quad"},{"0", "queen"},{"0", "king"},{"0", "studio"}};    
    String[][] viewFlag = {{"1", "green"}, {"0", "blue"}};
    boolean isSmoking = false;
    
    final ImageView v0 = i.roomTypesViews[0];
    final ImageView v1 = i.roomTypesViews[1];
    final ImageView v2 = i.roomTypesViews[2];
    final ImageView v3 = i.roomTypesViews[3];
    final ImageView v4 = i.roomTypesViews[4];
    final ImageView v5 = i.roomTypesViews[5];
    final ImageView v6 = i.roomTypesViews[6];
    
    final ImageView g0 = i.roomViews[0];
    final ImageView g1 = i.roomViews[1];
    
    final ImageView c0 = i.smokeView[0];
    final ImageView c1 = i.smokeView[1];
    
    public Control(Accounts account){
        
        i.dateTxt.setValue(LocalDate.now());
        
        manageTypes();
        manageViews();
        manageSmokeing();
        
        i.accountView.setOnMouseClicked(e -> {
            
            new Account.Control(account);
            i.primaryStage.close();
        });
        
        i.menuView.setOnMouseClicked(e -> {
            
            new Receptionist.Menu.Control(account);
            i.primaryStage.close();
        });
        
        i.getRoom.setOnAction(e -> {

            String type = "single";
            String view = "green";

            for (int j = 0; j < typesFlag.length; j++) {
                if (typesFlag[j][0] == "1") {
                    type = typesFlag[j][1];
                    break;
                }
            }

            for (int j = 0; j < viewFlag.length; j++) {
                if (viewFlag[j][0] == "1") {
                    view = viewFlag[j][1];
                    break;
                }
            }

            Rooms room = new Rooms();

            room.setIsReserved(false);
            room.setIsDeactived(false);
            room.setIsSmokeingAvaliable(isSmoking);
            room.setType(type);
            room.setView(view);

            Guests guest = new Guests();

            guest.setArriveDate(Date.valueOf(i.dateTxt.getValue()));

            new Receptionist.CheckIn.RoomPicker.Control(room, guest, account);
            i.primaryStage.close();

        });
        
        i.accountView.setOnMouseClicked(e -> {
            new Account.Control(account);
            i.primaryStage.close();
        });
        
        i.menuView.setOnMouseClicked(e -> {
            new Receptionist.Menu.Control(account);
        });
        
        i.start();
    }
    
    public void manageTypes(){
        
        v0.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 30, .1, 0, 9);");
        
        v0.setOnMouseClicked(e -> {
            for (int j = 0; j < typesFlag.length; j++) {
                
                if(j == 0){
                    typesFlag[j][0] = "1";
                }else{
                    typesFlag[j][0] = "0";
                }
            }
            v0.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 30, .1, 0, 9);");
            v1.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v2.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v3.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v4.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v5.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v6.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
        });
        
        v1.setOnMouseClicked(e -> {
            for (int j = 0; j < typesFlag.length; j++) {
                
                if(j == 1){
                    typesFlag[j][0] = "1";
                }else{
                    typesFlag[j][0] = "0";
                }
            }
            v1.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 30, .1, 0, 9);");
            
            v0.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v6.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v2.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v3.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v4.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v5.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
        });
        
        v2.setOnMouseClicked(e -> {
            for (int j = 0; j < typesFlag.length; j++) {
                
                if(j == 2){
                    typesFlag[j][0] = "1";
                }else{
                    typesFlag[j][0] = "0";
                }
            }
            v2.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 30, .1, 0, 9);");
            
            v0.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v6.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v1.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v3.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v4.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v5.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
        });
        
        v3.setOnMouseClicked(e -> {
            for (int j = 0; j < typesFlag.length; j++) {
                
                if(j == 3){
                    typesFlag[j][0] = "1";
                }else{
                    typesFlag[j][0] = "0";
                }
            }
            v3.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 30, .1, 0, 9);");
            
            v0.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v6.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v2.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v1.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v4.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v5.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
        });
        
        v4.setOnMouseClicked(e -> {
            for (int j = 0; j < typesFlag.length; j++) {
                
                if(j == 4){
                    typesFlag[j][0] = "1";
                }else{
                    typesFlag[j][0] = "0";
                }
            }
            v4.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 30, .1, 0, 9);");
            
            v0.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v6.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v2.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v3.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v1.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v5.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
        });
        
        v5.setOnMouseClicked(e -> {
            for (int j = 0; j < typesFlag.length; j++) {
                
                if(j == 5){
                    typesFlag[j][0] = "1";
                }else{
                    typesFlag[j][0] = "0";
                }
            }
            v5.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 30, .1, 0, 9);");
            
            v0.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v6.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v2.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v3.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v4.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v1.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
        });
        
        v6.setOnMouseClicked(e -> {
            for (int j = 0; j < typesFlag.length; j++) {
                
                if(j == 6){
                    typesFlag[j][0] = "1";
                }else{
                    typesFlag[j][0] = "0";
                }
            }
            v6.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 30, .1, 0, 9);");
            
            v0.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v1.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v2.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v3.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v4.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            v5.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
        });
    }
    
    public void manageViews(){
        
        g0.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 30, .1, 0, 9);");
        
        g0.setOnMouseClicked(e -> {
            viewFlag[0][0] = "1";
            viewFlag[1][0] = "0";
            
            g0.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 30, .1, 0, 9);");
            g1.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
        });
        
        g1.setOnMouseClicked(e -> {
            viewFlag[0][0] = "0";
            viewFlag[1][0] = "1";
            
            g1.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 30, .1, 0, 9);");
            g0.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
        });
        
    }
    
    public void manageSmokeing(){
        
        c0.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 30, .1, 0, 9);");
        
        c0.setOnMouseClicked(e -> {
            isSmoking = false;
            
            c0.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 30, .1, 0, 9);");
            c1.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
        });
        
        c1.setOnMouseClicked(e -> {
            isSmoking = true;
            
            c1.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 30, .1, 0, 9);");
            c0.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
        });
    }
    
}
