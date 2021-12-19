package fr.cristhiancasierra.prenApp.dao;

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
    List<Client> getListClients();

    @Insert
    void insertClient(Client client);

    @Update
    void updateClient(Client client);

    @Delete
    void deleteClient(Client client);
}
