package fr.cristhiancasierra.prenApp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import fr.cristhiancasierra.prenApp.entities.Product;
import fr.cristhiancasierra.prenApp.entities.Promotion;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PromotionsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PromotionsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    ImageButton ajoutPromotionBtn;
    List<Promotion> promotionsList = new ArrayList<>();

    public PromotionsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PromotionsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PromotionsFragment newInstance(String param1, String param2) {
        PromotionsFragment fragment = new PromotionsFragment();
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
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_promotions, container, false
        );
        /*
        Promotion promos1 = new Promotion("4", "4,33", "5/02/2022");


        promotionsList.add(promos1);


        RecyclerView recyclerView=view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(new ListAdapter(promotionsList));
*/



        ajoutPromotionBtn = (ImageButton) view.findViewById(R.id.ajoutPomos_btn);
        ajoutPromotionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_promotionsFragment_to_addPromoFragment);
            }
        });
        return view;
    }
}