package org.example;

import org.example.factories.SellerFactory;
import org.example.factories.enums.FactoryEnum;
import org.example.model.Seller;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        System.out.println("Register Seller - NON_PROXY");
        Seller seller = SellerFactory.getFactory(FactoryEnum.NON_PROXY).createSeller();
        seller.registerSeller(UUID.randomUUID(),"Padaria Mix Pão",4);

        System.out.println("----------------------------------------------------------");

        System.out.println("Register Seller - PROXY_PATTERN");
        Seller seller2 = SellerFactory.getFactory(FactoryEnum.PROXY).createSeller();
        seller2.registerSeller(UUID.randomUUID(),"Papelaria do João",5);

        System.out.println("----------------------------------------------------------");

        System.out.println("Register Seller - JAVA_PROXY");
        Seller seller3 = SellerFactory.getFactory(FactoryEnum.JAVA_PROXY).createSeller();
        seller3.registerSeller(UUID.randomUUID(),"Clinica Pet e Saúde",2);

    }
}