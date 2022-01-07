package fr.cristhiancasierra.prenApp.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import fr.cristhiancasierra.prenApp.Repositories.ClientRepository;
import fr.cristhiancasierra.prenApp.entities.Client;

public class ClientViewModel extends AndroidViewModel {

    private ClientRepository clientRepository;
    private LiveData<List<Client>> allClients;
    private LiveData<Client> client;
    private long id;

    public ClientViewModel(@NonNull Application application) {
        super(application);

        clientRepository = new ClientRepository(application);
        allClients = clientRepository.getAllClients();
    }

    public LiveData<List<Client>> getAllClients() {
        return allClients;
    }

    public LiveData<Client> getClientById(int id) {

        client = clientRepository.getClientById(id);
        return client;
    }

    public long insert(Client c) {

        Long id = clientRepository.insert(c);

        this.id = id;

        return this.id;
    }

    public void update(Client c) {
        clientRepository.updateClient(c);
    }

}
