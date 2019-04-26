
package Models;

import java.sql.Date;

/**
 *
 * @author Sara
 */
public class Guests {
    
    private long id;
    private long roomId;
    private String firstname;
    private String middlename;
    private String lastname;
    private String idCard;
    private long numOfDays;
    private String gender;
    private String email;
    private String phone;
    private String status;
    private String address;
    private Date arriveDate;
    private Date checkoutDate;
    private long foodId;
    private long carId;
    private boolean privateDriver;

    public Guests() {
    }

    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public long getNumOfDays() {
        return numOfDays;
    }

    public void setNumOfDays(long numOfDays) {
        this.numOfDays = numOfDays;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(Date arriveDate) {
        this.arriveDate = arriveDate;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public long getFoodId() {
        return foodId;
    }

    public void setFoodId(long foodId) {
        this.foodId = foodId;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public boolean isPrivateDriver() {
        return privateDriver;
    }

    public void setPrivateDriver(boolean privateDriver) {
        this.privateDriver = privateDriver;
    }

    @Override
    public String toString() {
        return "Guests{" + "id=" + id + ", roomId=" + roomId + ", firstname=" + firstname + ", middlename=" + middlename + ", lastname=" + lastname + ", idCard=" + idCard + ", numOfDays=" + numOfDays + ", gender=" + gender + ", email=" + email + ", phone=" + phone + ", status=" + status + ", address=" + address + ", arriveDate=" + arriveDate + ", checkoutDate=" + checkoutDate + ", foodId=" + foodId + ", carId=" + carId + ", privateDriver=" + privateDriver + '}';
    }
    
    
    
    
}
