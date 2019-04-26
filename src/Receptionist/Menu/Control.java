
package Receptionist.Menu;

import Models.*;

/**
 *
 * @author Sara
 */
public class Control {
    
    public Control(Accounts account){
        
        Interface i = new Interface();
        
        i.checkinBtn.setOnAction(e -> {
            new Receptionist.CheckIn.RoomInfo.Control(account);
            i.primaryStage.close();
        });
        
        i.checkOutBtn.setOnAction(e -> {
            new Receptionist.CheckOut.ChooseGuest.Control(account);
            i.primaryStage.close();
        });
        
        i.updateBtn.setOnAction(e -> {
            new Receptionist.Update.Interface().start();
            i.primaryStage.close();
        });
        
        i.accountBtn.setOnAction(e -> {
            new Account.Control(account);
            i.primaryStage.close();
        });
        
        i.logoutBtn.setOnAction(e -> {
            new LoginPage.Control();
        });
        
        
        i.start();
        
    }
    
}
