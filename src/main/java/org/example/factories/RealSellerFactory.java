package org.example.factories;

import org.example.model.Seller;
import org.example.model.RealSeller;

public class RealSellerFactory implements SellerFactory {
    @Override
    public Seller createSeller() {
        return new RealSeller();
    }
}
