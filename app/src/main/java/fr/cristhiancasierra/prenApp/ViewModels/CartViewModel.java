package fr.cristhiancasierra.prenApp.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import fr.cristhiancasierra.prenApp.Repositories.CartRepository;
import fr.cristhiancasierra.prenApp.entities.Cart;

public class CartViewModel extends AndroidViewModel {

    private CartRepository cartRepository;

    public CartViewModel(@NonNull Application application) {
        super(application);

        cartRepository = new CartRepository(application);

    }

    public long insert(Cart cart) {
        long cId = cartRepository.insert(cart);
        return cId;
    }
}
