package fr.cristhiancasierra.prenApp.entities;


import androidx.room.Entity;
import androidx.room.ForeignKey;

import java.util.Objects;

@Entity(tableName = "cart_product",
        primaryKeys = {
            "cartId",
                "productId"
        },
        foreignKeys = {
                @ForeignKey(entity = Cart.class,
                        parentColumns = "id",
                        childColumns = "cartId"),
                @ForeignKey(entity = Product.class,
                        parentColumns = "id",
                        childColumns = "productId")
        })
public class CartProduct {

    private long cartId;
    private long productId;
    private int qty;

    public CartProduct(long cartId, long productId, int qty) {
        this.cartId = cartId;
        this.productId = productId;
        this.qty = qty;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartProduct that = (CartProduct) o;
        return cartId == that.cartId && productId == that.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, productId);
    }
}
