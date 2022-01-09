package fr.cristhiancasierra.prenApp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import fr.cristhiancasierra.prenApp.ViewModels.ClientViewModel;
import fr.cristhiancasierra.prenApp.entities.Client;


public class HomeClientFragment extends Fragment {

    private TextView title;
    private long idLong;
    private int id;
    private Client client;
    private ClientViewModel clientViewModel;
    private List<Client> clients;
    private LinearLayout layout;
    private ClientSavedStateViewModel vm;
    private NavBackStackEntry navBackStackEntry;
    private NavController navController;
    public HomeClientFragment() {
        // Required empty public constructor
    }

    public static HomeClientFragment newInstance() {
        HomeClientFragment fragment = new HomeClientFragment();

        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            id = savedInstanceState.getInt("id");
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_client, container, false);
        clientViewModel = new ViewModelProvider(requireActivity()).get(ClientViewModel.class);

        if (clientViewModel.getGetClientId() != 0) {
            this.id = clientViewModel.getGetClientId();
        } else {
            idLong = getArguments().getLong("id");
            id = (int) idLong;
        }
        title = view.findViewById(R.id.title_home);
        layout = view.findViewById(R.id.test_linear);


        if (id != 0) {

            vm.setId(id);

            clientViewModel.getClientById(id).observe(getViewLifecycleOwner(), clientDb -> {

                this.client = clientDb;
                title.setText("Bonjour, " + client.getFirstname());

            });

        } else {

            title.setText("Bonjour");

        }

        return view;
    }
}