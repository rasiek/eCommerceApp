package fr.cristhiancasierra.prenApp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.cristhiancasierra.prenApp.entities.Promotion;

public class ListeAdapterPromos extends RecyclerView.Adapter<ListeAdapterPromos.MyViewHolder> {

    List<Promotion> promosList;
    public ListeAdapterPromos(List<Promotion> list){
        this.promosList= list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.liste_adapter_promos
                ,parent,false)) ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setDetails(promosList.get(position));

    }

    @Override
    public int getItemCount() {
        return promosList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView idProduitTw, prixTw, dreeTw;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            idProduitTw = itemView.findViewById(R.id.id_promos);
            prixTw = itemView.findViewById(R.id.prix_promos);
            dreeTw = itemView.findViewById(R.id.duree);
        }

        void setDetails(Promotion pr) {
            idProduitTw.setText(pr.getProductId());
            prixTw.setText((int) pr.getReduction());
            dreeTw.setText((CharSequence) pr.getDateEnd());
        }
    }
}
