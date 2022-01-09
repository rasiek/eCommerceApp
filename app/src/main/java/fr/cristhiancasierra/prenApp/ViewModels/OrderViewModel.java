package fr.cristhiancasierra.prenApp.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import fr.cristhiancasierra.prenApp.Repositories.OrderRepository;
import fr.cristhiancasierra.prenApp.entities.Order;

public class OrderViewModel extends AndroidViewModel {

    private OrderRepository orderRepository;

    public OrderViewModel(@NonNull Application application) {
        super(application);

        orderRepository = new OrderRepository(application);

    }

    public LiveData<List<Order>> getOrdersBySeller(long sId) {
        return orderRepository.getOrdersBySeller(sId);
    }

    public long insert(Order order) {
        long oId = orderRepository.insert(order);
        return oId;
    }


}
