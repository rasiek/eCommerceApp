package fr.cristhiancasierra.prenApp.Repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import fr.cristhiancasierra.prenApp.dao.PromotionDao;
import fr.cristhiancasierra.prenApp.db.AppDatabase;
import fr.cristhiancasierra.prenApp.entities.Promotion;

public class PromotionRepository {

    private PromotionDao promotionDao;
    private long promoId;


    public PromotionRepository(Application application) {

        AppDatabase db = AppDatabase.getDatabase(application);
        promotionDao = db.promotionDao();
    }

    public long insert(Promotion promotion) {

        AppDatabase.dataWriteExecutor.execute(()-> {
            long pId = promotionDao.insert(promotion);
            promoId = pId;
        });

        return promoId;
    }

    public LiveData<List<Promotion>> getPromosBySeller(long sId) {
        return promotionDao.getAllPromosBySeller(sId);
    }
}
