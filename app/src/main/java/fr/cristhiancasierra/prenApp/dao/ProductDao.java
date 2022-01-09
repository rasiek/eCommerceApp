package fr.cristhiancasierra.prenApp.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import fr.cristhiancasierra.prenApp.entities.Product;

@Dao
public interface ProductDao {


    @Insert
    long insert(Product product);

    @Query("SELECT * FROM product WHERE id = :pId")
    LiveData<Product> getProductById(long pId);

    @Query("SELECT * from product")
    LiveData<List<Product>> getAllProducts();
}
