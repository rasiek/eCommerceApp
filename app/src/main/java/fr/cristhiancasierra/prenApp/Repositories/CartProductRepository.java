package fr.cristhiancasierra.prenApp.Repositories;

import android.app.Application;

import fr.cristhiancasierra.prenApp.dao.CartProductDao;
import fr.cristhiancasierra.prenApp.db.AppDatabase;
import fr.cristhiancasierra.prenApp.entities.CartProduct;

public class CartProductRepository {

    private CartProductDao cartProductDao;
    private long cartPId;


    public CartProductRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        cartProductDao = db.cartProductDao();

    }

    public long insert(CartProduct cartProduct) {

        AppDatabase.dataWriteExecutor.execute(() -> {

            long id = cartProductDao.insert(cartProduct);
            cartPId = id;

        });
        return cartPId;
    }


}
