package fr.cristhiancasierra.prenApp.viewHolders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import fr.cristhiancasierra.prenApp.R;
import fr.cristhiancasierra.prenApp.adapters.OrderListAdapter;
import fr.cristhiancasierra.prenApp.entities.CartWithProducts;
import fr.cristhiancasierra.prenApp.entities.Order;

public class OrderListViewHolder extends RecyclerView.ViewHolder {

    private TextView orderId, orderDate;


    public OrderListViewHolder(@NonNull View itemView) {
        super(itemView);

        orderId = itemView.findViewById(R.id.order_id_item);
        orderDate = itemView.findViewById(R.id.date_order_item);
    }

    public void bind (Order order) {

        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        orderId.setText(order.getId());
        orderDate.setText(dateFormat.format(order.getDateOrder()));

    }

    public static OrderListViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_item, parent, false);

        return new OrderListViewHolder(view);
    }
}
