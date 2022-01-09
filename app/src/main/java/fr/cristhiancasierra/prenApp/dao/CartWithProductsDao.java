package fr.cristhiancasierra.prenApp.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import fr.cristhiancasierra.prenApp.entities.CartProduct;
import fr.cristhiancasierra.prenApp.entities.CartWithProducts;

@Dao
public interface CartWithProductsDao {


    @Query("SELECT * FROM cart_product WHERE cartId = :cartId")
    LiveData<List<CartWithProducts>> getCartWithProducts(long cartId);
}
