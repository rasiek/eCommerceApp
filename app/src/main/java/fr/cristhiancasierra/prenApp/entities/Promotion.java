package fr.cristhiancasierra.prenApp.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "promotion")
public class Promotion {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int sellerId;
    private int productId;
    private Date dateStart;
    private Date DateEnd;
    private float reduction;


    public Promotion(int sellerId, int productId, Date dateStart, Date dateEnd, float reduction) {
        this.sellerId = sellerId;
        this.productId = productId;
        this.dateStart = dateStart;
        DateEnd = dateEnd;
        this.reduction = reduction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return DateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        DateEnd = dateEnd;
    }

    public float getReduction() {
        return reduction;
    }

    public void setReduction(float reduction) {
        this.reduction = reduction;
    }
}
