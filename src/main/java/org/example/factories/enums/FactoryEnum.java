package org.example.factories.enums;

import org.example.factories.JavaProxySellerFactory;
import org.example.factories.ProxyPatternSellerFactory;
import org.example.factories.RealSellerFactory;
import org.example.factories.SellerFactory;

public enum FactoryEnum {
    PROXY(new ProxyPatternSellerFactory()),
    NON_PROXY(new RealSellerFactory()),
    JAVA_PROXY(new JavaProxySellerFactory());
    private final SellerFactory sellerFactory;

    FactoryEnum(SellerFactory sellerFactory) {
        this.sellerFactory = sellerFactory;
    }

    public SellerFactory getSellerFactory() {
        return sellerFactory;
    }
}
