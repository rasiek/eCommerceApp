package fr.cristhiancasierra.prenApp.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import fr.cristhiancasierra.prenApp.Repositories.ProductRepository;
import fr.cristhiancasierra.prenApp.entities.Product;

public class ProductViewModel extends AndroidViewModel {

    private ProductRepository productRepository;


    public ProductViewModel(@NonNull Application application) {
        super(application);

        productRepository = new ProductRepository(application);

    }

    public LiveData<Product> getProductById(long id) {
        return productRepository.getProductById(id);
    }


}
