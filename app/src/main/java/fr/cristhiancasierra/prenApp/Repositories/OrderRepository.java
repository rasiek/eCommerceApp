package fr.cristhiancasierra.prenApp.Repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import fr.cristhiancasierra.prenApp.dao.OrderDao;
import fr.cristhiancasierra.prenApp.db.AppDatabase;
import fr.cristhiancasierra.prenApp.entities.Order;

public class OrderRepository {

    private OrderDao orderDao;
    private long orderId;


    public OrderRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);

        orderDao = db.orderDao();
    }

    public long insert(Order order) {

        AppDatabase.dataWriteExecutor.execute(()-> {
            long id = orderDao.insertOrder(order);
            orderId = id;
        });

        return orderId;
    }

    public LiveData<List<Order>> getOrdersBySeller(long sellerId){

        return orderDao.getOrdersBySeller(sellerId);
    }
}
