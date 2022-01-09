package fr.cristhiancasierra.prenApp.adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;


import fr.cristhiancasierra.prenApp.entities.Order;
import fr.cristhiancasierra.prenApp.viewHolders.OrderListViewHolder;

public class OrderListAdapter extends ListAdapter<Order, OrderListViewHolder> {


    protected OrderListAdapter(@NonNull DiffUtil.ItemCallback<Order> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public OrderListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return OrderListViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderListViewHolder holder, int position) {

        Order order = getItem(position);
        holder.bind(order);

    }

    public static class OrderDiff extends DiffUtil.ItemCallback<Order> {

        @Override
        public boolean areItemsTheSame(@NonNull Order oldItem, @NonNull Order newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Order oldItem, @NonNull Order newItem) {
            return oldItem.equals(newItem);
        }
    }
}
