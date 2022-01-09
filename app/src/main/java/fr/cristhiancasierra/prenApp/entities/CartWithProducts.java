package fr.cristhiancasierra.prenApp.entities;

import androidx.room.Dao;
import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;
import java.util.Objects;


public class CartWithProducts {

    public @Embedded CartProduct cartProduct;

    @Relation(parentColumn = "productId",
                entityColumn = "id")
    public Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartWithProducts that = (CartWithProducts) o;
        return cartProduct.equals(that.cartProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartProduct);
    }
}
