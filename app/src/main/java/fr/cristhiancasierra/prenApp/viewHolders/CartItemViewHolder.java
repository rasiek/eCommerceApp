package fr.cristhiancasierra.prenApp.viewHolders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fr.cristhiancasierra.prenApp.R;
import fr.cristhiancasierra.prenApp.entities.CartWithProducts;

public class CartItemViewHolder extends RecyclerView.ViewHolder {


    private TextView productName;
    private ImageView productImg;
    private TextView productQty;
    private TextView productPrice;

    public CartItemViewHolder(@NonNull View itemView) {
        super(itemView);
        productImg = itemView.findViewById(R.id.img_item_cart);
        productName = itemView.findViewById(R.id.title_item_cart);
        productQty = itemView.findViewById(R.id.qty_item_cart);
        productPrice = itemView.findViewById(R.id.price_item_cart);
    }

    public void bind (CartWithProducts cartWithProducts) {

        productImg.setImageResource(cartWithProducts.product.getSrc());
        productName.setText(cartWithProducts.product.getName());
        productQty.setText(cartWithProducts.cartProduct.getQty());
        productPrice.setText(cartWithProducts.product.getPrice());

    }

    public static CartItemViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_item, parent, false);

        return new CartItemViewHolder(view);
    }
}
