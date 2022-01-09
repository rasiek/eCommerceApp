package fr.cristhiancasierra.prenApp.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import fr.cristhiancasierra.prenApp.entities.Promotion;

@Dao
public interface PromotionDao {


    @Insert
    long insert(Promotion promotion);


    @Query("SELECT * from promotion where sellerId = :sId")
    LiveData<List<Promotion>> getAllPromosBySeller(long sId);

}
