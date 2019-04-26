
package Receptionist.CheckOut.Bill;

import DataBaseConnection.DBConnect;
import Models.*;
import Start.Main;

/**
 *
 * @author Sara
 */
public class Control {
    
    Interface i = new Interface();

    public Control(Guests guest, Accounts account) {
        
        DataBaseConnection.DBConnect db = new DBConnect();
        
        db.getBillInfo(guest);
        
        i.billInfo[0].setText(guest.getFirstname()+ " " + guest.getMiddlename() + " " + guest.getLastname());
        i.billInfo[1].setText(guest.getAddress());
        i.billInfo[2].setText(guest.getPhone());
        i.billInfo[3].setText(Long.toString(guest.getRoomId()));
        i.billInfo[4].setText(Main.rooms.get(0).getType());
        i.billInfo[5].setText(Double.toString(Main.rooms.get(0).getCostPerNight()));
        i.billInfo[6].setText(guest.getArriveDate().toString());
        i.billInfo[7].setText(guest.getCheckoutDate().toString());
        i.billInfo[8].setText(Main.food.get(0).getType());
        i.billInfo[9].setText(Double.toString(Main.food.get(0).getCost()));
        i.billInfo[10].setText(Main.cars.get(0).getType());
        i.billInfo[11].setText(Double.toString(Main.cars.get(0).getCost()));
        
        double cost = guest.getNumOfDays() * (Main.rooms.get(0).getCostPerNight() + Main.food.get(0).getCost() + Main.cars.get(0).getCost());
        
        i.billInfo[12].setText(Double.toString(cost));
        i.billInfo[13].setText(account.getFirstname() + " " + account.getLastname());
        
        System.out.println(i.billInfo[0].getText());
        

        i.start();
        
    }
    
    
    
}
