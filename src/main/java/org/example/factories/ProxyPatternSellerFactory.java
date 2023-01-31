package org.example.factories;

import org.example.model.RealSeller;
import org.example.model.Seller;
import org.example.proxy.ProxyPatternSeller;

public class ProxyPatternSellerFactory implements SellerFactory {
    @Override
    public Seller createSeller() {
        return new ProxyPatternSeller(new RealSeller());
    }
}
