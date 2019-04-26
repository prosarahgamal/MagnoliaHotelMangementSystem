
package Manager.ManageStaff;

import DataBaseConnection.DBConnect;
import Models.Accounts;
import Start.Main;
import java.util.function.Predicate;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author Sara
 */
public class Control {

    long id;
    
    public Control(Accounts account){
        
        Interface i = new Interface();
        
        i.UserId.setCellValueFactory(new PropertyValueFactory("id"));
        i.username.setCellValueFactory(new PropertyValueFactory("username"));
        i.password.setCellValueFactory(new PropertyValueFactory("password"));
        i.firstname.setCellValueFactory(new PropertyValueFactory("firstname"));
        i.lastname.setCellValueFactory(new PropertyValueFactory("lastname"));
        i.email.setCellValueFactory(new PropertyValueFactory("email"));
        i.phone.setCellValueFactory(new PropertyValueFactory("phone"));
        i.address.setCellValueFactory(new PropertyValueFactory("address"));
        i.bio.setCellValueFactory(new PropertyValueFactory("bio"));
        i.isManager.setCellValueFactory(new PropertyValueFactory("ismanager"));
        i.isDeactivated.setCellValueFactory(new PropertyValueFactory("isdeactivated"));
        
        DataBaseConnection.DBConnect db = new DBConnect();
        db.getAccounts();
        
        i.table.setItems(FXCollections.observableArrayList(Main.accounts));
        
        i.accountView.setOnMouseClicked(e -> {
            new Account.Control(account);
            i.primaryStage.close();
        });
        i.menuView.setOnMouseClicked(e -> {
            new Receptionist.Menu.Control(account);
            i.primaryStage.close();
        });
        
        
        i.addUserBtn.setOnAction(e -> {
            
            boolean flag = true;
        
            if (i.bioTxt.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "some fields are missing");
                flag = false;
            } else {
                for (int j = 0; j < i.infoTextFields.length; j++) {
                    if (i.infoTextFields[j].getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "some fields are missing");
                        flag = false;
                        break;
                    }
                }
            }
            
            if (flag){
                
                Accounts newAccount = new Accounts();
                
                newAccount.setUsername(i.infoTextFields[0].getText());
                newAccount.setPassword(i.infoTextFields[1].getText());
                newAccount.setFirstname(i.infoTextFields[2].getText());
                newAccount.setLastname(i.infoTextFields[3].getText());
                newAccount.setEmail(i.infoTextFields[4].getText());
                newAccount.setPhone(i.infoTextFields[5].getText());
                newAccount.setAddress(i.infoTextFields[6].getText());
                newAccount.setSalary(Double.parseDouble(i.infoTextFields[7].getText()));
                newAccount.setBio(i.bioTxt.getText());
                newAccount.setIsDeactivated(i.isManagerCK.isSelected());
                newAccount.setIsManager(i.deactive.isSelected());
                newAccount.setProfilePicture("");
                
                db.insertAccount(newAccount);
                
                new DataBaseConnection.DBConnect().getAccounts();
                
                i.table.setItems(FXCollections.observableArrayList(Main.accounts));
                
                for (int j = 0; j < i.infoTextFields.length; j++) {
                    i.infoTextFields[j].setText("");    
                }
                i.bioTxt.setText("");
                i.isManagerCK.setSelected(false);
                i.deactive.setSelected(false);
            }
        });
        
        i.deleteUserBtn.setOnAction(e -> {
            int index = i.table.getSelectionModel().getSelectedIndex();
            if (index >= 0) {

                int flag = AlertBox.Action.action("Do you really want to delete this record?");

                if (flag == 1) {

                    ObservableList<Accounts> observableList = i.table.getItems();
                    Accounts newAccount = observableList.get(index);
                    i.table.getItems().remove(index);
                    new DataBaseConnection.DBConnect().deleteAccount(newAccount.getId());
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Select a row first");
            }
        });
        
        i.table.setOnMouseClicked(e -> {
            int index = i.table.getSelectionModel().getSelectedIndex();
            ObservableList<Accounts> observableList = i.table.getItems();
            Accounts newAccount = observableList.get(index);
            
            
            String s = newAccount.getProfilePicture();
            
            id = newAccount.getId();
            
            i.infoTextFields[0].setText(newAccount.getUsername());
            i.infoTextFields[1].setText(newAccount.getPassword());
            i.infoTextFields[2].setText(newAccount.getFirstname());
            i.infoTextFields[3].setText(newAccount.getLastname());
            i.infoTextFields[4].setText(newAccount.getEmail());
            i.infoTextFields[5].setText(newAccount.getPhone());
            i.infoTextFields[6].setText(newAccount.getAddress());
            Double salary = newAccount.getSalary();
            i.infoTextFields[7].setText(salary.toString());
            i.bioTxt.setText(newAccount.getBio());
            i.isManagerCK.setSelected(newAccount.isIsManager());
            i.deactive.setSelected(newAccount.isIsDeactivated());
        });
        
        i.editUserBtn.setOnAction(e -> {
            boolean flag = true;
        
            if (i.bioTxt.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "some fields are missing");
                flag = false;
            } else {
                for (int j = 0; j < i.infoTextFields.length; j++) {
                    if (i.infoTextFields[j].getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "some fields are missing");
                        flag = false;
                        break;
                    }
                }
            }
            
            if (flag){
                
                Accounts newAccount = new Accounts();
                newAccount.setId(id);
                newAccount.setUsername(i.infoTextFields[0].getText());
                newAccount.setPassword(i.infoTextFields[1].getText());
                newAccount.setFirstname(i.infoTextFields[2].getText());
                newAccount.setLastname(i.infoTextFields[3].getText());
                newAccount.setEmail(i.infoTextFields[4].getText());
                newAccount.setPhone(i.infoTextFields[5].getText());
                newAccount.setAddress(i.infoTextFields[6].getText());
                newAccount.setSalary(Double.parseDouble(i.infoTextFields[7].getText()));
                newAccount.setBio(i.bioTxt.getText());
                newAccount.setIsDeactivated(i.isManagerCK.isSelected());
                newAccount.setIsManager(i.deactive.isSelected());
                newAccount.setProfilePicture("");
                
                db.updateAccount(newAccount);
                
                
                new DataBaseConnection.DBConnect().getAccounts();
                
                i.table.setItems(FXCollections.observableArrayList(Main.accounts));
                
                for (int j = 0; j < i.infoTextFields.length; j++) {
                    i.infoTextFields[j].setText("");    
                }
                i.bioTxt.setText("");
                i.isManagerCK.setSelected(false);
                i.deactive.setSelected(false);
            }
        });
        
        ObservableList<Accounts> data = FXCollections.observableArrayList(i.table.getItems());
        FilteredList<Accounts> filteredList = new FilteredList<>(data, e -> true);
        
        i.searchTxt.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            filteredList.setPredicate(new Predicate<Accounts>() {
                @Override
                public boolean test(Accounts account) {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();

                    if (String.valueOf(account.getId()).toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (account.getUsername().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (account.getPassword().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (account.getFirstname().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (account.getLastname().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (account.getEmail().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (account.getAddress().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (account.getPhone().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (account.getBio().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (String.valueOf(account.getSalary()).toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    }
                    return false;
                }
            ;
        });
        });
        
        SortedList<Accounts> sortedlist = new SortedList<>(filteredList);
        sortedlist.comparatorProperty().bind(i.table.comparatorProperty());
        i.table.setItems(sortedlist);
        
        i.start();
    }
    
}
