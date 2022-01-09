package fr.cristhiancasierra.prenApp.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import fr.cristhiancasierra.prenApp.entities.Client;
import fr.cristhiancasierra.prenApp.entities.Seller;


@Dao
public interface SellerDao {

    @Query("Select * from seller")
    List<Seller> getListSellers();

    @Query("SELECT * FROM seller where id = :seller_id")
    LiveData<Seller> getSellerById(long seller_id);

    @Insert
    long insertSeller(Seller seller);

    @Update
    void updateSeller(Seller seller);

    @Delete
    void deleteSeller(Seller seller);
}
