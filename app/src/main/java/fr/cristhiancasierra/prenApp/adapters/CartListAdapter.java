package fr.cristhiancasierra.prenApp.adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import fr.cristhiancasierra.prenApp.entities.CartWithProducts;
import fr.cristhiancasierra.prenApp.viewHolders.CartItemViewHolder;

public class CartListAdapter extends ListAdapter<CartWithProducts, CartItemViewHolder> {



    public CartListAdapter(@NonNull DiffUtil.ItemCallback<CartWithProducts> diffCallback) {
        super(diffCallback);

    }

    protected CartListAdapter(@NonNull AsyncDifferConfig<CartWithProducts> config) {
        super(config);
    }

    @NonNull
    @Override
    public CartItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return CartItemViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull CartItemViewHolder holder, int position) {
        CartWithProducts current = getItem(position);
        holder.bind(current);

    }

    public static class CartProductDiff extends DiffUtil.ItemCallback<CartWithProducts> {

        @Override
        public boolean areItemsTheSame(@NonNull CartWithProducts oldItem, @NonNull CartWithProducts newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull CartWithProducts oldItem, @NonNull CartWithProducts newItem) {
            return oldItem.equals(newItem);
        }
    }
}
