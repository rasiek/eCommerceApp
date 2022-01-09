package fr.cristhiancasierra.prenApp.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import fr.cristhiancasierra.prenApp.Repositories.SellerRepository;
import fr.cristhiancasierra.prenApp.entities.Seller;

public class SellerViewModel extends AndroidViewModel {

    private SellerRepository sellerRepository;

    public SellerViewModel(@NonNull Application application) {
        super(application);

        sellerRepository = new SellerRepository(application);


    }

    public LiveData<Seller> getSellerById(long sId) {
        return sellerRepository.getSellerById(sId);
    }

    public long insert(Seller seller) {
        long sId = sellerRepository.insert(seller);
        return sId;
    }
}
