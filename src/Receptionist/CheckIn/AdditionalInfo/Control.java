
package Receptionist.CheckIn.AdditionalInfo;

import DataBaseConnection.DBConnect;
import Models.*;

/**
 *
 * @author Sara
 */
public class Control {

    Interface i = new Interface();
    
    String[][] foodFlag = {{"1", "1"}, {"0", "2"}, {"0", "3"}};
    
    String[][] carFlag = {{"1", "1"}, {"0", "2"}, {"0", "3"}, {"0", "4"}, {"0", "5"}, {"0", "6"}, {"0", "7"}};
    
    
    public Control(Guests guest, Accounts account) {
        
        manageFood();
        manageCar();
        
        i.previousBtn.setOnAction(e -> {
            
            new Receptionist.CheckIn.GuestInfo.Control(guest, account);
            i.primaryStage.close();
            
        });
        
        i.finishBtn.setOnAction(e -> {
            
            String car = "0";
            String food = "0";

            if (i.carCheckBox.isSelected()) {
                for (int j = 0; j < carFlag.length; j++) {
                    if (carFlag[j][0] == "1") {
                        car = carFlag[j][1];
                        break;
                    }
                }
            }
            if (i.foodCheckBox.isSelected()) {
                for (int j = 0; j < foodFlag.length; j++) {
                    if (foodFlag[j][0] == "1") {
                        food = foodFlag[j][1];
                        break;
                    }
                }
            }
            
            guest.setFoodId(Long.parseLong(food));
            guest.setCarId(Long.parseLong(car));
            guest.setPrivateDriver(i.privateDriverCheckBox.isSelected());
            
            System.out.println(guest.toString());
            
            DataBaseConnection.DBConnect db = new DBConnect();
            
            db.insertGuest(guest);
            
            
            
            
        });
        
        
        i.start();
    }
    
    public void manageFood(){
        i.meal1View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 30, .1, 0, 9);");
        
        i.meal1View.setOnMouseClicked(e -> {
            for (int j = 0; j < foodFlag.length; j++) {
                
                if(j == 0){
                    foodFlag[j][0] = "1";
                }else{
                    foodFlag[j][0] = "0";
                }
            }
            i.meal1View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 30, .1, 0, 9);");
            i.meal2View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.meal3View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
        });
        
        i.meal2View.setOnMouseClicked(e -> {
            for (int j = 0; j < foodFlag.length; j++) {
                
                if(j == 1){
                    foodFlag[j][0] = "1";
                }else{
                    foodFlag[j][0] = "0";
                }
            }
            i.meal2View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 30, .1, 0, 9);");
            i.meal1View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.meal3View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
        });
        
        i.meal3View.setOnMouseClicked(e -> {
            for (int j = 0; j < foodFlag.length; j++) {
                
                if(j == 2){
                    foodFlag[j][0] = "1";
                }else{
                    foodFlag[j][0] = "0";
                }
            }
            i.meal3View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 30, .1, 0, 9);");
            i.meal2View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.meal1View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
        });
    }
    
    public void manageCar(){
        i.car1View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 30, .1, 0, 9);");
        
        i.car1View.setOnMouseClicked(e -> {
            for (int j = 0; j < carFlag.length; j++) {
                
                if(j == 0){
                    carFlag[j][0] = "1";
                }else{
                    carFlag[j][0] = "0";
                }
            }
            i.car1View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 30, .1, 0, 9);");
            i.car2View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car3View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car4View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car5View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car6View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car7View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
        });
        
        i.car2View.setOnMouseClicked(e -> {
            for (int j = 0; j < carFlag.length; j++) {
                
                if(j == 1){
                    carFlag[j][0] = "1";
                }else{
                    carFlag[j][0] = "0";
                }
            }
            i.car2View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 30, .1, 0, 9);");
            i.car1View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car3View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car4View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car5View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car6View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car7View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
        });
        
        i.car3View.setOnMouseClicked(e -> {
            for (int j = 0; j < carFlag.length; j++) {
                
                if(j == 3){
                    carFlag[j][0] = "1";
                }else{
                    carFlag[j][0] = "0";
                }
            }
            i.car3View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 30, .1, 0, 9);");
            i.car1View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car2View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car4View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car5View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car6View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car7View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
        });
        
        i.car4View.setOnMouseClicked(e -> {
            for (int j = 0; j < carFlag.length; j++) {
                
                if(j == 4){
                    carFlag[j][0] = "1";
                }else{
                    carFlag[j][0] = "0";
                }
            }
            i.car4View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 30, .1, 0, 9);");
            i.car1View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car3View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car2View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car5View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car6View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car7View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
        });
        
        i.car5View.setOnMouseClicked(e -> {
            for (int j = 0; j < carFlag.length; j++) {
                
                if(j == 5){
                    carFlag[j][0] = "1";
                }else{
                    carFlag[j][0] = "0";
                }
            }
            i.car5View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 30, .1, 0, 9);");
            i.car1View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car3View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car4View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car2View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car6View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car7View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
        });
        
        i.car6View.setOnMouseClicked(e -> {
            for (int j = 0; j < carFlag.length; j++) {
                
                if(j == 6){
                    carFlag[j][0] = "1";
                }else{
                    carFlag[j][0] = "0";
                }
            }
            i.car6View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 30, .1, 0, 9);");
            i.car1View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car3View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car4View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car5View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car2View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car7View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
        });
        
        i.car7View.setOnMouseClicked(e -> {
            for (int j = 0; j < carFlag.length; j++) {
                
                if(j == 7){
                    carFlag[j][0] = "1";
                }else{
                    carFlag[j][0] = "0";
                }
            }
            i.car7View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 30, .1, 0, 9);");
            i.car1View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car3View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car4View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car5View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car2View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
            i.car6View.setStyle("-fx-effect: dropshadow(three-pass-box, #330033, 0, 0, 0, 0);");
        });
    }
    
}
