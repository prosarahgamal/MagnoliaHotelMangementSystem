
package Receptionist.CheckOut.ChooseGuest;

import DataBaseConnection.DBConnect;
import Models.*;
import Start.Main;
import java.sql.Date;
import java.time.LocalDate;
import java.util.function.Predicate;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Sara
 */
public class Control {
    
    Interface i = new Interface();
    boolean flag = false;
    Guests  guest;

    public Control(Accounts account) {
        
        i.id.setCellValueFactory(new PropertyValueFactory("id"));
        i.roomid.setCellValueFactory(new PropertyValueFactory("roomid"));
        i.firstName.setCellValueFactory(new PropertyValueFactory("firstname"));
        i.middleName.setCellValueFactory(new PropertyValueFactory("middlename"));
        i.lastName.setCellValueFactory(new PropertyValueFactory("lastname"));
        i.idcard.setCellValueFactory(new PropertyValueFactory("idcard"));
        i.numOfDays.setCellValueFactory(new PropertyValueFactory("numofdays"));
        i.gender.setCellValueFactory(new PropertyValueFactory("gender"));
        i.email.setCellValueFactory(new PropertyValueFactory("email"));
        i.phone.setCellValueFactory(new PropertyValueFactory("phone"));
        i.status.setCellValueFactory(new PropertyValueFactory("status"));
        i.address.setCellValueFactory(new PropertyValueFactory("address"));
        i.arriveDate.setCellValueFactory(new PropertyValueFactory("arrivedate"));
        i.checkoutdate.setCellValueFactory(new PropertyValueFactory("checkoutdate"));
        i.foodid.setCellValueFactory(new PropertyValueFactory("foodid"));
        i.carid.setCellValueFactory(new PropertyValueFactory("carid"));
        i.privatedriver.setCellValueFactory(new PropertyValueFactory("privatedriver"));
        
        DataBaseConnection.DBConnect db = new DBConnect();
        
        db.getAllGuests();
        
        i.table.setItems(FXCollections.observableArrayList(Main.guests));
        
        ObservableList<Guests> data = FXCollections.observableArrayList(i.table.getItems());
        FilteredList<Guests> filteredList = new FilteredList<>(data, e -> true);
        
        i.searchTxt.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            filteredList.setPredicate(new Predicate<Guests>() {
                @Override
                public boolean test(Guests guest) {
                    // If filter text is empty, display all Users.
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();

                    if (String.valueOf(guest.getId()).toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (String.valueOf(guest.getRoomId()).toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (guest.getFirstname().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (guest.getMiddlename().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (guest.getLastname().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (guest.getIdCard().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (guest.getGender().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (guest.getPhone().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (guest.getStatus().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (String.valueOf(guest.getArriveDate()).toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (String.valueOf(guest.getArriveDate()).toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    }
                    return false;
                }
            ;
        });
        });
        SortedList<Guests> sortedlist = new SortedList<>(filteredList);
        sortedlist.comparatorProperty().bind(i.table.comparatorProperty());
        i.table.setItems(sortedlist);
        
        i.table.setOnMouseClicked(e -> {
            flag = true;
            int index = i.table.getSelectionModel().getSelectedIndex();
            ObservableList<Guests> observableList = i.table.getItems();
            guest = observableList.get(index);
        });

        i.checkOut.setOnAction((ActionEvent e) -> 
        {
            if (true) {
                int flag = AlertBox.Interface.display("Do you really want to check out?");
                if (flag == 1) {
                    
                    guest.setCheckoutDate(Date.valueOf(LocalDate.now()));
                    
                    db.updateGuest(guest);
                    
                    new Receptionist.CheckOut.Bill.Control(guest, account);
                    
                }
            }
        });
        
        i.accountView.setOnMouseClicked(e -> {
            new Account.Control(account);
            i.primaryStage.close();
        });
        
        i.menuView.setOnMouseClicked(e -> {
            new Receptionist.Menu.Control(account);
            i.primaryStage.close();
        });
        
        i.start();
    }
    
    
    
}
