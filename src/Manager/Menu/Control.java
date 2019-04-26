
package Manager.Menu;

import Models.Accounts;

/**
 *
 * @author Sara
 */
public class Control {
    
    public Control(Accounts account){
        
        Interface i = new Interface();
        
        i.manageRoomsBtn.setOnAction(e -> {
            new Manager.ManageRooms.Control(account);
            i.primaryStage.close();
        });
        
        i.manageStaffBtn.setOnAction(e -> {
            new Manager.ManageStaff.Control(account);
            i.primaryStage.close();
        });

        
        i.accountBtn.setOnAction(e -> {
            new Account.Control(account);
            i.primaryStage.close();
        });
        
        i.logoutBtn.setOnAction(e -> {
        
            new LoginPage.Control();
            i.primaryStage.close();
    });
        
        i.start();
    }
    
}
