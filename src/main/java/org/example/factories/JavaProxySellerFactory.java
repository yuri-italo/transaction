package org.example.factories;

import org.example.model.RealSeller;
import org.example.proxy.JavaProxySeller;
import org.example.model.Seller;

public class JavaProxySellerFactory implements SellerFactory {
    @Override
    public Seller createSeller() {
        return new JavaProxySeller(new RealSeller());
    }
}
