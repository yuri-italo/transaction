package org.example.proxy;

import org.example.model.Seller;

import java.lang.reflect.Proxy;
import java.util.UUID;

public class JavaProxySeller implements Seller {
    private final Seller seller;
    private final Seller proxy;

    public JavaProxySeller(Seller seller) {
        this.seller = seller;

        this.proxy = (Seller) Proxy.newProxyInstance(
                Seller.class.getClassLoader(),
                new Class[]{Seller.class},
                new SellerInvocationHandler(seller));
    }

    @Override
    public boolean registerSeller(UUID uuid, String name, int rating) {
        return proxy.registerSeller(uuid, name, rating);
    }
}
