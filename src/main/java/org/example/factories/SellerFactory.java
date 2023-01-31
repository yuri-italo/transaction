package org.example.factories;

import org.example.model.Seller;
import org.example.factories.enums.FactoryEnum;

public interface SellerFactory {
    Seller createSeller();

    static SellerFactory getFactory(FactoryEnum factoryEnum) {
        return factoryEnum.getSellerFactory();
    }
}
