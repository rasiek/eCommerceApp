package fr.cristhiancasierra.prenApp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import fr.cristhiancasierra.prenApp.ViewModels.ClientViewModel;
import fr.cristhiancasierra.prenApp.entities.Client;


public class HomeClientFragment extends Fragment {

    private TextView title;
    private long idLong;
    private int id;
    private Client client;
    private ClientViewModel clientViewModel;

    public HomeClientFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_client, container, false);
        clientViewModel = new ViewModelProvider(requireActivity()).get(ClientViewModel.class);
        title = view.findViewById(R.id.title_home);


        idLong = getArguments().getLong("id");

        id = (int) idLong;

        clientViewModel.getClientById(id).observe(requireActivity(), clientBd -> {

            Client client = clientBd;
            System.out.println(clientBd.getFirstname());
            System.out.println(clientBd.getFirstname());
            System.out.println(clientBd.getFirstname());
            System.out.println(clientBd.getFirstname());
            System.out.println(clientBd.getFirstname());
            System.out.println(clientBd.getFirstname());
            System.out.println(clientBd.getFirstname());
            this.client = client;

        });

        title.setText(client.getFirstname());

        return view;
    }
}