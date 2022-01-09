package fr.cristhiancasierra.prenApp.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


import fr.cristhiancasierra.prenApp.entities.Order;

@Dao
public interface OrderDao {

    @Query("Select * from `order`")
    LiveData<List<Order>> getAllOrders();

    @Insert
    long insertOrder(Order order);

    @Update
    void updateOrder(Order order);

    @Delete
    void deleteOrder(Order order);

    @Query("SELECT * from `order` where sellerId = :sId")
    LiveData<List<Order>> getOrdersBySeller(long sId);

    @Query("DELETE from `order`")
    void deleteAll();

}
