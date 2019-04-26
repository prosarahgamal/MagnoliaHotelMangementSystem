
package Manager.ManageRooms;

import DataBaseConnection.DBConnect;
import Models.Accounts;
import Models.Rooms;
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
        
        i.roomId.setCellValueFactory(new PropertyValueFactory("id"));
        i.roomType.setCellValueFactory(new PropertyValueFactory("type"));
        i.roomView.setCellValueFactory(new PropertyValueFactory("view"));
        i.isSmokable.setCellValueFactory(new PropertyValueFactory("issmokingavailable"));
        i.isReserved.setCellValueFactory(new PropertyValueFactory("isreserved"));
        i.rate.setCellValueFactory(new PropertyValueFactory("rate"));
        i.cost.setCellValueFactory(new PropertyValueFactory("costpernight"));
        i.reservationCounter.setCellValueFactory(new PropertyValueFactory("timesofreservation"));
        i.lastCheckIn.setCellValueFactory(new PropertyValueFactory("lastcheckin"));
        i.isDeactivated.setCellValueFactory(new PropertyValueFactory("isdeactivated"));
                
        DataBaseConnection.DBConnect db = new DBConnect();
        db.getAllRoom();
        
        i.table.setItems(FXCollections.observableArrayList(Main.rooms));
        
        i.addBtn.setOnAction(e -> {
            
            if(i.costTxt.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Enter the cost!");
            }else{
                Rooms room = new Rooms();
                room.setType(i.roomTypeComboBox.getValue());
                room.setView(i.roomViewComboBox.getValue());
                room.setIsSmokeingAvaliable(i.smokableCheckBox.isSelected());
                room.setIsDeactived(i.deactiveCheckBox.isSelected());
                room.setCostPerNight(Double.parseDouble(i.costTxt.getText()));
                room.setPhoto("");
                
                db.insertRoom(room);
                
                new DataBaseConnection.DBConnect().getAllRoom();
                
                i.table.setItems(FXCollections.observableArrayList(Main.rooms));
                
                i.costTxt.setText("");
                i.smokableCheckBox.setSelected(false);
                i.deactiveCheckBox.setSelected(false);
            }
            
        });
        
        i.menuView.setOnMouseClicked(e -> {
            new Manager.Menu.Control(account);
            i.primaryStage.close();
        });
        
        i.accountView.setOnMouseClicked(e -> {
            new Account.Control(account);
            i.primaryStage.close();
        });
        
        i.table.setOnMouseClicked(e -> {
            int index = i.table.getSelectionModel().getSelectedIndex();
            ObservableList<Rooms> observableList = i.table.getItems();
            Rooms room = observableList.get(index);
            
            id = room.getId();

            i.roomTypeComboBox.getSelectionModel().select(room.getType());
            i.roomViewComboBox.getSelectionModel().select(room.getView());
            Double cost = room.getCostPerNight();
            i.costTxt.setText(cost.toString());
            i.smokableCheckBox.setSelected(room.isIsSmokeingAvaliable());
            i.deactiveCheckBox.setSelected(room.isIsDeactived());
            
        });
        
        i.editBtn.setOnAction(e -> {
            if (i.costTxt.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Enter cost first!");
            }else{
                Rooms room = new Rooms();
                
                room.setId(id);
                room.setType(i.roomTypeComboBox.getValue());
                room.setView(i.roomViewComboBox.getValue());
                room.setIsSmokeingAvaliable(i.smokableCheckBox.isSelected());
                room.setIsDeactived(i.deactiveCheckBox.isSelected());
                room.setCostPerNight(Double.parseDouble(i.costTxt.getText()));
                room.setPhoto("");
                
                db.updateRoom(room);
                
                new DataBaseConnection.DBConnect().getAllRoom();
                i.table.setItems(FXCollections.observableArrayList(Main.rooms));
                
                i.costTxt.setText("");
                i.smokableCheckBox.setSelected(false);
                i.deactiveCheckBox.setSelected(false);
            }
        });

        ObservableList<Rooms> data = FXCollections.observableArrayList(i.table.getItems());
        FilteredList<Rooms> filteredList = new FilteredList<>(data, e -> true);
        
        i.searchTxt.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            filteredList.setPredicate(new Predicate<Rooms>() {
                @Override
                public boolean test(Rooms room) {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();

                    if(String.valueOf(room.getId()).toLowerCase().contains(lowerCaseFilter)){
                            return true;
                    }else if(room.getType().toLowerCase().contains(lowerCaseFilter)){
                        return true;
                    } else if (room.getView().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    }else if (String.valueOf(room.getCostPerNight()).toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    }else if (String.valueOf(room.getLastCheckinDate()).toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    }else if (String.valueOf(room.getRate()).toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    }else if (String.valueOf(room.getTimeOfReservation()).toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    }
                    
                    return false;
                }
            ;
        });
        });
        
        SortedList<Rooms> sortedlist = new SortedList<>(filteredList);
        sortedlist.comparatorProperty().bind(i.table.comparatorProperty());
        i.table.setItems(sortedlist);
        
        
        i.start();
    }
    
}
