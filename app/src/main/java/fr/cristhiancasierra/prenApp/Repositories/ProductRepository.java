package fr.cristhiancasierra.prenApp.Repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import fr.cristhiancasierra.prenApp.dao.ProductDao;
import fr.cristhiancasierra.prenApp.db.AppDatabase;
import fr.cristhiancasierra.prenApp.entities.Product;

public class ProductRepository {

    private ProductDao productDao;
    private LiveData<Product> product;
    private long productId;

    public ProductRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        productDao = db.productDao();
    }

    public LiveData<Product> getProductById(long id) {
        return productDao.getProductById(id);
    }

    public long insert(Product product) {
        AppDatabase.dataWriteExecutor.execute(()-> {
            long pId = productDao.insert(product);
            productId = pId;
        });

        return productId;
    }
}
