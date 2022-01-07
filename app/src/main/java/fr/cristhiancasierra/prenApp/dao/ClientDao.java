package fr.cristhiancasierra.prenApp.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import fr.cristhiancasierra.prenApp.entities.Client;

@Dao
public interface ClientDao {

    @Query("Select * from client")
    LiveData<List<Client>> getAllClients();

    @Insert
    long insertClient(Client client);

    @Update
    void updateClient(Client client);

    @Delete
    void deleteClient(Client client);

    @Query("SELECT * from client where id = :cId")
    LiveData<Client> getClientById(int cId);

    @Query("DELETE from client")
    void deleteAll();

}
