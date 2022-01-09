package fr.cristhiancasierra.prenApp.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import fr.cristhiancasierra.prenApp.Repositories.CartWithProductsRepository;
import fr.cristhiancasierra.prenApp.Repositories.ClientRepository;
import fr.cristhiancasierra.prenApp.entities.CartWithProducts;
import fr.cristhiancasierra.prenApp.entities.Client;

public class CartWithProductsViewModel extends AndroidViewModel {

    private CartWithProductsRepository cartWithProductsRepository;
    private LiveData<List<CartWithProducts>> carWithProductsList;

    public CartWithProductsViewModel(@NonNull Application application) {
        super(application);

        cartWithProductsRepository = new CartWithProductsRepository(application);
    }

    public LiveData<List<CartWithProducts>> getCarWithProductsList(long cartId) {
        carWithProductsList = cartWithProductsRepository.getAllCartProducts(cartId);
        return carWithProductsList;
    }
}
