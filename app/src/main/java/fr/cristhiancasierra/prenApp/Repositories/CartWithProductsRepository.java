package fr.cristhiancasierra.prenApp.Repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import fr.cristhiancasierra.prenApp.dao.CartProductDao;
import fr.cristhiancasierra.prenApp.dao.CartWithProductsDao;
import fr.cristhiancasierra.prenApp.db.AppDatabase;
import fr.cristhiancasierra.prenApp.entities.CartProduct;
import fr.cristhiancasierra.prenApp.entities.CartWithProducts;

public class CartWithProductsRepository {

    private CartWithProductsDao cartProductDao;
    private LiveData<List<CartWithProducts>> allCartProducts;

    public CartWithProductsRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        cartProductDao = db.cartWithProductsDao();

    }

    public LiveData<List<CartWithProducts>> getAllCartProducts(long cartId) {

        allCartProducts = cartProductDao.getCartWithProducts(cartId);
        return allCartProducts;
    }
}
