/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Receptionist.CheckIn.GuestInfo;

import Models.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Sara
 */
public class Control {
    
    Interface i = new Interface();
    
    

    public Control(Guests guest, Accounts account) {
        
        i.male.setSelected(true);
        i.statusComboBox.getSelectionModel().selectFirst();
        
        i.clearBtn.setOnAction(e -> {
            i.firstNameTxt.setText("");
            i.middleNameTxt.setText("");
            i.lastNameTxt.setText("");
            i.idTxt.setText("");
            i.emailTxt.setText("");
            i.mobileTxt.setText("");
            i.addressTxt.setText("");
            i.numOfDaysTxt.setText("");
        });
        
        i.nextBtn.setOnAction(e -> {
            
            if (i.firstNameTxt.getText().isEmpty() || i.middleNameTxt.getText().isEmpty() || i.lastNameTxt.getText().isEmpty() || i.idTxt.getText().isEmpty() ||
                    i.emailTxt.getText().isEmpty() || i.mobileTxt.getText().isEmpty() || i.addressTxt.getText().isEmpty() || i.numOfDaysTxt.getText().isEmpty()){
                
                JOptionPane.showMessageDialog(null, "you're missing data");
            }else{
                guest.setFirstname(i.firstNameTxt.getText());
                guest.setMiddlename(i.middleNameTxt.getText());
                guest.setLastname(i.lastNameTxt.getText());
                guest.setIdCard(i.idTxt.getText());
                guest.setEmail(i.emailTxt.getText());
                guest.setPhone(i.mobileTxt.getText());
                guest.setAddress(i.addressTxt.getText());
                guest.setNumOfDays(Integer.parseInt(i.numOfDaysTxt.getText()));
                guest.setGender((i.female.isSelected())? "female" : "male");
                guest.setStatus(i.statusComboBox.getValue());
                
                new Receptionist.CheckIn.AdditionalInfo.Control(guest, account);
                i.primaryStage.close();
            }
        });
        
        i.cancelBtn.setOnAction(e -> {
            new Receptionist.Menu.Control(account);
            i.primaryStage.close();
        });
        
        i.start();
    }
}
