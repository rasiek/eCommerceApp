package fr.cristhiancasierra.prenApp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import fr.cristhiancasierra.prenApp.ViewModels.CartWithProductsViewModel;
import fr.cristhiancasierra.prenApp.ViewModels.ClientViewModel;
import fr.cristhiancasierra.prenApp.ViewModels.ProductViewModel;
import fr.cristhiancasierra.prenApp.adapters.CartListAdapter;
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
    private CartWithProductsViewModel cartWithProductsViewModel;
    private RecyclerView cartRecyclerView;
    private long cartId;


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
        cartRecyclerView = view.findViewById(R.id.cart_recycler_view);
        final CartListAdapter cartListAdapter = new CartListAdapter(new CartListAdapter.CartProductDiff());

        cartRecyclerView.setAdapter(cartListAdapter);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        cartId = new Long(10);
        cartWithProductsViewModel = new ViewModelProvider(requireActivity()).get(CartWithProductsViewModel.class);


        cartWithProductsViewModel.getCarWithProductsList(cartId).observe(getViewLifecycleOwner(), list -> {
            cartListAdapter.submitList(list);
        });

        return view;
    }
}