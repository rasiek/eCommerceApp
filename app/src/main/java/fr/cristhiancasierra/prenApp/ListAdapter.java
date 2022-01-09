package fr.cristhiancasierra.prenApp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.cristhiancasierra.prenApp.entities.Product;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    List<Product> productList;

    public ListAdapter(List<Product> list){
        this.productList= list;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_adapter
                ,parent,false)) ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setDetails(productList.get(position));
       // holder.setDetails(Product);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nameTw, priceTw;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTw = itemView.findViewById(R.id.nom_produit);
            priceTw = itemView.findViewById(R.id.price_produit);
        }
        void setDetails(Product p){
            nameTw.setText(p.getName());
            priceTw.setText(p.getPrice());
        }

    }



}

