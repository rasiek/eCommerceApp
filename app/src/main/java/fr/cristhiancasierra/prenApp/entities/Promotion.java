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
    private Date dateEnd;
    private float reduction;


    public Promotion(int sellerId, int productId, Date dateStart, Date dateEnd, float reduction) {
        this.sellerId = sellerId;
        this.productId = productId;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.reduction = reduction;
    }

    public Promotion(int productId,float reduction, Date dateEnd) {
        this.productId = productId;
        this.reduction = reduction;
        DateEnd = dateEnd;
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
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public float getReduction() {
        return reduction;
    }

    public void setReduction(float reduction) {
        this.reduction = reduction;
    }
}
