package DataBaseConnection;


import Start.Main;
import Models.*;
import java.sql.*;



/**
 *
 * @author Sara
 */
public class DBConnect {
    
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    
    String conUrl = "jdbc:mysql://localhost/magnoliahotel?zeroDateTimeBehavior=convertToNull&autoReconnect=true&characterEncoding=UTF-8&characterSetResults=UTF-8";
    
    public Connection openConnection(){
        
        try {
            connection = DriverManager.getConnection(conUrl, "root", "");
            
        } catch (SQLException e) {
            
        }
        
        return connection;
    }
    
    public void getAccounts(){
        
        Main.accounts.clear();
        
        try {
            String query = "SELECT * FROM `accounts`";
            statement = openConnection().createStatement();
            resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                
                Accounts account = new Accounts();
                
                account.setId(resultSet.getLong(1));
                account.setUsername(resultSet.getString(2));
                account.setPassword(resultSet.getString(3));
                account.setFirstname(resultSet.getString(4));
                account.setLastname(resultSet.getString(5));
                account.setEmail(resultSet.getString(6));
                account.setPhone(resultSet.getString(7));
                account.setAddress(resultSet.getString(8));
                account.setSalary(resultSet.getDouble(9));
                account.setIsManager(resultSet.getBoolean(10));
                account.setBio(resultSet.getString(11));
                account.setProfilePicture(resultSet.getString(12));
                account.setIsDeactivated(resultSet.getBoolean(13));
                
                
                Main.accounts.add(account);
            }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public boolean insertAccount (Accounts account){
        
        try {
            
            int isManagerFlag = (account.isIsManager()? 1:0);
            int isDeactiveFlag = (account.isIsDeactivated()? 1: 0);
            
            String query = "INSERT INTO `accounts`(`username`, `password`, `firstname`, `lastname`, `email`, `phone`, `address`, `salary`, `ismanager`, `bio`, `profilepicture` , `isdeactivated`)"+ 
            "VALUES ('"+ account.getUsername() +"' , '"+ account.getPassword() +"' , '"+account.getFirstname()+ "' , '"+account.getLastname()+"' , '"+account.getEmail()+
                    "' , '"+account.getPhone()+"' , '"+account.getAddress()+"' , '"+account.getSalary()+"' , "+isManagerFlag+",'"+account.getBio()+"','"+account.getProfilePicture()+"' , "+ 
                    isDeactiveFlag +" );";

            
            statement = openConnection().createStatement();
            statement.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean updateAccount(Accounts account){
        try {
            
            int isManagerFlag = (account.isIsManager())? 1:0;
            int isDeactivatedFlag = (account.isIsDeactivated()) ? 1 : 0;
            
            String query ="UPDATE `accounts` SET `password` = '"+account.getPassword()+"' , `firstname` = '"+account.getFirstname()+
                    "' , `lastname` = '"+account.getLastname()+"' , `email` = '"+account.getEmail()+"' , "
                    + "`phone` = '"+account.getPhone()+"' , `address` = '"+account.getAddress()+"' , `salary` = '"+account.getSalary()+"' , `ismanager` = "+isManagerFlag+
                    " , `bio` = '"+account.getBio()+"' , `isdeactivated` = " +isDeactivatedFlag
                    + " WHERE `id` = "+ account.getId() + " ;";
            
            
            statement = openConnection().createStatement();
            statement.executeUpdate(query);
            
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public boolean deleteAccount (long id){
        try {
            
            String query = "DELETE FROM `accounts` WHERE `id` = " + id + " ;";
            
            statement = openConnection().createStatement();
            statement.executeUpdate(query);
            
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public void getAllRoom(){
        Main.rooms.clear();
        
        try {
            String query = "SELECT * FROM `rooms`";
            statement = openConnection().createStatement();
            resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                
                Rooms room = new Rooms();
                room.setId(resultSet.getInt(1));
                room.setType(resultSet.getString(2));
                room.setView(resultSet.getString(3));
                room.setIsSmokeingAvaliable(resultSet.getBoolean(4));
                room.setRate(resultSet.getDouble(5));
                room.setIsReserved(resultSet.getBoolean(6));
                room.setCostPerNight(resultSet.getDouble(7));
                room.setTimeOfReservation(resultSet.getLong(8));
                room.setLastCheckinDate(resultSet.getDate(9));
                room.setPhoto(resultSet.getString(10));
                room.setIsDeactived(resultSet.getBoolean(11));

                Main.rooms.add(room);

            }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean insertRoom(Rooms room){
        
        try {
            
            int issmoking = (room.isIsSmokeingAvaliable()? 1:0);
            int isReserved = (room.isIsReserved()? 1: 0);
            
            String query = "INSERT INTO `rooms`(`type`, `view`, `issmokingavailable`, `isreserved`, `rate`, `costpernight`, `timesofreservation`, `lastcheckin`, `photo`)" + 
                    " VALUES ( '"+ room.getType() +"' , '"+room.getView()+"' , "+issmoking+" , "+isReserved+" ,"+ room.getRate() +","+ room.getCostPerNight() +", "+ room.getTimeOfReservation()
                    +" , "+ room.getLastCheckinDate() +" , '"+ room.getPhoto() +"' )";
            
            
            statement = openConnection().createStatement();
            statement.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
        
    }
    
    public boolean updateRoom(Rooms room){
        try {
            
            int isSmoking = (room.isIsSmokeingAvaliable())? 1:0;
            int isReserved = (room.isIsReserved()) ? 1 : 0;
            int isDeactive = (room.isIsDeactived()) ? 1 : 0;
            
            String query ="UPDATE `rooms` SET `type`= '"+room.getType()+"' , `view`= '"+room.getView()+"' , `issmokingavailable`="+isSmoking+", `isreserved`="+isReserved+
                    ", `rate`="+room.getRate()+", `costpernight`="+room.getCostPerNight()+", `timesofreservation`="+room.getTimeOfReservation()+
                    ", `lastcheckin`= "+room.getLastCheckinDate()+" , `photo`= '"+room.getPhoto()+"' , `isdeactivated`= "+isDeactive+" WHERE `id`= "+ room.getId() +" ;";

            statement = openConnection().createStatement();
            statement.executeUpdate(query);
            
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public void getAvaRooms(Rooms room){
        Main.rooms.clear();
        
        int smoking = (room.isIsSmokeingAvaliable()? 1 : 0);
        
        try {
            String query = "SELECT * FROM `rooms` WHERE `type` = '"+ room.getType() +"' AND `view` = '"+ room.getView() +"' AND `issmokingavailable` = "+ smoking +
                    " AND `isreserved` = "+ 0 +" AND `isdeactivated` = "+ 0 +" ;";
            statement = openConnection().createStatement();

            
            resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                
                Rooms avaRoom = new Rooms();
                avaRoom.setId(resultSet.getInt(1));
                avaRoom.setType(resultSet.getString(2));
                avaRoom.setView(resultSet.getString(3));
                avaRoom.setIsSmokeingAvaliable(resultSet.getBoolean(4));
                avaRoom.setRate(resultSet.getDouble(5));
                avaRoom.setIsReserved(resultSet.getBoolean(6));
                avaRoom.setCostPerNight(resultSet.getDouble(7));
                avaRoom.setTimeOfReservation(resultSet.getLong(8));
                avaRoom.setLastCheckinDate(resultSet.getDate(9));
                avaRoom.setPhoto(resultSet.getString(10));
                avaRoom.setIsDeactived(resultSet.getBoolean(11));

                Main.rooms.add(avaRoom);

            }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void getAllGuests(){
        Main.guests.clear();
        
        try {
            String query = "SELECT * FROM `guests`";
            statement = openConnection().createStatement();
            resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                
                Guests guest = new Guests();
                
                guest.setId(resultSet.getInt(1));
                guest.setRoomId(resultSet.getInt(2));
                guest.setFirstname(resultSet.getString(3));
                guest.setMiddlename(resultSet.getString(4));
                guest.setLastname(resultSet.getString(5));
                guest.setIdCard(resultSet.getString(6));
                guest.setNumOfDays(resultSet.getInt(7));
                guest.setGender(resultSet.getString(8));
                guest.setEmail(resultSet.getString(9));
                guest.setPhone(resultSet.getString(10));
                guest.setStatus(resultSet.getString(11));
                guest.setAddress(resultSet.getString(12));
                guest.setArriveDate(resultSet.getDate(13));
                guest.setCheckoutDate(resultSet.getDate(14));
                guest.setFoodId(resultSet.getInt(15));
                guest.setCarId(resultSet.getInt(16));
                guest.setPrivateDriver(resultSet.getBoolean(17));

                Main.guests.add(guest);

            }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean insertGuest(Guests guest){
        
        try {
            
            int count = 0;
            
            int privateDriver = (guest.isPrivateDriver()? 1 : 0);
            
            statement = openConnection().createStatement();
            
            String query = "INSERT INTO `guests`(`roomid`, `firstname`, `middlename`, `lastname`, `idcard`, `numofdays`, `gender`, `email`, `phone`, `status`, `address`,"+
                    " `arrivedate`, `foodid`, `carid`, `privatedriver`) VALUES ("+ guest.getRoomId() +" , '"+  guest.getFirstname() +"' , '"+  guest.getMiddlename() +"' , '"+
                    guest.getLastname() + "' , '"+ guest.getIdCard() +"' ,"+ guest.getNumOfDays() +" , '"+ guest.getGender() +"' , '"+ guest.getEmail() +
                    "' , '"+ guest.getPhone() +"', '"+ guest.getStatus() +"' , '"+ guest.getAddress() +"' , '"+ guest.getArriveDate() +"' , "+ guest.getFoodId() +" , "+
                    guest.getCarId() +" , "+ privateDriver +" );";
            
            String query1 = "SELECT `timesofreservation` FROM `rooms` WHERE `id` = "+ guest.getRoomId() +" ;";
            
            System.out.println(query1);
            
            resultSet = statement.executeQuery(query1);
            
            while(resultSet.next()){
                count = resultSet.getInt("timesofreservation");
            }
            
            count++;
            
            String query2 = "UPDATE `rooms` SET `isreserved` = "+ 1 +", `timesofreservation` = "+ count +" , `lastcheckin` = '"+ guest.getArriveDate() +"' WHERE `id` = "+ guest.getRoomId() +" ;";
            
            System.out.println(query2);
            
            System.out.println(query);
            
            
            
            statement.executeUpdate(query);
            
            statement.executeUpdate(query2);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
        
    }
    
    public boolean updateGuest(Guests guest){
        try {
            
            String query ="UPDATE `guests` SET `checkoutdate` = '" + guest.getCheckoutDate() + "' WHERE `id` = "+ guest.getId() +" ;";
            
            String query2 = "Update `rooms` SET `isreserved` = "+ 0 +" , WHERE `id` = "+ guest.getRoomId() +" ;";

            statement = openConnection().createStatement();
            statement.executeUpdate(query);
            statement.executeUpdate(query2);
            
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public boolean getBillInfo(Guests guest){
        try {
            
            Main.food.clear();
            Main.cars.clear();
            Main.rooms.clear();
            
            statement = openConnection().createStatement();
            
            String query = "SELECT * FROM `food` WHERE id = "+ guest.getFoodId() +" ;";
            resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                Food food = new Food(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3));
                Main.food.add(food);
            }
            
            String query1 = "SELECT * FROM `cars` WHERE id = "+ guest.getCarId() +" ;";
            resultSet = statement.executeQuery(query1);
            
            while(resultSet.next()){
                Cars car = new Cars(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3));
                Main.cars.add(car);
            }
            
            String query2 = "SELECT * FROM `rooms` WHERE id = "+ guest.getRoomId() +" ;";
            resultSet = statement.executeQuery(query2);
            
            while(resultSet.next()){
                Rooms room = new Rooms();
                room.setId(resultSet.getInt(1));
                room.setType(resultSet.getString(2));
                room.setView(resultSet.getString(3));
                room.setIsSmokeingAvaliable(resultSet.getBoolean(4));
                room.setRate(resultSet.getDouble(5));
                room.setIsReserved(resultSet.getBoolean(6));
                room.setCostPerNight(resultSet.getDouble(7));
                room.setTimeOfReservation(resultSet.getLong(8));
                room.setLastCheckinDate(resultSet.getDate(9));
                room.setPhoto(resultSet.getString(10));
                room.setIsDeactived(resultSet.getBoolean(11));

                Main.rooms.add(room);

            }
            

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }

    
}
