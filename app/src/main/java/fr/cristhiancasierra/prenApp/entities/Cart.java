package fr.cristhiancasierra.prenApp.entities;


import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "cart",
        foreignKeys = @ForeignKey(entity = Client.class,
                                    parentColumns = "id",
                                    childColumns = "clientId"))
public class Cart {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private long clientId;
    private boolean valide;


    public Cart(long clientId, boolean valide) {
        this.clientId = clientId;
        this.valide = valide;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }
}
