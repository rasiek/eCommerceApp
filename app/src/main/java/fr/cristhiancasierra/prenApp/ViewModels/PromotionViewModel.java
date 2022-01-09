package fr.cristhiancasierra.prenApp.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import fr.cristhiancasierra.prenApp.Repositories.PromotionRepository;
import fr.cristhiancasierra.prenApp.entities.Promotion;

public class PromotionViewModel extends AndroidViewModel {

    private PromotionRepository promotionRepository;

    public PromotionViewModel(@NonNull Application application) {
        super(application);
        promotionRepository = new PromotionRepository(application);

    }

    public long insert(Promotion promotion) {
        long pId = promotionRepository.insert(promotion);
        return pId;
    }

    public LiveData<List<Promotion>> getPromosBySeller(long sId) {
        return promotionRepository.getPromosBySeller(sId);
    }

}
