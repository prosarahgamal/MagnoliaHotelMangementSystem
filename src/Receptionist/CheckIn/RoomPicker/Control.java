
package Receptionist.CheckIn.RoomPicker;

import DataBaseConnection.DBConnect;
import Models.*;
import Start.Main;

/**
 *
 * @author Sara
 */
public class Control {
    
    Interface i = new Interface();
    int index = 0;
    
    public Control(Rooms room, Guests guest, Accounts account){
        
        DataBaseConnection.DBConnect db = new DBConnect();
        
        db.getAvaRooms(room);
        
        
        guest.setRoomId(Main.rooms.get(index).getId()); 
        
        i.data[0].setText(Main.rooms.get(index).getType());
        i.data[1].setText(Main.rooms.get(index).getView());
        i.data[2].setText((Main.rooms.get(index).isIsSmokeingAvaliable())? "Available" : "not Available");
        i.data[3].setText(Double.toString(Main.rooms.get(index).getCostPerNight()));
        i.data[4].setText(Long.toString(Main.rooms.get(index).getTimeOfReservation()));
        i.data[5].setText((Main.rooms.get(index).getLastCheckinDate() == null)? "" : Main.rooms.get(index).getLastCheckinDate().toString());
        
        i.leftArrowView.setOnMouseClicked(e -> {
            if (index == 0) {
                
            } else {
                index--;
                i.data[0].setText(Main.rooms.get(index).getType());
                i.data[1].setText(Main.rooms.get(index).getView());
                i.data[2].setText((Main.rooms.get(index).isIsSmokeingAvaliable()) ? "Available" : "not Available");
                i.data[3].setText(Double.toString(Main.rooms.get(index).getCostPerNight()));
                i.data[4].setText(Long.toString(Main.rooms.get(index).getTimeOfReservation()));
                i.data[5].setText((Main.rooms.get(index).getLastCheckinDate() == null)? "" : Main.rooms.get(index).getLastCheckinDate().toString());
                
                guest.setRoomId(Main.rooms.get(index).getId()); 
            }
        });

        i.rightArrowView.setOnMouseClicked(e -> {
            if (index == Main.rooms.size()-1) {

            } else {
                index++;
                i.data[0].setText(Main.rooms.get(index).getType());
                i.data[1].setText(Main.rooms.get(index).getView());
                i.data[2].setText((Main.rooms.get(index).isIsSmokeingAvaliable()) ? "Available" : "not Available");
                i.data[3].setText(Double.toString(Main.rooms.get(index).getCostPerNight()));
                i.data[4].setText(Long.toString(Main.rooms.get(index).getTimeOfReservation()));
                i.data[5].setText((Main.rooms.get(index).getLastCheckinDate() == null)? "" : Main.rooms.get(index).getLastCheckinDate().toString());
                
                guest.setRoomId(Main.rooms.get(index).getId()); 
            }
        });
        
        i.takeIt.setOnAction(e -> {
            new Receptionist.CheckIn.GuestInfo.Control(guest, account);
            i.primaryStage.close();
        });
        
        i.backArrowView.setOnMouseClicked(e -> {
            new Receptionist.CheckIn.RoomInfo.Control(account);
            i.primaryStage.close();
        });
        
        
        
        i.start();
    }
    
}
