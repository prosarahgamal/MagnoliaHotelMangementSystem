
package Models;


import java.sql.Date;
import javafx.scene.image.Image;

/**
 *
 * @author Sara
 */
public class Rooms {
    
    private long id;
    private String type;
    private String view;
    private boolean isSmokeingAvaliable;
    private boolean isReserved;
    private double rate;
    private double costPerNight;
    private long timeOfReservation;
    private Date lastCheckinDate;
    private String photo;
    boolean isDeactived;

    public Rooms() {
        
    }

    public boolean isIsDeactived() {
        return isDeactived;
    }

    public void setIsDeactived(boolean isDeactived) {
        this.isDeactived = isDeactived;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public boolean isIsSmokeingAvaliable() {
        return isSmokeingAvaliable;
    }

    public void setIsSmokeingAvaliable(boolean isSmokeingAvaliable) {
        this.isSmokeingAvaliable = isSmokeingAvaliable;
    }

    public boolean isIsReserved() {
        return isReserved;
    }

    public void setIsReserved(boolean isReserved) {
        this.isReserved = isReserved;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getCostPerNight() {
        return costPerNight;
    }

    public void setCostPerNight(double costPerNight) {
        this.costPerNight = costPerNight;
    }

    public long getTimeOfReservation() {
        return timeOfReservation;
    }

    public void setTimeOfReservation(long timeOfReservation) {
        this.timeOfReservation = timeOfReservation;
    }

    public Date getLastCheckinDate() {
        return lastCheckinDate;
    }

    public void setLastCheckinDate(Date lastCheckinDate) {
        this.lastCheckinDate = lastCheckinDate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Rooms{" + "id=" + id + ", type=" + type + ", view=" + view + ", isSmokeingAvaliable=" + isSmokeingAvaliable + ", isReserved=" + isReserved + ", rate=" + rate + ", costPerNight=" + costPerNight + ", timeOfReservation=" + timeOfReservation + ", lastCheckinDate=" + lastCheckinDate + ", photo=" + photo + ", isDeactived=" + isDeactived + '}';
    }


    
    
    
    
}
