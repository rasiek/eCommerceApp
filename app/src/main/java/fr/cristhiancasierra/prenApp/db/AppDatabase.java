package fr.cristhiancasierra.prenApp.db;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import fr.cristhiancasierra.prenApp.converters.Converters;
import fr.cristhiancasierra.prenApp.dao.CartDao;
import fr.cristhiancasierra.prenApp.dao.CartProductDao;
import fr.cristhiancasierra.prenApp.dao.CartWithProductsDao;
import fr.cristhiancasierra.prenApp.dao.ClientDao;
import fr.cristhiancasierra.prenApp.dao.OrderDao;
import fr.cristhiancasierra.prenApp.dao.ProductDao;
import fr.cristhiancasierra.prenApp.dao.PromotionDao;
import fr.cristhiancasierra.prenApp.dao.SellerDao;
import fr.cristhiancasierra.prenApp.entities.Cart;
import fr.cristhiancasierra.prenApp.entities.CartProduct;
import fr.cristhiancasierra.prenApp.entities.CartWithProducts;
import fr.cristhiancasierra.prenApp.entities.Client;
import fr.cristhiancasierra.prenApp.entities.Order;
import fr.cristhiancasierra.prenApp.entities.Product;
import fr.cristhiancasierra.prenApp.entities.Promotion;
import fr.cristhiancasierra.prenApp.entities.Seller;

@Database(entities = {Client.class,
                        Seller.class,
                        CartProduct.class,
                        Product.class,
                        Cart.class,
                        Order.class,
                        Promotion.class},
            version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    private static final String DB_NAME = "appDatabase";
    public abstract ClientDao clientDao();
    public abstract SellerDao sellerDao();
    public abstract ProductDao productDao();
    public abstract CartProductDao cartProductDao();
    public abstract CartDao cartDao();
    public abstract PromotionDao promotionDao();
    public abstract OrderDao orderDao();
    public abstract CartWithProductsDao cartWithProductsDao();

    private static AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService dataWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    public static  AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            DB_NAME)
                            .addCallback(emptyDbCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback emptyDbCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            dataWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                ClientDao dao = INSTANCE.clientDao();
                dao.deleteAll();
            });
        }
    };
}
