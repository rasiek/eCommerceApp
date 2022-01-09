package fr.cristhiancasierra.prenApp.entities;


import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity(tableName = "order",
        foreignKeys = {
        @ForeignKey(entity = Seller.class,
                    parentColumns = "id",
                    childColumns = "sellerId"
        )
        })
public class Order {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String status;
    private String clientName;
    private String clientEmail;
    private String clientAddress;
    private String clientPhone;
    private long sellerId;
    private Date dateOrder;

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public Order(String status, String clientName, String clientEmail, String clientAddress, String clientPhone, long sellerId, Date dateOrder) {
        this.status = status;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.clientAddress = clientAddress;
        this.clientPhone = clientPhone;
        this.sellerId = sellerId;
        this.dateOrder = dateOrder;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
