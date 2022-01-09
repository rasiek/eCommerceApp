package fr.cristhiancasierra.prenApp.Repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import fr.cristhiancasierra.prenApp.dao.SellerDao;
import fr.cristhiancasierra.prenApp.db.AppDatabase;
import fr.cristhiancasierra.prenApp.entities.Seller;

public class SellerRepository {

    private SellerDao sellerDao;
    private long sellerId;


    public SellerRepository(Application application) {

        AppDatabase db = AppDatabase.getDatabase(application);
        sellerDao = db.sellerDao();

    }

    public long insert(Seller seller) {
        AppDatabase.dataWriteExecutor.execute(()-> {
            long sId = sellerDao.insertSeller(seller);
            sellerId = sId;
        });

        return sellerId;
    }

    public LiveData<Seller> getSellerById(long sId) {

        return sellerDao.getSellerById(sId);
    }
}
