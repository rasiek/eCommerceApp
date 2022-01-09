package fr.cristhiancasierra.prenApp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class ClientSavedStateViewModel extends ViewModel {

    private SavedStateHandle state;
    private int id;

    public ClientSavedStateViewModel(SavedStateHandle savedStateHandle) {
        this.state = savedStateHandle;
        id = savedStateHandle.get("id");
    }

    public void setId(int id) {
        state.set("id", id);
    }

    public int getId() {
        return id;
    }
}
