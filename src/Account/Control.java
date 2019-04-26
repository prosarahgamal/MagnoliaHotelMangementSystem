
package Account;

import DataBaseConnection.DBConnect;
import Models.Accounts;
import javafx.scene.image.Image;

/**
 *
 * @author Sara
 */
public class Control {
    
    
    public Control(Accounts account){
        
        Account.Interface i = new Interface();
        
        Double salary = account.getSalary();
        
        try{
        System.out.println(account.getProfilePicture());

        i.profilePicture = new Image(account.getProfilePicture()); 
        }catch(Exception e){
            
        }
        i.name = account.getFirstname() + " " + account.getLastname();
        i.name.toUpperCase();
        
        i.infoTextFields[0].setText(account.getEmail());
        i.infoTextFields[1].setText(account.getPhone());
        i.infoTextFields[2].setText(account.getAddress());
        i.infoTextFields[3].setText(salary.toString());
        i.bioTxt.setText(account.getBio());
        
        i.editProfileBtn.setOnAction(e ->{
            for (int j = 0; j < i.infoTextFields.length; j++) {
                if(j != 3){
                    
                    i.infoTextFields[j].setEditable(true);
                    i.infoTextFields[j].setStyle("-fx-background-color: #ffffff;");
                }
            }
            i.bioTxt.setEditable(true);
            i.bioTxt.setStyle("-fx-background-color: #ffffff;");
            i.submitEdit.setVisible(true);
        });
        
        
        i.submitEdit.setOnAction(e -> {
            Accounts newAccount = new Accounts();
            
            newAccount.setId(account.getId());
            newAccount.setUsername(account.getUsername());
            newAccount.setPassword(account.getPassword());
            newAccount.setFirstname(account.getFirstname());
            newAccount.setLastname(account.getLastname());
            newAccount.setEmail(i.infoTextFields[0].getText());
            newAccount.setPhone(i.infoTextFields[1].getText());
            newAccount.setAddress(i.infoTextFields[2].getText());
            newAccount.setSalary(account.getSalary());
            newAccount.setIsManager(account.isIsManager());
            newAccount.setBio(i.bioTxt.getText());
            newAccount.setProfilePicture(account.getProfilePicture());
            newAccount.setIsDeactivated(account.isIsDeactivated());
            
            DataBaseConnection.DBConnect db = new DBConnect();
            db.updateAccount(newAccount);
            
            
            for (int j = 0; j < i.infoTextFields.length; j++) {
                if(j != 3){
                    
                    i.infoTextFields[j].setEditable(false);
                    i.infoTextFields[j].setStyle("-fx-background-color: rgba(0, 0, 0 ,0);");
                }
            }
            i.bioTxt.setEditable(false);
            i.bioTxt.setStyle("-fx-background-color: rgba(0, 0, 0 ,0);");
            i.submitEdit.setVisible(false);
            
            
        });
        
        i.menuView.setOnMouseClicked(e -> {
            if(account.isIsManager()){
                new Manager.Menu.Control(account);
            }else{
                new Receptionist.Menu.Control(account);
            }
        });
        
        i.start();
    }
}
