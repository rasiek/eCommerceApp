package fr.cristhiancasierra.prenApp.Repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import fr.cristhiancasierra.prenApp.dao.ClientDao;
import fr.cristhiancasierra.prenApp.db.AppDatabase;
import fr.cristhiancasierra.prenApp.entities.Client;

public class ClientRepository {

    private ClientDao clientDao;
    private LiveData<List<Client>> allClients;
    private long id;
    private LiveData<Client> client;


    public ClientRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        clientDao = db.clientDao();
        allClients = clientDao.getAllClients();
    }

    public LiveData<List<Client>> getAllClients() {
        return allClients;
    }

    public long insert(Client client) {

        AppDatabase.dataWriteExecutor.execute(()-> {
            long id = clientDao.insertClient(client);
            this.id = id;
        });

        return this.id;
    }

    public LiveData<Client> getClientById(int id) {
        client = clientDao.getClientById(id);
        return client;
    }

    public LiveData<Client> getClientByPass(String pass, String email) {
        client = clientDao.getClientByPass(pass, email);
        return client;
    }

    public void updateClient(Client client) {

        AppDatabase.dataWriteExecutor.execute(()-> {
            clientDao.updateClient(client);
        });
    }
}
