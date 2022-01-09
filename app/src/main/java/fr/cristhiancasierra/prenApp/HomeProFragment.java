package fr.cristhiancasierra.prenApp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavArgument;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeProFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeProFragment extends Fragment {

    private NavInflater navInflater;
    private NavGraph graph;
    private NavArgument argument;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //
    ImageButton productButton;
    ImageButton ordersButton;
    ImageButton promosButton;
    ImageButton accountProButton;
    ImageButton logoutButton;

    public HomeProFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeProFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeProFragment newInstance(String param1, String param2) {
        HomeProFragment fragment = new HomeProFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home_pro, container, false);

        productButton = (ImageButton)view.findViewById(R.id.products_btn);
        productButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_homeProFragment_to_productsFragment);
            }
        });
        ordersButton = (ImageButton)view.findViewById(R.id.orders_btn);
        ordersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_homeProFragment_to_ordersFragment);
            }
        });

        promosButton = (ImageButton)view.findViewById(R.id.promos_btn);
        promosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_homeProFragment_to_promotionsFragment);
            }
        });

        accountProButton = (ImageButton)view.findViewById(R.id.account_pro_btn);
        accountProButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_homeProFragment_to_accountProFragment);
            }
        });

        logoutButton = (ImageButton)view.findViewById(R.id.logout_btn);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), SplashActivity.class));
            }
        });
        return view;
    }

}
