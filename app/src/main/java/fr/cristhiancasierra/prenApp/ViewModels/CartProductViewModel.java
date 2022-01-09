package fr.cristhiancasierra.prenApp.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import fr.cristhiancasierra.prenApp.Repositories.CartProductRepository;
import fr.cristhiancasierra.prenApp.entities.Cart;
import fr.cristhiancasierra.prenApp.entities.CartProduct;

public class CartProductViewModel extends AndroidViewModel {

    private CartProductRepository cartProductRepository;


    public CartProductViewModel(@NonNull Application application) {
        super(application);

        cartProductRepository = new CartProductRepository(application);

    }

    public long insert(CartProduct cartProduct) {
        long cPId = cartProductRepository.insert(cartProduct);
        return cPId;
    }

}
