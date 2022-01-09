package fr.cristhiancasierra.prenApp.dao;

import androidx.room.Dao;
import androidx.room.Insert;

import fr.cristhiancasierra.prenApp.entities.CartProduct;

@Dao
public interface CartProductDao {

    @Insert
    long insert(CartProduct cartProduct);




}
