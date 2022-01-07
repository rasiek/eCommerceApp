package fr.cristhiancasierra.prenApp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import fr.cristhiancasierra.prenApp.ViewModels.ClientViewModel;
import fr.cristhiancasierra.prenApp.dao.ClientDao;
import fr.cristhiancasierra.prenApp.db.AppDatabase;
import fr.cristhiancasierra.prenApp.entities.Client;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment {


    private Button btn;
    private LinearLayout layout;
    private Client client;
    private ClientViewModel clientViewModel;


    public CartFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*clientViewModel = new ViewModelProvider(requireActivity()).get(ClientViewModel.class);*/
        /*client = new Client("Cristhian", "Casierra", "cc@tst.com",
                "12345", "570 Route de Ganges", "Montpellier");*/

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        btn = new Button(getContext());

        btn.setText("Db Test");
        layout = view.findViewById(R.id.cart_fragment);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clientViewModel = new ViewModelProvider(requireActivity()).get(ClientViewModel.class);

                /*client = new Client("Camilo", "Casierra", "cc@tst.com",
                        "12345", "570 Route de Ganges", "Montpellier");*/

                /*clientViewModel.insert(client);*/
                /*clientDao = AppDatabase.getDatabase(requireActivity()).clientDao();

                clientDao.insertClient(client);*/


                /*clientViewModel.getAllClients()
                    .observe(requireActivity(), clients -> {

                        System.out.println(clients.size());
                    for (Client c:
                         clients) {
                        TextView tw = new TextView(getContext());
                        tw.setText(String.valueOf(c.getId()));
                        layout.addView(tw);
                    }
                });*/

            }
        });


        btn.setGravity(Gravity.CENTER_HORIZONTAL);

        layout.addView(btn);

        return view;
    }
}