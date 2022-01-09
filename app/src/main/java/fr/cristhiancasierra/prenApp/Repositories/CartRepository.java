package fr.cristhiancasierra.prenApp.Repositories;

import android.app.Application;

import fr.cristhiancasierra.prenApp.dao.CartDao;
import fr.cristhiancasierra.prenApp.db.AppDatabase;
import fr.cristhiancasierra.prenApp.entities.Cart;

public class CartRepository
{
    private CartDao cartDao;
    private long cartId;


    public CartRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        cartDao = db.cartDao();
    }

    public long insert(Cart cart) {
        AppDatabase.dataWriteExecutor.execute(()-> {
            long id = cartDao.insert(cart);
            cartId = id;
        });

        return cartId;
    }
}
