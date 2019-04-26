
package LoginPage;

import DataBaseConnection.DBConnect;
import Start.Main;
import javax.swing.JOptionPane;


/**
 *
 * @author Sara
 */
public class Control{
    
    boolean managerFlag = false;
    boolean isFound = false;
    
    public Control(){
        
        
        
        LoginPage.Interface i = new Interface();

        

        i.manager.setOnAction(e -> {
            managerFlag = true;

            i.manager.setStyle("-fx-background-color: #ff9900;\n"
                    + "-fx-text-fill: #ffffff;");

            i.receptionist.setStyle("-fx-background-color: #ffffff;"
                    + "-fx-text-fill: #cc6633;");
        });

        i.receptionist.setOnAction(e -> {
            managerFlag = false;

            i.receptionist.setStyle("-fx-background-color: #ff9900;\n"
                    + "    -fx-text-fill: #ffffff;");

            i.manager.setStyle("-fx-background-color: #ffffff;"
                    + "-fx-text-fill: #cc6633;");

        });

        i.loginBtn.setOnAction(e -> {
            
            String username = i.usernameTxt.getText();
            String password = i.passwordTxt.getText();
            
            DataBaseConnection.DBConnect db = new DBConnect();
            db.getAccounts();

            for (int j = 0; j < Main.accounts.size(); j++) {
                if((Main.accounts.get(j).getUsername().equals(username)) && (Main.accounts.get(j).getPassword().equals(password)) && (Main.accounts.get(j).isIsManager())==managerFlag 
                        && !(Main.accounts.get(j).isIsDeactivated())){
                    isFound = true;
                    if (managerFlag){
                        
                        new Manager.Menu.Control(Main.accounts.get(j));
                        i.primaryStage.close();
                    }else{
                        new Receptionist.Menu.Control(Main.accounts.get(j));
                        i.primaryStage.close();
                    }
                }
                
//                if(!isFound){
//                    JOptionPane.showMessageDialog(null, "username or password are wrong!");
//                }
                
            }});

        i.start();
    }
    
}
