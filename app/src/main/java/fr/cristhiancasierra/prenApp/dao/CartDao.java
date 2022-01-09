package fr.cristhiancasierra.prenApp.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import fr.cristhiancasierra.prenApp.entities.Cart;

@Dao
public interface CartDao {


    @Insert
    long insert(Cart cart);

    @Query("SELECT * from cart WHERE id = :cId")
    LiveData<Cart> getCartById(long cId);


}
